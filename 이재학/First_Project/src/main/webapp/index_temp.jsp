<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var ="context"><%=request.getContextPath()%></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <title>Fresh</title>
    <link href="css/style3.css" type="text/css" rel="stylesheet">
    <link href="css/style3.css" media="screen and(min-width: 600px)" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-1.12.3.js"></script>
    <script src="js/script.js" defer type="text/javascript"></script>
</head>
<body>
<jsp:include page="common/header.jsp"></jsp:include>
    <div class="bodywrap">
        <div class="imgslide">
            <a href="#">
            <img src="img/slide1.png" alt="이미지1">
             <span class="imgtext">주문</span>
           </a>
           <a href="#">
            <img src="img/slide2.png" alt="이미지2">
            <span class="imgtext">주문</span>
          </a>
          <a href="#">
            <img src="img/slide3.png" alt="이미지3">
            <span class="imgtext">주문</span>
          </a>
        </div>
        </div>
<jsp:include page="common/footer.jsp"></jsp:include>
</body>
</html>