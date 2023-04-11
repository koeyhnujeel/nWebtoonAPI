package com.example.nWebtoonAPI.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.nWebtoonAPI.domain.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpisodeContentDto {

	private Long episodeId;
	private String ContentImgName;
	private String contentImgUrl;
	private List<Comment> comments;
}
