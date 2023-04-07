package com.example.nWebtoonAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartoonListDto {

	private Long cartoonId;
	private String title;
	private String author;
	private int grade;
	private String mainImgName;
	private String mainImgUrl;
}
