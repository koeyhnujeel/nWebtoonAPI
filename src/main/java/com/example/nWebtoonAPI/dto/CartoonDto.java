package com.example.nWebtoonAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartoonDto {
	private Long cartoonId;
	private String title;
	private String author;
	private String day;
}
