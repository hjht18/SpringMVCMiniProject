<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
 <!DOCTYPE html>
    <html>
    <head>
        <meta charset='utf-8'>
        <title>메인 페이지</title>
        <link href="${context}//css/style.css" type="text/css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
		<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&family=Single+Day&display=swap" rel="stylesheet">
        <script src="${context}/javascript/jquery-1.12.3.js"></script>
        <script src="${context}/javascript/script.js" defer type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/e5732aa35f.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <nav class="top" id="menuwrap">
              <div class="logo">
                <i class="fas fa-leaf"></i>
                <a href="#">Fresh Salad</a>
              </div>
                  <ul class="navi">
                    <li><a href="#">퓨어주스</a>
                    </li>
                    <li><a href="#">주문</a>
                    </li>
                    <li><a href="#">소개</a>
                    </li>
                    <li><a href="#">FQA</a>
                    </li>
                    <li><a onclick="javascript:fn_isLogin('${sessionScope.userCode}','${loginUrl}','${context}/work/board/retrieveBoardList.do')">문의</a>
                    </li>   
                  </ul>
                  <ul class="cartlogo">
                    <c:if test="${sessionScope.userid == null}">
                        <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" onclick="javascript:fnlogin();">로그인</button>
                        </c:if>
                        <c:if test="${sessionScope.userid != null}">
                        <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" onclick="javascript:fnlogout();">로그아웃</button>
                    </c:if>
                    <a href="#"><i class="fas fa-shopping-cart"></i></a>
                </ul>
              <a href="#" class="toggleBtn">
                <i class="fas fa-bars"></i>
            </a>

            
        </nav>
        </header>
        </body>
</html>