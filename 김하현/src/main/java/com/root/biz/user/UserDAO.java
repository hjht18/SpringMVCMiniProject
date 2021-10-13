package com.root.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void login(UserBean ub) {
		mybatis.selectOne("sql.login", ub);
	}

}
