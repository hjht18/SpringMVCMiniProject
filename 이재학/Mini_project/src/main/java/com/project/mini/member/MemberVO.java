package com.project.mini.member;


public class MemberVO {
	private int code;
	private String id;
	private String password;
	private String gender;
	private String name;
	private String phoneNumber;
	private String email;
	private String zipCode;
	private String address;
	private String detailAddress;
	private String image;
	
	public MemberVO() {}
	
	public MemberVO(int code, String id, String password, String gender, String name, String phoneNumber, String email,
			String zipCode, String address, String detailAddress, String image) {
		this.code = code;
		this.id = id;
		this.password = password;
		this.gender = gender;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.zipCode = zipCode;
		this.address = address;
		this.detailAddress = detailAddress;
		this.image = image;
	}

	public int getCode() {
		return code;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getAddress() {
		return address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public String getImage() {
		return image;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	
}
