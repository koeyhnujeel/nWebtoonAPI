package com.example.nWebtoonAPI.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.nWebtoonAPI.dto.CommentDto;
import com.example.nWebtoonAPI.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/webtoons")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@PostMapping("/{cartoonId}/episodes/{episodeId}/comments")
	public ResponseEntity<CommentDto> createComment(@PathVariable("episodeId") Long episodeId, @RequestBody CommentDto commentDto) {
		CommentDto comment = commentService.createComment(episodeId, commentDto);
		return new ResponseEntity<>(comment, HttpStatus.OK);
	}
}
