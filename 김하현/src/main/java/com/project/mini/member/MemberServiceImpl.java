package com.project.mini.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDAO userDAO;

	@Override
	public void login(MemberVO ub) {
		userDAO.login(ub);
	}
	
	

}
