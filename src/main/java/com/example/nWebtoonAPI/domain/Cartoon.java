package com.example.nWebtoonAPI.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cartoon", schema = "nWebtoon")
@NoArgsConstructor
@Getter @Setter
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

	private String mainImgName;

	private String mainImgUrl;

	private String subImgName;

	private String subImgUrl;

	private double grade;

	private int views;

	private int totalEpisode;
}
