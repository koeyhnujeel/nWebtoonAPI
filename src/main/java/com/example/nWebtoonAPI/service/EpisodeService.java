package com.example.nWebtoonAPI.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.nWebtoonAPI.dto.EpisodeContentDto;
import com.example.nWebtoonAPI.dto.EpisodeDto;
import com.example.nWebtoonAPI.dto.EpisodeEditDto;
import com.example.nWebtoonAPI.dto.EpisodeGradeDto;
import com.example.nWebtoonAPI.dto.EpisodeListDto;

public interface EpisodeService {

	EpisodeDto createEpisode(Long cartoonId, EpisodeDto episodeDto, MultipartFile thumbImg,
		MultipartFile contentImg) throws IOException;

	EpisodeContentDto getEpisode(Long cartoonId, Long episodeId);

	EpisodeEditDto updateEpisode(Long cartoonId, Long episodeId, EpisodeEditDto episodeEditDto, MultipartFile thumbImg,
		MultipartFile contentImg) throws IOException;
	void deleteEpisode(Long cartoonId, Long episodeId) throws IOException;

	EpisodeGradeDto giveGrade(Long cartoonId, Long episodeId, EpisodeGradeDto episodeGradeDto);

	List<EpisodeListDto> getEpisodeList(Long cartoonId);
}
