package com.project.mini.product;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

// 서비스 인터페이스를 불러와 세팅

// ESHOP ProductServiceImpl 참고
@Service("productService")
public class ProductServiceImpl implements ProductService {

//	@Autowired
//	private ProductDAO productDAO;

	@Resource(name = "productDAO")
	private ProductDAO productDAO;

	@Override
	public List<Map<String, String>> retrieveProductList(Map<String, String> productParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, String>> retrieveProductListForMain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, String>> retrieveProductListForFood() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> retrieveProduct(Map<String, String> productParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createProduct(ProductVO productVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(ProductVO productVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProductCountMinus(Map<String, String> productParam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProductCountPlus(Map<String, String> productParam) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String retrieveMaxProductCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, String>> retrieveStatisticsForStock(Map<String, String> productParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, String>> retrieveStatisticsForSell() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
