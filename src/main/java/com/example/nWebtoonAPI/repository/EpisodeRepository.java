package com.example.nWebtoonAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nWebtoonAPI.domain.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
	List<Episode> findByCartoon_CartoonId(Long cartoonId);
}
