package com.example.nWebtoonAPI.service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.constant.ImgDir;
import com.example.nWebtoonAPI.domain.Cartoon;
import com.example.nWebtoonAPI.domain.Episode;
import com.example.nWebtoonAPI.dto.EpisodeContentDto;
import com.example.nWebtoonAPI.dto.EpisodeDto;
import com.example.nWebtoonAPI.dto.EpisodeEditDto;
import com.example.nWebtoonAPI.repository.CartoonRepository;
import com.example.nWebtoonAPI.repository.EpisodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements EpisodeService {

	private final CartoonRepository cartoonRepository;
	private final EpisodeRepository episodeRepository;

	@Override
	public EpisodeDto createEpisode(Long cartoonId, EpisodeDto episodeDto, MultipartFile thumbImg,
		MultipartFile contentImg) throws IOException {

		Optional<Cartoon> res = cartoonRepository.findById(cartoonId);
		if (res.isEmpty()) {
			throw new IllegalArgumentException("존재하지 않는 웹툰입니다.");
		}

		Episode episode = new Episode();
		episode.setTitle(episodeDto.getTitle());
		episode.setGrade(0);
		episode.setCount(0);
		episode.setCartoon(res.get());
		Episode savedEpisode = episodeRepository.save(episode);

		Long episodeId = savedEpisode.getEpisodeId();
		String contentDirPath = ImgDir.imgPath + cartoonId + "/" + "episodes/" + episodeId + "/" + "content/";
		createFolder(contentDirPath);

		String thumbnailDirPath = ImgDir.imgPath + cartoonId + "/" + "episodes/" + episodeId + "/" + "thumbnail/";
		createFolder(thumbnailDirPath);

		String resContentFileName = saveImgFile(contentImg, contentDirPath);
		String resThumbFileName = saveImgFile(thumbImg, thumbnailDirPath);

		savedEpisode.setThumbImgName(resThumbFileName);
		savedEpisode.setThumbImgUrl(thumbnailDirPath + resThumbFileName);
		savedEpisode.setContentImgName(resContentFileName);
		savedEpisode.setContentImgUrl(contentDirPath + resContentFileName);
		Episode resEpisode = episodeRepository.save(savedEpisode);
		BeanUtils.copyProperties(resEpisode, episodeDto);

		Cartoon cartoon = res.get();
		cartoon.setTotalEpisode(cartoon.getTotalEpisode() + 1);
		cartoonRepository.save(cartoon);

		return episodeDto;
	}

	@Override
	public EpisodeContentDto getEpisode(Long cartoonId, Long episodeId) {
		Optional<Episode> res = episodeRepository.findById(episodeId);
		if (res.isEmpty()) {
			throw new IllegalArgumentException("존재하지 않는 회차입니다.");
		}
		Optional<Cartoon> resCartoon = cartoonRepository.findById(cartoonId);
		Cartoon cartoon = resCartoon.get();
		cartoon.setViews(cartoon.getViews() + 1);
		cartoonRepository.save(cartoon);

		EpisodeContentDto episodeContentDto = new EpisodeContentDto();
		Episode episode = res.get();
		BeanUtils.copyProperties(episode, episodeContentDto);

		return episodeContentDto;
	}

	@Override
	public EpisodeEditDto updateEpisode(Long cartoonId, Long episodeId, EpisodeEditDto episodeEditDto,
		MultipartFile thumbImg, MultipartFile contentImg) throws IOException {

		Optional<Episode> res = episodeRepository.findById(episodeId);
		if (res.isEmpty()) {
			throw new IllegalArgumentException("존재하지 않는 회차입니다.");
		}
		Episode episode = res.get();
		episode.setTitle(episodeEditDto.getTitle());

		if (thumbImg != null) {
			String thumbImgUrl = episode.getThumbImgUrl();
			File file = new File(thumbImgUrl);
			file.delete();

			String thumbnailDirPath = ImgDir.imgPath + cartoonId + "/" + "episodes/" + episodeId + "/" + "thumbnail/";
			String resThumbFileName = saveImgFile(thumbImg, thumbnailDirPath);
			episode.setThumbImgName(resThumbFileName);
			episode.setThumbImgUrl(thumbnailDirPath + resThumbFileName);
		}

		if (contentImg != null) {
			String contentImgUrl = episode.getContentImgUrl();
			File file = new File(contentImgUrl);
			file.delete();

			String contentDirPath = ImgDir.imgPath + cartoonId + "/" + "episodes/" + episodeId + "/" + "content/";
			String resContentFileName = saveImgFile(contentImg, contentDirPath);
			episode.setContentImgName(resContentFileName);
			episode.setContentImgUrl(contentDirPath + resContentFileName);
		}

		Episode savedEpisode = episodeRepository.save(episode);
		BeanUtils.copyProperties(savedEpisode, episodeEditDto);
		return episodeEditDto;
	}

	@Override
	public void deleteEpisode(Long cartoonId, Long episodeId) throws IOException {
		Optional<Episode> res = episodeRepository.findById(episodeId);
		if (res.isEmpty()) {
			throw new IllegalArgumentException("존재하지 않는 회차입니다.");
		}
		String path = ImgDir.imgPath + cartoonId + "/" + "episodes/" + episodeId;
		File folder = new File(path);
		FileUtils.cleanDirectory(folder);
		folder.delete();
		episodeRepository.deleteById(cartoonId);

		Optional<Cartoon> resCartoon = cartoonRepository.findById(cartoonId);
		if (resCartoon.isEmpty()) {
			throw new IllegalArgumentException("존재하지 않는 웹툰입니다.");
		}
		Cartoon cartoon = resCartoon.get();
		cartoon.setTotalEpisode(cartoon.getTotalEpisode() - 1);
		cartoonRepository.save(cartoon);
	}

	private static void createFolder(String dirPath) {
		File Folder = new File(dirPath);
		Folder.mkdirs();
	}

	private static String saveImgFile(MultipartFile img, String filePath) throws IOException {

		String fileName = img.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String resFileName = uuid + "_" + fileName;
		img.transferTo(new File(filePath + resFileName));

		return resFileName;
	}
}
