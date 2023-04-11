package com.example.nWebtoonAPI.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.nWebtoonAPI.domain.Comment;
import com.example.nWebtoonAPI.domain.Episode;
import com.example.nWebtoonAPI.dto.CommentDto;
import com.example.nWebtoonAPI.repository.CommentRepository;
import com.example.nWebtoonAPI.repository.EpisodeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

	private final CommentRepository commentRepository;
	private final EpisodeRepository episodeRepository;

	@Override
	public CommentDto createComment(Long episodeId, CommentDto commentDto) {
		Optional<Episode> res = episodeRepository.findById(episodeId);
		if (res.isEmpty()) {
			throw new IllegalArgumentException("존재하지 않는 회차입니다.");
		}
		Episode episode = res.get();
		Comment comment = new Comment();
		comment.setCommentContent(commentDto.getCommentContent());
		comment.setEpisode(episode);
		Comment savedComment = commentRepository.save(comment);
		episode.getComments().add(comment);
		episodeRepository.save(episode);

		BeanUtils.copyProperties(savedComment, commentDto);
		commentDto.setEpisodeId(episodeId);
		return commentDto;
	}
}
