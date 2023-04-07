package com.example.nWebtoonAPI.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.dto.CartoonDto;
import com.example.nWebtoonAPI.dto.CartoonImgDto;
import com.example.nWebtoonAPI.service.CartoonService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/webtoons")
@RequiredArgsConstructor
@Slf4j
public class CartoonController {

	private final CartoonService cartoonService;

	@PostMapping("")
	public ResponseEntity<CartoonDto> createCartoon(@RequestBody CartoonDto cartoonDto) {
		CartoonDto savedCartoon = cartoonService.createCartoon(cartoonDto);
		return new ResponseEntity<CartoonDto>(savedCartoon, HttpStatus.OK);
	}

	@PostMapping("/{cartoonId}/image")
	public ResponseEntity<CartoonImgDto> createCartoonImg(@PathVariable Long cartoonId, MultipartFile mainImg,
		MultipartFile subImg) throws IOException {

		CartoonImgDto cartoonImgDto = cartoonService.createCartoonImg(cartoonId, mainImg, subImg);
		return new ResponseEntity<CartoonImgDto>(cartoonImgDto, HttpStatus.OK);
	}
}
