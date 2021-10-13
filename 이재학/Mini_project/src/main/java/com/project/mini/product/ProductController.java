package com.project.mini.product;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.project.mini.member.MemberVO;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	// 상품 테스트
	@RequestMapping("/test")
	public String selectMemberAddress(MemberVO vo) {
		return "product/productTest";
	}
	
	// 상품 목록 페이지
	@RequestMapping("/")
	public String productInfo() {
		return "product/productList";
	}
	
	// 상품 상세 페이지
	@RequestMapping("/detail")
	public String productDetail() {
		return "product/productDetail";
	}
	
	// 상품 이미지 등록 (미구현)
	@RequestMapping("/saveImgTest")
	@ResponseBody
	public String saveFile(HttpServletRequest request) throws IOException {
		String imgFolder = request.getParameter("imageFolder");
		String path = "\\"+ imgFolder + "\\";
		String realPath = request.getRealPath("/") + path;
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
		MultipartFile file = multipartHttpServletRequest.getFile("imageFile");
		String fileName = file.getOriginalFilename();
		
		File uFile = new File(realPath + fileName);
		file.transferTo(uFile);
		return fileName;
	}

}
