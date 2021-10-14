package com.project.mini.product;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.mini.member.MemberVO;

// 핸들러 역을 하는 곳

@Controller
@RequestMapping("/product")
public class ProductController {
	
//	ESHOP ProductController 참고함
	@Resource(name = "productService")
	private ProductService productService;

	
	@RequestMapping("/test")
	public String selectMemberAddress(MemberVO vo) {
		
		return "product/productTest";
	}

}
