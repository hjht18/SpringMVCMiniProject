package com.project.mini.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public MemberVO selectById() {
		MemberVO member = memberDAO.selectById();
		System.out.println(member.getId());
		return member;
	}
	
	
}
