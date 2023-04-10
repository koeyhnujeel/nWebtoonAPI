package com.example.nWebtoonAPI.service;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.dto.EpisodeContentDto;
import com.example.nWebtoonAPI.dto.EpisodeDto;
import com.example.nWebtoonAPI.dto.EpisodeEditDto;

public interface EpisodeService {

	EpisodeDto createEpisode(Long cartoonId, EpisodeDto episodeDto, MultipartFile thumbImg, MultipartFile contentImg) throws IOException;

	EpisodeContentDto getEpisode(Long cartoonId, Long episodeId);

	EpisodeEditDto updateEpisode(Long cartoonId ,Long episodeId, EpisodeEditDto episodeEditDto, MultipartFile thumbImg, MultipartFile contentImg) throws IOException;

}
