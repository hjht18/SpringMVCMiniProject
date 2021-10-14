<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
 <!DOCTYPE html>
    <html>
    <head>
        <meta charset='utf-8'>
        <title>메인 페이지</title>
        <link href="css/style.css" type="text/css" rel="stylesheet">
        <script src="js/jquery-1.12.3.js"></script>
        <script src="js/script.js" defer type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/e5732aa35f.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <header>
            <nav class="top" id="menuwrap">
              <div class="logo">
                <i class="fas fa-leaf"></i>
                <a href="#">Fresh</a>
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
                        <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" onclick="javascript:fnlogin();"><i class="fa fa-user"></i>Login</button>
                        </c:if>
                        <c:if test="${sessionScope.userid != null}">
                        <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" onclick="javascript:fnlogout();"><i class="fa fa-user"></i> Logout</button>
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