package com.example.nWebtoonAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nWebtoonAPI.domain.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
