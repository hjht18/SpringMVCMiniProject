<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
	<meta charset='utf-8'>
	<title>회원 탈퇴</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<style>
	.field-error {
		 color: #dc3545;
		 font-size: 12px;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
					
			$("#submit").on("click", function(){
				if($("#password").val()==""){
					alert("비밀번호를 입력해주세요.");
					$("#password").focus();
					return false;
				} 
			});
			
		})
	</script>

</head>

<body>

	<div class="container">
		<div class="col-md-6 col-md-offset-3">
			<form action="unregister.do" method="post">
				<h2>회원탈퇴</h2>
				<div class="col-md-12">
					<label>이메일(아이디)</label>
				</div>
				 <div class="form-group col-md-8">
					<input type="email" class="form-control" id="memberId"  name="memberId" value="${loginMember.memberId}" readonly="readonly" }">
				</div>

				<div class="col-md-12">
					<label>비밀번호 확인</label>
				</div>
				<div class="form-group col-md-12">
					<input type="password" class="form-control" id="password" name="password" placeholder="비밀번호를 입력해주세요">
					<c:if test="${errors.passwordValid}"><p class="field-error">비밀번호가 일치하지 않습니다!</p></c:if>
				</div>

				<span class="col-md-2 col-md-offset-3">
					<button class="btn btn-success" type="submit" id="submit">탈퇴</button>
				</span>
				<span class="col-md-2 col-md-offset-2">
					<a href="/index.jsp"><button class="cencle btn btn-warning" type="button">취소</button></a>
				</span>
			</form>
		</div>
	</div>

</body>

</html>