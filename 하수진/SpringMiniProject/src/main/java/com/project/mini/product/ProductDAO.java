package com.project.mini.product;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// DB랑 연결할 수 있게 SQL 세팅

@Repository
public class ProductDAO {
	
	private SqlSessionTemplate mybatis;

	@Autowired
	public ProductDAO(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	
}
