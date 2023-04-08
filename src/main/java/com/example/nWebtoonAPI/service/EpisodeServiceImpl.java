package com.example.nWebtoonAPI.service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.constant.ImgDir;
import com.example.nWebtoonAPI.domain.Cartoon;
import com.example.nWebtoonAPI.domain.Episode;
import com.example.nWebtoonAPI.dto.EpisodeDto;
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

		return episodeDto;
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
