package com.project.mini.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public ProductVO selectById(ProductVO vo) {
		return productDAO.select(vo);
	}

	@Override
	public void insert(ProductVO vo) {
		productDAO.insert(vo);
	}

	@Override
	public void update(ProductVO vo) {
		productDAO.update(vo);
	}

	@Override
	public void delete(ProductVO vo) {
		productDAO.delete(vo);
	}
	
	
	
}
