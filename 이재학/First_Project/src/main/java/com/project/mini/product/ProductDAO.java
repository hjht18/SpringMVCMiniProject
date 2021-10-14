package com.project.mini.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAO {
	
	private SqlSessionTemplate mybatis;

	@Autowired
	public ProductDAO(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}
	
	public ProductVO selectById(ProductVO vo) {
		return mybatis.selectOne("ProductDAO.selectById",vo);
	}
	
	public ProductVO selectLastest(ProductVO vo) {
		return mybatis.selectOne("ProductDAO.selectLastest", vo);
	}
	
	public List<ProductVO> selectList(ProductVO vo) {
		return mybatis.selectList("ProductDAO.selectList", vo);
	}
	
	public void insert(ProductVO vo) {
		mybatis.insert("ProductDAO.insert", vo);
	}
	
	public void update(ProductVO vo) {
		mybatis.update("ProductDAO.update", vo);
	}
	
	public void delete(ProductVO vo) {
		mybatis.delete("ProductDAO.delete", vo);
	}
}
