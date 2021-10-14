package com.project.mini.product;

public class ProductVO {

	private int code;			// 식별자(PK)
	private String content;		// 상품 설명
	private String name;		// 상품 이름
	private int price;			// 상품 가격
	private String image;		// 상품 이미지 경로 
	
	public ProductVO() {}
	
	public ProductVO(int code, String content, String name, int price, String image) {
		this.code = code;
		this.content = content;
		this.name = name;
		this.price = price;
		this.image = image;
	}
	
	public int getCode() {
		return code;
	}
	public String getContent() {
		return content;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getImage() {
		return image;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setContent(String content) {
		this.content = content;
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
