package com.example.nWebtoonAPI.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.dto.EpisodeContentDto;
import com.example.nWebtoonAPI.dto.EpisodeDto;
import com.example.nWebtoonAPI.service.EpisodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/webtoons")
@RequiredArgsConstructor
public class EpisodeController {

	private final EpisodeService episodeService;

	@PostMapping("/{cartoonId}/episode")
	public ResponseEntity<EpisodeDto> createEpisode(@PathVariable Long cartoonId, @RequestPart EpisodeDto episodeDto, @RequestPart
	MultipartFile thumbImg, @RequestPart MultipartFile contentImg) throws IOException {

		EpisodeDto episode = episodeService.createEpisode(cartoonId, episodeDto, thumbImg, contentImg);

		return new ResponseEntity<>(episode, HttpStatus.OK);
	}

	@GetMapping("/{cartoonId}/episode/{episodeId}")
	public ResponseEntity<EpisodeContentDto> getEpisode(@PathVariable Long cartoonId, @PathVariable Long episodeId) {
		EpisodeContentDto episodeContentDto = episodeService.getEpisode(cartoonId, episodeId);
		return new ResponseEntity<>(episodeContentDto, HttpStatus.OK);
	}
}
