<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>메인 페이지</title>
    <link href="${context}/css/style.css" type="text/css" rel="stylesheet">
    <link href="${context}/css/style.css" media="screen and(min-width: 600px)" rel="stylesheet">
    <script src="${context}/javascript/jquery-1.12.3.js"></script>
    <script src="${context}/javascript/script.js" defer type="text/javascript"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
    <div class="bodywrap">
        <div class="imgslide">
            <a href="#">
            <img src="${context}/images/slide1.png" alt="이미지1">
             <span class="imgtext">주문</span>
           </a>
           <a href="#">
            <img src="${context}/images/slide2.png" alt="이미지2">
            <span class="imgtext">주문</span>
          </a>
          <a href="#">
            <img src="${context}/images/slide3.png" alt="이미지3">
            <span class="imgtext">주문</span>
          </a>
        </div>

        <footer>
        <div class="copy">
          COPYRIGHT ©️ by WEBDESIGN. ALL RIGHTS RESERVED
        </div>
        <div class="site">
          <div class="btmenu">
            <ul>
              <li><a href="#">하단메뉴1</a></li>
              <li><a href="#">하단메뉴2</a></li>
              <li><a href="#">하단메뉴3</a></li>
            </ul>
          </div>
        </footer>
    
</body>
</html>