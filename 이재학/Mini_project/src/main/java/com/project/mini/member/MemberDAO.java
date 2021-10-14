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
	
	
}
