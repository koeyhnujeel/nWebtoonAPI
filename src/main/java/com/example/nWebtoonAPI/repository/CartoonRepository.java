package com.example.nWebtoonAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nWebtoonAPI.domain.Cartoon;

@Repository
public interface CartoonRepository extends JpaRepository<Cartoon, Long> {
}
