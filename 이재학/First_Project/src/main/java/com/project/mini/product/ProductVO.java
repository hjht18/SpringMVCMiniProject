package com.project.mini.product;

import java.text.DecimalFormat;

public class ProductVO {

	private int id; // 식별자(PK)
	private String name; // 상품 이름
	private String content; // 상품 설명
	private String content2; // 상품 하단 설명
	private int price; // 상품 가격
	private String image; // 상품 이미지 경로

	public ProductVO() {
	}

	public ProductVO(int id, String content, String content2, String name, int price, String image) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.content2 = content2;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getContent2() {
		return content2;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	// 가격 포맷을 미리 설정하여 getter으로 지정
	public String getFormattedPrice() {
		DecimalFormat formatter = new DecimalFormat("#,##0");
		return formatter.format(price);
	}

	public String getImage() {
		return image;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
