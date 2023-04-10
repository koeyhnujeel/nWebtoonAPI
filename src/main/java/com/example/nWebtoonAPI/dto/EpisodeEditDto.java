package com.example.nWebtoonAPI.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpisodeEditDto {

	private Long episodeId;
	private String title;
	private String thumbImgName;
	private String thumbImgUrl;
	private String contentImgName;
	private String contentImgUrl;
}
