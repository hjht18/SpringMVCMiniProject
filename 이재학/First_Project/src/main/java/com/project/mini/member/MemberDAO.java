package com.project.mini.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

	private SqlSessionTemplate mybatis;

	@Autowired
	public MemberDAO(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	// 회원가입(회원정보입력)
	public void signUp(MemberVO vo) {
		mybatis.insert("MemberDAO.signUp", vo);
	}

	// 중복회원 검증
	public MemberVO checkDuplicate(MemberVO vo) {
		return (MemberVO) mybatis.selectOne("MemberDAO.checkDuplicate", vo);
	}

	// 회원정보 수정
	public void updateMember(MemberVO vo) {
		mybatis.update("MemberDAO.updateMember", vo);
	}

	// 회원 탈퇴(삭제)
	public void deleteMember(MemberVO vo) {
		mybatis.delete("MemberDAO.deleteMember", vo);

	}

	// 로그인
	public MemberVO login(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.login", vo);
	}
	
	// 회원 조회
	public MemberVO selectById(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.selectById", vo);
	}
}
