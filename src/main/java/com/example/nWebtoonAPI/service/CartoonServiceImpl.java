package com.example.nWebtoonAPI.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.constant.ImgDir;
import com.example.nWebtoonAPI.domain.Cartoon;
import com.example.nWebtoonAPI.dto.CartoonDto;
import com.example.nWebtoonAPI.dto.CartoonEditDto;
import com.example.nWebtoonAPI.dto.CartoonImgDto;
import com.example.nWebtoonAPI.dto.CartoonListDto;
import com.example.nWebtoonAPI.repository.CartoonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartoonServiceImpl implements CartoonService {

	private final CartoonRepository cartoonRepository;

	@Override
	public CartoonDto createCartoon(CartoonDto cartoonDto) {
		Cartoon cartoon = new Cartoon();
		cartoon.setTitle(cartoonDto.getTitle());
		cartoon.setAuthor(cartoonDto.getAuthor());
		cartoon.setDay(cartoonDto.getDay());
		cartoon.setGrade(0);
		cartoon.setViews(0);
		cartoon.setTotalEpisode(0);
		Cartoon savedCartoon = cartoonRepository.save(cartoon);
		BeanUtils.copyProperties(savedCartoon, cartoonDto);
		return cartoonDto;
	}

	@Override
	public CartoonImgDto createCartoonImg(Long cartoonId, MultipartFile mainImg,
		MultipartFile subImg) throws IOException {

		Optional<Cartoon> res = cartoonRepository.findById(cartoonId);
		if (res.isEmpty()) {
			throw new IllegalArgumentException("존재하지 않는 웹툰입니다.");
		}
		if (mainImg.isEmpty() || subImg.isEmpty()) {
			throw new IllegalArgumentException("파일이 존재하지 않습니다.");
		}

		String mainFilePath = ImgDir.IMG_PATH + cartoonId + "/" + "main/";
		String resMainFileName = saveImgFile(mainImg, mainFilePath);

		String subFilePath = ImgDir.IMG_PATH + cartoonId + "/" + "sub/";
		String resSubFileName = saveImgFile(subImg, subFilePath);

		Cartoon cartoon = res.get();
		cartoon.setMainImgName(resMainFileName);
		cartoon.setMainImgUrl(mainFilePath + resMainFileName);
		cartoon.setSubImgName(resSubFileName);
		cartoon.setSubImgUrl(subFilePath + resSubFileName);
		Cartoon savedCartoon = cartoonRepository.save(cartoon);

		CartoonImgDto cartoonImgDto = new CartoonImgDto();
		BeanUtils.copyProperties(savedCartoon, cartoonImgDto);

		return cartoonImgDto;
	}

	@Override
	public List<CartoonListDto> getCartoons(String tab) {
		List<Cartoon> cartoons = cartoonRepository.findAll();
		if (cartoons.isEmpty()) {
			throw new EntityNotFoundException("등록된 웹툰이 없습니다");
		}
		
		List<CartoonListDto> cartoonListDtos = new ArrayList<>();
		if (tab != null) {
			List<Cartoon> byDay = cartoonRepository.findByDay(tab);
			for (Cartoon cartoon : byDay) {
				CartoonListDto cartoonListDto = new CartoonListDto();
				BeanUtils.copyProperties(cartoon, cartoonListDto);
				cartoonListDtos.add(cartoonListDto);
			}
		} else {
			for (Cartoon cartoon : cartoons) {
				CartoonListDto cartoonListDto = new CartoonListDto();
				BeanUtils.copyProperties(cartoon, cartoonListDto);
				cartoonListDtos.add(cartoonListDto);
			}
		}
		return cartoonListDtos;
	}

	@Override
	public CartoonEditDto updateCartoon(Long cartoonId, CartoonEditDto cartoonEditDto, MultipartFile mainImg,
		MultipartFile subImg) throws IOException {

		Optional<Cartoon> res = cartoonRepository.findById(cartoonId);
		if (res.isEmpty()) {
			throw new IllegalArgumentException("존재하지 않는 웹툰입니다.");
		}
		Cartoon updateCartoon = res.get();
		updateCartoon.setTitle(cartoonEditDto.getTitle());
		updateCartoon.setAuthor(cartoonEditDto.getAuthor());
		updateCartoon.setDay(cartoonEditDto.getDay());

		if (mainImg != null) {
			File file = new File(updateCartoon.getMainImgUrl());
			file.delete();

			String mainFilePath = ImgDir.IMG_PATH + cartoonId + "/" + "main/";
			String resMainFileName = saveImgFile(mainImg, mainFilePath);

			updateCartoon.setMainImgName(resMainFileName);
			updateCartoon.setMainImgUrl(mainFilePath + resMainFileName);
		}

		if (subImg != null) {
			File file = new File(updateCartoon.getSubImgUrl());
			file.delete();

			String subFilePath = ImgDir.IMG_PATH + cartoonId + "/" + "sub/";
			String resSubFileName = saveImgFile(subImg, subFilePath);

			updateCartoon.setSubImgName(resSubFileName);
			updateCartoon.setSubImgUrl(subFilePath + resSubFileName);
		}

		Cartoon savedCartoon = cartoonRepository.save(updateCartoon);
		BeanUtils.copyProperties(savedCartoon, cartoonEditDto);
		return cartoonEditDto;
	}

	@Override
	public void deleteCartoon(Long cartoonId) throws IOException {

		Optional<Cartoon> res = cartoonRepository.findById(cartoonId);
		if (res.isEmpty()) {
			throw new IllegalArgumentException("존재하지 않는 웹툰입니다.");
		}

		String path = ImgDir.IMG_PATH + cartoonId;
		File folder = new File(path);
		if (folder.exists()) {
			FileUtils.cleanDirectory(folder);
			folder.delete();
		}
		cartoonRepository.deleteById(cartoonId);
	}

	private static String saveImgFile(MultipartFile img, String filePath) throws IOException {

		String fileName = img.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		String resFileName = uuid + "_" + fileName;
		img.transferTo(new File(filePath + resFileName));

		return resFileName;
	}
}
