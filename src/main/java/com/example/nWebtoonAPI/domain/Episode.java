package com.example.nWebtoonAPI.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "episode", schema = "nWebtoon")
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Episode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "episode_id", unique = true, nullable = false)
	private Long episodeId;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate uploadedAt;

	private double grade;

	private double totalGrade;

	private String thumbImgName;

	private String thumbImgUrl;

	private String contentImgName;

	private String contentImgUrl;

	private long count;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cartoon_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cartoon cartoon;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "episode", cascade = CascadeType.REMOVE)
	private List<Comment> comments = new ArrayList<>();
}
