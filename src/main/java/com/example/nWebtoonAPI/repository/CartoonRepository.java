package com.example.nWebtoonAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nWebtoonAPI.domain.Cartoon;

@Repository
public interface CartoonRepository extends JpaRepository<Cartoon, Long> {
	List<Cartoon> findByDay(String tab);
}
