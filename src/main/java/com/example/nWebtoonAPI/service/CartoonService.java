package com.example.nWebtoonAPI.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.dto.CartoonDto;
import com.example.nWebtoonAPI.dto.CartoonEditDto;
import com.example.nWebtoonAPI.dto.CartoonImgDto;
import com.example.nWebtoonAPI.dto.CartoonListDto;

public interface CartoonService {

	CartoonDto createCartoon(CartoonDto cartoonDto);
	CartoonImgDto createCartoonImg(Long cartoonId, MultipartFile mainImg, MultipartFile subImg) throws IOException;
	List<CartoonListDto> getCartoons(String tab, String sort);
	CartoonEditDto updateCartoon(Long cartoonId, CartoonEditDto cartoonEditDto, MultipartFile mainImg, MultipartFile subImg) throws IOException;
	void deleteCartoon(Long cartoonId) throws IOException;
}
