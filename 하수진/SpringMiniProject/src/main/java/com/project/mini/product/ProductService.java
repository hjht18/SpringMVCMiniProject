package com.project.mini.product;

import java.util.List;
import java.util.Map;

// 

// ESHOP ProductService 참고
public interface ProductService {

	public List<Map<String, String>> retrieveProductList(Map<String, String> productParam);

	public List<Map<String, String>> retrieveProductListForMain();

	public List<Map<String, String>> retrieveProductListForFood();

	public Map<String, String> retrieveProduct(Map<String, String> productParam);

	public void createProduct(ProductVO productVO);

	public void updateProduct(ProductVO productVO);

	public void updateProductCountMinus(Map<String, String> productParam);

	public void updateProductCountPlus(Map<String, String> productParam);

	public String retrieveMaxProductCode();

	public List<Map<String, String>> retrieveStatisticsForStock(Map<String, String> productParam);

	public List<Map<String, String>> retrieveStatisticsForSell();
}
