package com.project.mini.member;


public interface MemberService {
	
	//회원가입(회원정보입력)
	void signUp(MemberVO vo);
	
	//중복회원 검증
	boolean checkDuplicate(MemberVO vo);

	//회원정보 수정
	void updateMember(MemberVO vo);

	//회원 탈퇴(삭제)
	void deleteMember(MemberVO vo);
	
	// 로그인
	MemberVO login(MemberVO vo) throws Exception;
	
	// 회원
	MemberVO selectById(MemberVO vo);
	

}