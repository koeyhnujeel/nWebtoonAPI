package com.example.nWebtoonAPI.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.dto.CartoonDto;
import com.example.nWebtoonAPI.dto.CartoonImgDto;

public interface CartoonService {

	CartoonDto createCartoon(CartoonDto cartoonDto);
	CartoonImgDto createCartoonImg(Long cartoonId, MultipartFile mainImg, MultipartFile subImg) throws IOException;

}
