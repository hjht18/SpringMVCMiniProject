<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 컨텍스트 경로 설정 => ${context} -->
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Bootstrap 4 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<title>로그인 화면</title>
<script type="text/javascript"
	src="https://developers.kakao.com/sdk/js/kakao.js"></script>
</head>
<body>

	<div class="container" style="max-width: 600px">
		<div class="py-5 text-center">
			<h2>로그인 화면</h2>
		</div>
		<div class="row">
			<div class="col">
				<button class="w-100 btn btn-secondary btn-lg" type="button">회원 가입</button>
			</div>
			<div class="col">
				<button class="w-100 btn btn-dark btn-lg">로그인</button>
			</div>
		</div>
		<hr class="my-4">
	</div>
	<div class="container" style="max-width: 600px">
	<h3>로그인</h3>
	<a href="${context}/logout"><button>로그아웃</button></a>
	<a href="${context}/main.jsp"><button>처음으로</button></a>
	<br>
	<br>

	<!-- 카카오 로그인 테스트 (화면만 구현해놓음) -->
	<a href="javascript:kakaoLogin();"><img
		src="resources/image/kakao_login_medium_narrow.png"></a>
	</div>
		
	<!-- <button onclick="javascript:kakaoLogin();" value="카카오 로그인">카카오 로그인 테스트</button>  -->
	<script>	
		window.Kakao.init("5dac7b1bcfac5bc2a292b7f1f8bc371f");
		function kakaoLogin(){
			window.Kakao.Auth.login({
				scope:'profile, account_email, gender',
				success : function(authObj){
					console.log(authObj);
					window.Kakao.API.request({
						url:'/v2/user/me',
						success: res => {
							const kakao_account = res.kakao_account;
							console.log(kakao_account);
						}
					});
				}
			});
		}
	</script>
</body>
</html>