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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.dto.EpisodeContentDto;
import com.example.nWebtoonAPI.dto.EpisodeDto;
import com.example.nWebtoonAPI.dto.EpisodeEditDto;
import com.example.nWebtoonAPI.dto.EpisodeGradeDto;
import com.example.nWebtoonAPI.dto.EpisodeListDto;
import com.example.nWebtoonAPI.service.EpisodeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/webtoons")
@RequiredArgsConstructor
public class EpisodeController {

	private final EpisodeService episodeService;

	@GetMapping("/{cartoonId}/episodes")
	public ResponseEntity<List<EpisodeListDto>> getEpisodeList(@PathVariable Long cartoonId) {
		List<EpisodeListDto> episodeList = episodeService.getEpisodeList(cartoonId);
		return new ResponseEntity<>(episodeList, HttpStatus.OK);
	}

	@PostMapping("/{cartoonId}/episodes")
	public ResponseEntity<EpisodeDto> createEpisode(@PathVariable Long cartoonId, @RequestPart EpisodeDto episodeDto,
		@RequestPart MultipartFile thumbImg, @RequestPart MultipartFile contentImg) throws IOException {

		EpisodeDto episode = episodeService.createEpisode(cartoonId, episodeDto, thumbImg, contentImg);
		return new ResponseEntity<>(episode, HttpStatus.OK);
	}


	@GetMapping("/{cartoonId}/episodes/{episodeId}")
	public ResponseEntity<EpisodeContentDto> getEpisode(@PathVariable Long cartoonId, @PathVariable Long episodeId) {

		EpisodeContentDto episodeContentDto = episodeService.getEpisode(cartoonId, episodeId);
		return new ResponseEntity<>(episodeContentDto, HttpStatus.OK);
	}

	@PutMapping("/{cartoonId}/episodes/{episodeId}")
	public ResponseEntity<EpisodeEditDto> updateEpisode(@PathVariable Long cartoonId, @PathVariable Long episodeId,
		@RequestPart EpisodeEditDto episodeEditDto,
		@RequestPart(required = false) MultipartFile thumbImg,
		@RequestPart(required = false) MultipartFile contentImg) throws IOException {

		EpisodeEditDto episodeEdit = episodeService.updateEpisode(cartoonId, episodeId, episodeEditDto, thumbImg,
			contentImg);
		return new ResponseEntity<>(episodeEdit, HttpStatus.OK);
	}

	@DeleteMapping("/{cartoonId}/episodes/{episodeId}")
	public ResponseEntity<Void> deleteEpisode(@PathVariable Long cartoonId, @PathVariable Long episodeId) throws
		IOException {

		episodeService.deleteEpisode(cartoonId, episodeId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@PostMapping("/{cartoonId}/episodes/{episodeId}/grade")
	public ResponseEntity<EpisodeGradeDto> giveGrade(@PathVariable Long cartoonId, @PathVariable Long episodeId,
		@RequestBody EpisodeGradeDto episodeGradeDto) {

		EpisodeGradeDto episodeGrade = episodeService.giveGrade(cartoonId, episodeId, episodeGradeDto);
		return new ResponseEntity<>(episodeGrade, HttpStatus.OK);
	}
}
