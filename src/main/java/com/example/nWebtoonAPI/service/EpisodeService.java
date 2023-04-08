package com.example.nWebtoonAPI.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.dto.EpisodeDto;

public interface EpisodeService {

	EpisodeDto createEpisode(Long cartoonId, EpisodeDto episodeDto, MultipartFile thumbImg, MultipartFile contentImg) throws
		IOException;
}
