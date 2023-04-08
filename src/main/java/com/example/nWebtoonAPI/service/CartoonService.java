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
	List<CartoonListDto> getCartoons();
	CartoonEditDto updateCartoon(Long cartoonId, CartoonEditDto cartoonEditDto, MultipartFile mainImg, MultipartFile subImg) throws IOException;

}
