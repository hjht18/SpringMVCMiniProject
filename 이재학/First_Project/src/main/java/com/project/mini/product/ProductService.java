package com.project.mini.product;

import java.util.List;

public interface ProductService {
	
	ProductVO selectLastest(ProductVO vo);
	
	ProductVO selectById(ProductVO vo);
	
	List<ProductVO> getProductList(ProductVO vo);

	void insert(ProductVO vo);

	void update(ProductVO vo);
	
	void delete(ProductVO vo);

}
