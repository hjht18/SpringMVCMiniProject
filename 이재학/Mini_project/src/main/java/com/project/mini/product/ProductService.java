package com.project.mini.product;

	public interface ProductService {
	
	ProductVO selectById(ProductVO vo);

	void insert(ProductVO vo);

	void update(ProductVO vo);
	
	void delete(ProductVO vo);

}
