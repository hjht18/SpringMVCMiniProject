package com.project.mini.review;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.project.mini.review.login.MemberVO;
import com.project.mini.review.product.ProductVO;

@Controller
public class ReviewController extends HttpServlet{
/* ### 변수 선언부 ### */
	@Autowired
	private ReviewService reviewService;
	private HttpSession session;
	private int reviewBox;
	private int reviewTotal;
	private int reviewBoxNum = 1;
	private int reviewSet=1;
	private int product_id;
	private String member_id;
	Map<String, Integer> pageMap = new HashMap<String, Integer>();
	
	private boolean bDebug = true ; // 디버그 출력용 변수
	
	// 업로드 설정
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 최대 파일 크기 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // request 전송되는 파일 사이즈 : 파일사이즈 + form data , 50MB
    
/***************************************************************************************************************************/
	
	/* Review CRUD Method */
	@RequestMapping("/getBoardList.do")
	public String getBoardList(@RequestParam(value="page", defaultValue="1", required=false) int page,
			HttpServletRequest request, Model model) {
		System.out.println("####[ReviewController.getBoardList]");
		/* 상품 번호 */
		session = request.getSession();
		product_id = (int) session.getAttribute("product_id");
		pageMap.put("page", page);
		pageMap.put("product_id", product_id);
		System.out.println("page : "+page);
		System.out.println("product_id : "+product_id);
		model.addAttribute("pageRange", pRange(product_id));
		model.addAttribute("boardList", reviewService.getBoardlist(pageMap));
		return "/review/getBoardList";
	}
	
	

	@RequestMapping("/reviewDelete.do")
	public ModelAndView reviewDelete(ReviewVO reviewVO) {
		ModelAndView mav = new ModelAndView();
		System.out.println("####[ReviewController.reviewUpdate]");
		System.out.println("reviewUpdate ReviewVO : "+reviewVO.getReview_id());
		System.out.println("reviewUpdate ReviewVO : "+reviewVO.getReview_score());
		System.out.println("reviewUpdate ReviewVO : "+reviewVO.getReview_content());
		
		reviewService.deleteReview(reviewVO);
		
		mav.setViewName("redirect:/getBoardList.do");
		return mav;
	}
	
	@RequestMapping("/reviewUpdate.do")
	public ModelAndView reviewUpdate(ReviewVO reviewVO, HttpServletRequest request) throws IOException {
		System.out.println("####[ReviewController.reviewUpdate]");
		ModelAndView mav = new ModelAndView();
		MultipartRequest mr = mrProvider(request);
		reviewVO.setReview_id(Integer.parseInt(mr.getParameter("review_id")));
		reviewVO.setReview_content(mr.getParameter("review_content"));
		reviewVO.setReview_score(Integer.parseInt(mr.getParameter("review_score")));
		
		reviewService.updateReview(reviewVO);
		
		mav.setViewName("redirect:/getBoardList.do");
		return mav;
	}

	
	@RequestMapping("/reviewInsert.do")
	public ModelAndView reviewInsert(ReviewVO reviewVO, HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException{
		ModelAndView mav = new ModelAndView();
//		MultipartRequest mr = new MultipartRequest(request, "c:\\tmp\\upload", 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
		MultipartRequest mr = mrProvider(request);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		Date now = sdf.parse(mr.getParameter("r_regdate"));
		
		reviewVO.setProduct_id(Integer.parseInt(mr.getParameter("r_product_id")));
		reviewVO.setMember_id(mr.getParameter("member_id"));
		reviewVO.setReview_score(Integer.parseInt(mr.getParameter("review_score")));
		reviewVO.setReview_regdate(now);
		reviewVO.setReview_content(mr.getParameter("review_content"));
		
		reviewService.insertReview(reviewVO);
		
		fileUpload(request, response);
		
		mav.setViewName("redirect:/getBoardList.do");
		return mav;
	}
	
	
	/* AJAX Method */
	@RequestMapping("/reviewSend.do")
	@ResponseBody
	public List<ReviewVO> reviewSend(@RequestParam(value="review", defaultValue="1", required=false)int reviewNum,
			HttpServletRequest request
			) {
		System.out.println("###[ReviewController.reviewSend]");
		
		pageMap.put("page", reviewNum);
		
		return reviewService.getBoardlist(pageMap);
	}
	
	
	@RequestMapping("/reviewPaging.do")
	@ResponseBody
	public int reviewPaging(@RequestParam(value="pageNum", defaultValue="0", required=false)int reviewBoxNum) {
		if(reviewBoxNum < 0 ) {  
			if(this.reviewBoxNum > 1) {
				this.reviewBoxNum += reviewBoxNum;
			}
		} else if(reviewBox > this.reviewBoxNum){
			this.reviewBoxNum += reviewBoxNum;
		}
		
		reviewSet = this.reviewBoxNum+((this.reviewBoxNum-1)*9);
		
//		if(this.reviewBoxNum == 1 && reviewBox <= this.reviewBoxNum+1) {
//			return "unable";
//		}
//		
//		if(this.reviewBoxNum == 1){
//			return "subUnable";
//		}
//		
//		if(reviewBox <= this.reviewBoxNum+1){
//			return "addUnable";
//		}
		return reviewSet;
	}
	
	/* paging 처리 메소드 */
	public Map<String, Integer> pRange(int product_id) {
		int reviewLimit = 10;                               // 하나의 리뷰페이지에 표시할 리뷰 개수
		int pageLimit = 10;                                 // 리뷰 페이지를 끊는 값 (previous, next를 적용 시킬 페이지 단위) 
		int top;                                            // JSP로 반환해 리뷰를 보여줄 최대 값
		int bottom;                                         // JSP로 반환해 리뷰를 보여줄 최소 값
		int reviewCount = reviewService.boardCount(product_id);       // 레코드의 총 개수
		System.out.println("reviewCount : "+reviewCount);
		Map<String, Integer> pageRange = new HashMap<String, Integer>();
		
		reviewTotal = reviewCount / reviewLimit;             // reviewTotal : 레코드 개수를 pageLimit으로 나눈 값
		if(reviewCount % reviewLimit > 0) reviewTotal += 1;  // pageLimit으로 연산 후 남은 레코드가 있을 경우 페이지를 추가한다. (추가된 페이지에 남은 레코드 출력)
		int lastReviewBox = reviewTotal;                     // lastReviewBox : 남은 레코드를 표현할 페이지까지 추가된 페이지의 총 개수
		
		
		// lastReviewBox = 1;
		// reviewTotal = 1
		
		// reviewBox
		reviewBox = reviewTotal / pageLimit;                 // reviewBox
		if(reviewTotal % pageLimit > 0) reviewBox += 1;
		
		if(reviewTotal >= pageLimit) reviewTotal = pageLimit * reviewBoxNum;
		
		if(reviewBox == reviewBoxNum) {
			top = lastReviewBox;
			if(top % 10 == 1) {
				bottom = top;
			} else {
				bottom = reviewBox*pageLimit-reviewLimit;
			}
			if(bottom < 1) bottom = 1;
			pageRange.put("top", top);
			pageRange.put("bottom", bottom);
			
		} else {
			top = reviewTotal;
			bottom = reviewTotal-(pageLimit-1);
			
			if(bottom < 0) {
				bottom = 1;
			}
			pageRange.put("top", top);
			pageRange.put("bottom", bottom);
		}
		
		return pageRange;
	}
	
	
	
	
	/*=============================================*/
	/* Login Test Controller */
	@RequestMapping("/login.do")
	public String login(MemberVO memberVO, HttpServletRequest request) {
		System.out.println("####[ReviewController.login]");
		
		MemberVO mVO = reviewService.getMember(memberVO);
		
		HttpSession session = request.getSession();
		member_id = mVO.getMember_id();
		session.setAttribute("member_id", member_id);
		return "/review/ProductTest";
	}
	
	
	/* product Select Test */
	@RequestMapping("/selectProduct.do")
	public ModelAndView getProduct(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		System.out.println("####[ReviewController.selectProduct]");
		HttpSession session = request.getSession();
		
		ProductVO pVO = reviewService.getProduct(Integer.parseInt(request.getParameter("product_id")));
		session.setAttribute("product_id", pVO.getProduct_id());
		
		mav.setViewName("redirect:/getBoardList.do");
		return mav;
	}
	
	/* 게시글 식별 정보 */
	@RequestMapping("/reviewid.do")
	@ResponseBody
	public Map<String, Object> review_identification(HttpServletRequest request) {
		Map<String, Object> review_map = new HashMap<String, Object>();
		review_map.put("member_id", member_id);
		review_map.put("product_id", product_id);
		
		return review_map;
	}
	
    public void fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("status","error");
		if( bDebug ) { System.out.println("Start : FileUploadServlet"); }
		// =======================================
		// 멀티파트를 전송했는지 확인
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            PrintWriter writer = response.getWriter();
            request.setAttribute("message","multipart/form-data 로 전송해야 합니다.");
            writer.println("Error: multipart/form-data 로 전송해야 합니다.");
            writer.flush();
            return;
        }
        // =======================================
        // 업로드 설정
        DiskFileItemFactory dfif = new DiskFileItemFactory();
        dfif.setSizeThreshold(MEMORY_THRESHOLD); // sets memory threshold - beyond which files are stored in disk
        dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));// 임시 저장 폴더 설정
        
        
        
        
        // 설정을 넣어서 업로드 개체를 만든다.
        ServletFileUpload upload = new ServletFileUpload(dfif);
        upload.setHeaderEncoding("UTF-8"); // 한글을 위해서
        upload.setFileSizeMax(MAX_FILE_SIZE);// sets maximum size of upload file
        upload.setSizeMax(MAX_REQUEST_SIZE);// sets maximum size of request (include file + form data)
        
        // =======================================
        // 업로드 자료를 보관할 폴더명 설정 ServletContext 이므로 현재 테스트 되는 임시 웹 폴더에 업로드된다 .. 
//        String sUploadDirectory = getServletContext().getRealPath("")+ UPLOAD_DIRECTORY  ;
        String sUploadDirectory = "C:\\tmp\\upload";
        if( bDebug ) { System.out.println("uploadPath:" + sUploadDirectory);}
        
        // 업로드 폴더가 없는 경우 생성
        File uploadDir = new File(sUploadDirectory);
        if (!uploadDir.exists()) { uploadDir.mkdir(); }
        uploadDir = null;
        
        // =======================================
        // 파일 업로드
        try {
            @SuppressWarnings("unchecked") // 컴파일러 경고중 unchecked 는 제외합니다.
            
            // request 대신 upload 하는 것으로 받아야 됩니다 .. 
            List<FileItem> formItems = upload.parseRequest(request);
            
            // 전송된 것이 null 이 아니고 사이즈가 있는 경우만 실행
            if (formItems != null && formItems.size() > 0) {
                
                for (FileItem item : formItems) {
                    
                    if (item.isFormField()) {
                    	// form field 인 경우
                    	String FormFieldName  = item.getFieldName(); // input 박스 Name
                    	String FormFieldValue = item.getString("UTF-8"); // 컨트롤의 값을 한글로 받아주기
                    	
                    	if( bDebug ) { System.out.println("Name:{"+FormFieldName+"} . Value:{"+FormFieldValue+"}");}
                    	
                    } else {
                    	// 파일이 사이즈가 있으면 진행.. 
            			
	                    	// 업로드된 파일명을 알아온다.
                    		long lFileSize      = item.getSize(); // 파일 사이즈
                    		String sContentType = item.getContentType(); // 컨텐츠 유형 image/png
                    		String sOrgFileName = item.getName(); // 원본 파일명  a.png
                    		
                    		// a.txt에서  a , txt 분리
	            			String sFileName      = org.apache.commons.io.FilenameUtils.getBaseName(sOrgFileName);
	            			String sFileExtension = org.apache.commons.io.FilenameUtils.getExtension(sOrgFileName).toLowerCase(); // 확장자는 소문자로 변환
	            			
	            			if( bDebug ) { System.out.println(
                					"파일사이즈:" + lFileSize + " . 컨텐츠유형:{"+sContentType+"} . 원본파일명:{"+sOrgFileName+"}"
                							+ "파일명:{"+sFileName+"} . 파일확장자:{"+sFileExtension+"}"
                					);}
                			System.out.println("#### 경로 : "+sUploadDirectory+" 파일 이름 : "+sFileName+", 확장자 : "+sFileExtension+", 원본 파일명 : "+sOrgFileName+"####");
	            			
	            			// 확장자 검사
	            			String[] lAbleExt = {"bmp","png","pdf","jpg"} ;
	            			boolean bAbleExt = false ;
	            			for (String ableExt : lAbleExt) {
	            				if ( ableExt == sFileExtension ) {
									bAbleExt = true;
									break;
								}
							}
	            		
	            			// 파일 업로드
//                			if ( bAbleExt == false ) {
//                				item.delete(); // request 받은 파일도 삭제한다.
//                				request.setAttribute("message","업로드 불가 확장자명입니다." + lAbleExt.toString() );
//                			} else {
	                			// 업로드되는 고유명을 만든다.
	                			// 중복될 일은 없으니 a(1).png 처럼 할 필요는 없다.
	                			String sSaveFileName = sFileName + "." + sFileExtension;
	                			
		                    	// 업로드할 경로와 파일명을 설정한다.
		                    	String filePath = sUploadDirectory + java.io.File.separator + sSaveFileName;
		                    	if( bDebug ) { System.out.println("upload filePath:" + filePath); }
		                        
		                        // 파일 개체를 만든다.
		                        File savedFile = new File(filePath);
		                        item.write(savedFile); // 파일 저장 item --> storeFile 에 쓰기 해준다.
		                        item.delete(); // request 한 파일도 삭제한다.
		                        
		                        if ( savedFile.exists()) {
		                        	if( bDebug ) { request.setAttribute("status","success");
		                        	System.out.println("Upload has been done successfully!");}
		                        	request.setAttribute("message","Upload has been done successfully! " + filePath );
		                        } else {
		                        	if( bDebug ) { System.out.println("Error : Create file");}
		                        	request.setAttribute("message","Error : Create file" + filePath );
		                        }
		                        savedFile = null;
//                    	} // end able 
		                        
                			
                    } // end FormField
                } // end for
            } // end formitem
        } catch (Exception e) {
        	if( bDebug ) { System.out.println("Upload Error");e.printStackTrace();}
        	request.setAttribute("message","There was an error: " + e.getMessage());
        }
    }
    
    
    public MultipartRequest mrProvider(HttpServletRequest request) throws IOException {
    	MultipartRequest mr = new MultipartRequest(request, "c:\\tmp\\upload", 1024*1024*10, "UTF-8", new DefaultFileRenamePolicy());
    	return mr;
    }
	
}


