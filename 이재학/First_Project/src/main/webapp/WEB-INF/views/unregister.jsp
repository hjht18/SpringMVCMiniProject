<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset='utf-8'>
	<title>회원 탈퇴</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>

<body>

	<div class="container">
		<div class="col-md-6 col-md-offset-3">
			<form action="#">
				<h2>회원탈퇴</h2>
				<div class="col-md-12">
					<label>이메일(아이디)</label>
				</div>
				<div class="form-group col-md-8">
					<input type="email" class="form-control" placeholder="아이디를 입력해주세요">
				</div>

				<div class="col-md-12">
					<label>비밀번호 확인</label>
				</div>
				<div class="form-group col-md-12">
					<input type="password" class="form-control" placeholder="비밀번호를 입력해주세요">
				</div>

				<div class="checkbox col-md-12">
					<label>
					  <input type="checkbox"> 정말 가입을 탈퇴하시겠습니까? <br><br>
					</label>
				  </div>

				<span class="col-md-2 col-md-offset-3">
					<button class="btn btn-success ">탈퇴</button>
				</span>
				<span class="col-md-2 col-md-offset-2">
					<button class="btn btn-warning ">취소</button>
				</span>
			</form>
		</div>
	</div>

</body>

</html>