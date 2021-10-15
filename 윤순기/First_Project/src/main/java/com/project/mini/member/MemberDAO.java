package com.project.mini.member;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void login(MemberVO ub) {
		mybatis.selectOne("sql.login", ub);
	}

}
