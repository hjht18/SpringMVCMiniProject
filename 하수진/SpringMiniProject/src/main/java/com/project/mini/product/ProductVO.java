package com.project.mini.product;

// 담을 그릇 세팅

public class ProductVO {

	private int id;				// 식별자(PK)
	private String content;		// 상품 설명
	private String name;		// 상품 이름
	private int price;			// 상품 가격
	private String image;		// 상품 이미지

	public ProductVO(int id, String content, String name, int price, String image) {
		this.id = id;
		this.content = content;
		this.name = name;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
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

	public void setId(int id) {
		this.id = id;
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
