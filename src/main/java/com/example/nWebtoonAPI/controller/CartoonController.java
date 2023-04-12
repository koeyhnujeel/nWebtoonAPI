package com.example.nWebtoonAPI.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.dto.CartoonDto;
import com.example.nWebtoonAPI.dto.CartoonEditDto;
import com.example.nWebtoonAPI.dto.CartoonImgDto;
import com.example.nWebtoonAPI.dto.CartoonListDto;
import com.example.nWebtoonAPI.service.CartoonService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/webtoons")
@RequiredArgsConstructor
@Slf4j
public class CartoonController {

	private final CartoonService cartoonService;

	@GetMapping("")
	public ResponseEntity<List<CartoonListDto>> getCartoons(@RequestParam(required = false) String tab) {
		List<CartoonListDto> cartoonListDto = cartoonService.getCartoons(tab);
		return new ResponseEntity<>(cartoonListDto, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<CartoonDto> createCartoon(@RequestBody CartoonDto cartoonDto) {
		CartoonDto savedCartoon = cartoonService.createCartoon(cartoonDto);
		return new ResponseEntity<>(savedCartoon, HttpStatus.OK);
	}

	@PostMapping("/{cartoonId}/image")
	public ResponseEntity<CartoonImgDto> createCartoonImg(@PathVariable Long cartoonId, MultipartFile mainImg,
		MultipartFile subImg) throws IOException {

		CartoonImgDto cartoonImgDto = cartoonService.createCartoonImg(cartoonId, mainImg, subImg);
		return new ResponseEntity<>(cartoonImgDto, HttpStatus.OK);
	}

	@PutMapping("/{cartoonId}")
	public ResponseEntity<CartoonEditDto> updateCartoon(@PathVariable Long cartoonId,
		@RequestPart CartoonEditDto cartoonEditDto,
		@RequestPart(required = false) MultipartFile mainImg,
		@RequestPart(required = false) MultipartFile subImg) throws IOException {

		CartoonEditDto cartoonEdit = cartoonService.updateCartoon(cartoonId, cartoonEditDto, mainImg, subImg);
		return new ResponseEntity<>(cartoonEdit, HttpStatus.OK);
	}

	@DeleteMapping("/{cartoonId}")
	public ResponseEntity<Void> deleteCartoon(@PathVariable Long cartoonId) throws IOException {
		cartoonService.deleteCartoon(cartoonId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
