package com.project.mini.review;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDAO {

	private SqlSessionTemplate mybatis;

	@Autowired
	public ReviewDAO(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
}
