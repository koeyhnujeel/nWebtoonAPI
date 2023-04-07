package com.example.nWebtoonAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartoonImgDto {

	private Long cartoonId;
	private String mainImgName;
	private String mainImgUrl;
	private String subImgName;
	private String subImgUrl;
}
