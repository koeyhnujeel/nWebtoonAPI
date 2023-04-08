package com.example.nWebtoonAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartoonEditDto {
	private Long cartoonId;
	private String title;
	private String author;
	private String day;
	private String mainImgName;
	private String mainImgUrl;
	private String subImgName;
	private String subImgUrl;
}
