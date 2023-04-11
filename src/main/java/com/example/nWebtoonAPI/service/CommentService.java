package com.example.nWebtoonAPI.service;

import com.example.nWebtoonAPI.dto.CommentDto;

public interface CommentService {

	CommentDto createComment(Long episodeId, CommentDto commentDto);

	CommentDto updateComment(Long episodeId, Long commentId, CommentDto commentDto);

	void deleteComment(Long episodeId, Long commentId);
}
