package com.example.nWebtoonAPI.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "episode", schema = "nWebtoon")
@NoArgsConstructor
public class Episode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "episode_id", unique = true, nullable = false)
	private Long episodeId;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date uploadedAt;

	private double grade;

	private String thumbName;

	private String thumbUrl;

	private String contentUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartoon_id")
	private Cartoon cartoon;
}
