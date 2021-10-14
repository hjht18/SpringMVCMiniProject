package com.project.mini.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO{

	private SqlSessionTemplate mybatis;

	@Autowired
	public MemberDAO(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	//로그인
	public int login(MemberVO vo) {
		System.out.println("login()으로 로그인 처리?");
		return mybatis.selectOne("MemberDAO.login", vo);
	}
	
	//회원가입(회원정보입력)
	public void signUp(MemberVO vo) {
		System.out.println("signUp()으로 회원 가입 처리");
		mybatis.insert("MemberDAO.signUp", vo);
	}
	
	//회원정보 수정
	public void updateMember(MemberVO vo) {
		System.out.println("updateMember()으로 회원 정보 수정 처리");
		mybatis.update("MemberDAO.updateMember", vo);
		
	}
	
	//회원 탈퇴(삭제)
	public void deleteMember(String memberId) {
		System.out.println("deleteMember()으로 회원 탈퇴 수정 처리");
		mybatis.delete("MemberDAO.deleteMember", memberId);
		
	}
	//
}
