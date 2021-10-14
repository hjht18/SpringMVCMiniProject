package com.project.mini.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public int login(MemberVO vo) {
		return memberDAO.login(vo);
	}
	
	@Override
	public void signUp(MemberVO vo) {
		memberDAO.signUp(vo);
		
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	@Override
	public void deleteMember(String memberId) {
		memberDAO.deleteMember(memberId);
	}

}
