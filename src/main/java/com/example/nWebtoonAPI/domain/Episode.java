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
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "episode", schema = "nWebtoon")
@NoArgsConstructor
@Getter @Setter
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

	private String mainImgName;

	private String mainImgUrl;

	private String contentUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartoon_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cartoon cartoon;
}
