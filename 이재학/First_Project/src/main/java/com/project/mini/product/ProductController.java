package com.project.mini.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.mini.member.MemberVO;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// model에 product 추가
//	@ModelAttribute("product")
//	public ProductVO getProduct() {
//		ProductVO vo = new ProductVO();
//		return productService.selectById(vo);
//	}
	
	// 상품 테스트
	@RequestMapping("/test.do")
	public String selectMemberAddress(MemberVO vo) {
		return "product/productTest";
	}
	
	// 상품 목록 페이지
	@RequestMapping("/list.do")
	public String productInfo(ProductVO vo, Model model) {		
		model.addAttribute("productList", productService.getProductList(vo));
		return "product/productList";
	}
	
	// 상품 상세 페이지
	@RequestMapping("/detail.do")
	public String productDetail(ProductVO vo, Model model) {
		model.addAttribute("product", productService.selectById(vo));
		return "product/productDetail";
	}
	
	// 상품 등록용 관리자 페이지
	@RequestMapping("/admin.do")
	public String admin(ProductVO vo) {
		return "product/adminPage";
	}
	
	// 상품 등록 로직 실행 부분
	@RequestMapping(value = "/registerProduct.do", method = RequestMethod.POST)
	public String registerProduct(ProductVO vo) {
		productService.insert(vo);
		return "redirect:/product/list.do";
	}
	
	
	// 상품 이미지 등록 (미구현)
//	@RequestMapping("/saveImgTest")
//	@ResponseBody
//	public String saveFile(HttpServletRequest request) throws IOException {
//		String imgFolder = request.getParameter("imageFolder");
//		String path = "\\"+ imgFolder + "\\";
//		String realPath = request.getRealPath("/") + path;		// WEB-INF 전까지 저장할 경로...?
//		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
//		MultipartFile file = multipartHttpServletRequest.getFile("imageFile");	// 단일 파일 업로드
//		String fileName = file.getOriginalFilename();
//		
//		File uFile = new File(realPath + fileName);
//		file.transferTo((uFile));
//		return fileName;
//	}
	
//	private static final String CURR_IMAGE_REPO_PATH = "c:\\spring\\image_repo";
//	@RequestMapping(value="/form")
//	public String form() {
//	    return "product/uploadForm";
//	  }
//	
//	@RequestMapping(value="/upload",method = RequestMethod.POST)
//	public ModelAndView upload(MultipartHttpServletRequest multipartRequest,HttpServletResponse response)
//	  throws Exception{
//		multipartRequest.setCharacterEncoding("utf-8");
//		
//	
//		Map map = new HashMap();
//		Enumeration enu=multipartRequest.getParameterNames();
//		while(enu.hasMoreElements()){
//			String name=(String)enu.nextElement();
//			String value=multipartRequest.getParameter(name);
//			//System.out.println(name+", "+value);
//			map.put(name,value);
//		}
//		
//		List fileList= fileProcess(multipartRequest);
//		map.put("fileList", fileList);
//		ModelAndView mav = new ModelAndView();
//		
//		// map을 결과창으로 포워딩
//		mav.addObject("map", map);
//		mav.setViewName("product/result");
//		return mav;
//	}
//	
//	private List<String> fileProcess(MultipartHttpServletRequest multipartRequest) throws Exception{
//		List<String> fileList= new ArrayList<String>();
//		Iterator<String> fileNames = multipartRequest.getFileNames();
//		while(fileNames.hasNext()){
//			String fileName = fileNames.next();
//			MultipartFile mFile = multipartRequest.getFile(fileName);
//			String originalFileName=mFile.getOriginalFilename();
//			fileList.add(originalFileName);
//			File file = new File(CURR_IMAGE_REPO_PATH +"\\"+ fileName);
//			if(mFile.getSize()!=0){ //File Null Check
//				if(! file.exists()){ //경로상에 파일이 존재하지 않을 경우
//					if(file.getParentFile().mkdirs()){ //경로에 해당하는 디렉토리들을 생성
//						file.createNewFile(); //이후 파일 생성
//					}
//				}
//				mFile.transferTo(new File(CURR_IMAGE_REPO_PATH +"\\"+ originalFileName)); //임시로 저장된 multipartFile을 실제 파일로 전송
//			}
//		}
//		return fileList;
//	}
	

}
