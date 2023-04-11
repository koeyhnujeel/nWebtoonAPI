package com.example.nWebtoonAPI.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
	private Long commentId;
	private Long episodeId;
	private String commentContent;
	private LocalDateTime writeAt;
}
