package com.project.mini.member;

public class MemberVO {

	private int memberCode; // 유저코드
	private String memberId; // 아이디(이메일)
	private String password; // 패스워드
	private String name; // 유저이름
	private String phoneNum; // 전화번호
	private String postNum; // 우편번호
	private String address1; // 기본주소
	private String address2; // 상세주소
	private String userImage; // 유저이미지
	
	public MemberVO() {
	}

	public MemberVO(int memberCode, String memberId, String password, String name, String phoneNum, String postNum,
			String address1, String address2, String userImage) {
		super();
		this.memberCode = memberCode;
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.phoneNum = phoneNum;
		this.postNum = postNum;
		this.address1 = address1;
		this.address2 = address2;
		this.userImage = userImage;
	}

	public int getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(int memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	@Override
	public String toString() {
		return "MemberVO [memberCode=" + memberCode + ", memberId=" + memberId + ", password=" + password + ", name="
				+ name + ", phoneNum=" + phoneNum + ", postNum=" + postNum + ", address1=" + address1 + ", address2="
				+ address2 + ", userImage=" + userImage + "]";
	}

	
}