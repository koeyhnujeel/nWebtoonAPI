package com.example.nWebtoonAPI.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "cartoon", schema = "nWebtoon")
@NoArgsConstructor
public class Cartoon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartoon_id", unique = true, nullable = false)
	private Long cartoonId;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String author;

	@Column(nullable = false)
	private String day;

	private String thumbUrl1;

	private String thumbUrl2;

	private double grade;

	private int views;

	private int totalEpisode;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cartoon", cascade = CascadeType.REMOVE)
	private List<Episode> episodeList = new ArrayList<>();
}
