package com.project.mini.test;

//  추가적으로 필요한 패키지
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/uploadFilesdf.do")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private boolean bDebug = true ; // 디버그일때 print
	// 기본 업로드 폴더
	private static final String UPLOAD_DIRECTORY = "upload";
	
	// 업로드 설정
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 최대 파일 크기 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // request 전송되는 파일 사이즈 : 파일사이즈 + form data , 50MB
	
    public FileUploadServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("status","error");
		if( bDebug ) { System.out.println("Start : FileUploadServlet"); }
		
		// =======================================
		// 멀티파트롤 전송했는지 확인
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
        dfif.setRepository(new File(System.getProperty("java.io.tmpdir")));// 임지 저장 폴더 설정
        
        // 설정을 넣어서 업로드 개체를 만든다.
        ServletFileUpload upload = new ServletFileUpload(dfif);
        upload.setHeaderEncoding("UTF-8"); // 한글을 위해서
        upload.setFileSizeMax(MAX_FILE_SIZE);// sets maximum size of upload file
        upload.setSizeMax(MAX_REQUEST_SIZE);// sets maximum size of request (include file + form data)
        
        // =======================================
        // 업로드 자료를 보관할 폴더명 설정 ServletContext 이므로 현재 테스트 되는 임시 웹 폴더에 업로드된다 .. 
        String sUploadDirectory = getServletContext().getRealPath("")+ UPLOAD_DIRECTORY  ;
        if( bDebug ) { System.out.println("uploadPath:" + sUploadDirectory);}
        
        // 업로도드 폴더가 없는 경우 생성
        File uploadDir = new File(sUploadDirectory);
        if (!uploadDir.exists()) { uploadDir.mkdir(); }
        uploadDir = null;
        
        // =======================================
        // 파일 업로드
        try {
            @SuppressWarnings("unchecked") // 컴파일러 경고중 unchecked 는 제외합니다.
            
            // request 대신 upload 하는 것으로 받아야 됩니다 .. 
            List<FileItem> formItems = upload.parseRequest(request);
            
            // 전송된 것이 null 이 아니고 사이즈가 있는 격우만 실행
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
	                			String sAddFileName = java.util.UUID.randomUUID().toString();
	                			String sSaveFileName = sFileName + "_" +sAddFileName + "." + sFileExtension;
	                			
		                    	// 업로드할 경로와 파일명을 설정한다.
		                    	String filePath = sUploadDirectory + java.io.File.separator + sSaveFileName;
		                    	if( bDebug ) { System.out.println("upload filePath:" + filePath); }
		                        
		                        // 파일 개체를 만든다.
		                        File savedFile = new File(filePath);
		                        item.write(savedFile); // 파일 저장 item --> storeFile 에 쓰기 해준다.
		                        item.delete(); // request 한 파일도 삭제한다.
		                        
		                        if ( savedFile.exists()) {
		                        	if( bDebug ) { request.setAttribute("status","success");System.out.println("Upload has been done successfully!");}
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
        
        // =======================================
        // 화면에 보일 페이지 이동
        getServletContext().getRequestDispatcher("/uploadEnd.jsp").forward(request, response);
        
	} // end method

} // end class
