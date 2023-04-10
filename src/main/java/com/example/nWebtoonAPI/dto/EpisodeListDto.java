package com.example.nWebtoonAPI.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpisodeListDto {
	private Long cartoonId;
	private Long episodeId;
	private String title;
	private LocalDate uploadedAt;
	private double grade;
	private String thumbImgName;
	private String thumbImgUrl;
}
