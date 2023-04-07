package com.example.nWebtoonAPI.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.domain.Cartoon;
import com.example.nWebtoonAPI.dto.CartoonDto;
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
}
