package com.root.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;

	@Override
	public void login(UserBean ub) {
		userDAO.login(ub);
	}
	
	

}
