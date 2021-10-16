<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
	<meta name='viewport' content='width=device-width, initial-scale=1'>
	<meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>회원가입</title>
	<script src='main.js'></script>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<style>
		.field-error {
		 color: #dc3545;
		 font-size: 12px;
		}

		button{
			background-color: rgb(39, 176, 110); 
			color: #fff;
		}
		</style>	
</head>
<body>
	

	<div class="container"  style="display: flex; justify-content: center;">
		<div class="row">
		<form class="form-horizontal" action="register.do" method="post">
	<fieldset>
	
		<br><br>
	<!-- Text input-->
	<div class="col-md-12 form-group">
	  <label class="col-md-4 control-label">이메일 아이디</label>  
	  <div class="col-md-6">
	  <input type="email" name="memberId" placeholder="이메일을 입력해주세요" class="form-control input-md" style="width: 260px;">
	  <c:if test="${errors.memberId}"><p class="field-error">이메일을 입력해주세요!</p></c:if>
	  <c:if test="${errors.duplicateId}"><p class="field-error">중복된 이메일입니다!</p></c:if>
	  <!-- <button class="btn">중복확인</button>  -->
		
	  </div>
	</div>
	
	<!-- Password input-->
	<div class="col-md-12 form-group">
	  <label class="col-md-4 control-label">비밀번호</label>
	  <div class="col-md-5">
		<input type="password" name="password"  placeholder="비밀번호를 입력해주세요" class="form-control input-md" style="width: 260px;">
		<c:if test="${errors.password}"><p class="field-error">비밀번호를 입력해주세요!</p></c:if>
	</div>
	</div>

		<!-- Password input-->
		<div class="col-md-12 form-group">
			<label class="col-md-4 control-label">비밀번호 확인</label>
			<div class="col-md-5">
			    <input name="repassword" type="password" placeholder="비밀번호를 다시 한 번 입력해주세요" class="form-control input-md" style="width: 260px;">
				<c:if test="${errors.passwordValid}"><p class="field-error">비밀번호와 일치하지 않습니다!</p></c:if>
			</div>
		</div>

	<!-- Text input-->
	<div class="col-md-12 form-group">
	  <label class="col-md-4 control-label">이름</label>  
	  <div class="col-md-5">
	  <input type="text" name="name" class="form-control input-md" style="width: 260px;">
	  <c:if test="${errors.name}"><p class="field-error">이름은 필수입니다!</p></c:if>
	  </div>
	</div>
	
	
	<!-- Text input-->
	<div class="col-md-12 form-group">
		<label class="col-md-4 control-label">전화번호</label>  
		<div class="col-md-5">
		<input type="text" name="phoneNum" class="form-control input-md" style="width: 260px;" placeholder="'-'를 포함해서 입력해주세요">
		
		</div>
	</div>


	<!-- Text input-->
	<div class="col-md-12 form-group">
		<label class="col-md-4 control-label">주소</label>  
		<div class="col-md-5">
		<input type="text" name="postNum" id="postNum" class="form-control input-md" style="width: 160px;" readonly> 
			<button class="btn" style="position: relative; bottom: 34px; left: 175px;" type="button" onclick="javascript:fn_openAddressPopup();">주소 검색</button>
			<input type="text" id="address1" name="address1" class="form-control input-md" style="width: 260px; position: relative; bottom: 20px;" readonly>
			<input type="text" id="address2" name="address2" class="form-control input-md" style="width: 260px;" placeholder="나머지 주소를 입력해주세요">  
		</div>
	</div>


	<div class="col-md-12 form-group">
		<label class="col-md-4 control-label" for="Name">대표이미지</label>  
		<div class="col-md-5">
			<img src="" alt="섬네일">
			<input type="text" size="13" name="userImage" style="position: relative; left: 70px;">
		</div>
	</div>
		
	
	<!-- Button -->
	<div class="col-md-12 form-group">
		<label class="col-md-4 control-label" for="submit"></label>
	    <div class="col-md-4">
				<button name="submit" class="btn">가입</button>
				<a href="/index.jsp"><button class="btn btn-warning" type="button">취소</button></a>
	  	</div>
	</div>
	
	</fieldset>
	</form>
		</div>
	</div>
	<script> 
		<%-- 주소검색 팝업 호출 --%>
				function fn_openAddressPopup() {
					var url = "addressAPI.do";
					var name = "AddressPopup";
					var option = "width=650, height=500, top=100, left=200, location=no"
					window.open(url, name, option);
				}
			<%-- 주소검색 팝업 호출 CallBack --%>
				function callback_openAddressPopup(aParam) {
					document.getElementById("address1").value = aParam["roadAddr"]
					document.getElementById("postNum").value = aParam["zipNo"];
				}
			</script>
	</body>
</html>