<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 컨텍스트 경로 설정 => ${context} -->
<c:set var="context" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>회원 탈퇴 완료</title>
        <link href="/css/registerAndUnregisterSuccess.css" rel="stylesheet" />

    <body id="page-top">
        <!-- About -->
        <section class="page-section">
            <div class="container px-4 px-lg-5">
                <div class="row gx-4 gx-lg-5 justify-content-center">
                    <div class="col-lg-8 text-center">
                        <h2 style="margin-top: 0 !important;">회원 탈퇴가 완료되었습니다.</h2>
                        <hr class="divider divider-light" />
                        <p style=" margin-bottom: 1.5rem !important;">그동안 저희 서비스를 이용해주셔서 감사합니다.<br>
                            보다 나은 서비스로 다시 찾아 뵙겠습니다.
                        </p>
                        <a class="btn btn-success btn-lg" href="/index.jsp">확인</a>
                    </div>
                </div>
            </div>
        </section>
    
</body>
</html>