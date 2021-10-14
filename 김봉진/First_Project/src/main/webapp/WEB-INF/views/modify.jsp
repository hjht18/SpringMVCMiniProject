<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset='utf-8'>
	<title>회원정보 수정</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>

<body>

	<div class="container">
		<div class="col-md-6 col-md-offset-3">
			<form action="#">
				<h2>회원정보 수정</h2>
				<div class="col-md-12">
					<label>이메일(아이디)</label>
				</div>
				<div class="form-group col-md-8">
					<input type="email" class="form-control" disabled>
				</div>
				<div class="col-md-12">
					<label>새 비밀번호</label>
				</div>
				<div class="form-group col-md-12">
					<input type="password" class="form-control" placeholder="새로운 비밀번호를 입력해주세요"><br>
				</div>

				<div class="col-md-12">
					<label>비밀번호 확인</label>
				</div>
				<div class="form-group col-md-12">
					<input type="password" class="form-control" placeholder="비밀번호를 다시 한 번 입력해주세요"><br>
				</div>

				<div class="col-md-12">
					<label>이름</label>
				</div>
				<div class="form-group col-md-12">
					<input type="text" class="form-control" placeholder="고객님의 이름을 입력해주세요"><br>
				</div>

				<div class="col-md-12">
					<label>전화번호</label>
				</div>
				<div class="form-group col-md-4">
					<input type="text" class="form-control">
				</div>
				<div class="form-group col-md-4">
					<input type="text" class="form-control">
				</div>
				<div class="form-group col-md-4">
					<input type="text" class="form-control"><br>
				</div>

				<div class="col-md-12">
					<label>주소</label>
				</div>
				<div class="form-group col-md-8">
					<input type="text" class="form-control" disabled>
				</div>
				<span class="col-md-3">
					<button class="btn btn-info">검색</button><br><br>
				</span>
				<div class="form-group col-md-12">
					<input type="text" class="form-control" disabled>
				</div>
				<div class="form-group col-md-12">
					<input type="text" class="form-control" placeholder="나머지 주소를 입력해주세요"><br>
				</div>

				<div class="col-md-12">
					<label>대표이미지</label>
				</div>
				<div class="col-md-4">
					<img src="" alt="섬네일">
				</div>
				<div class="form-group col-md-7">
					<input type="file" class="form-control">
				</div>

				<span class="col-md-3 col-md-offset-2">
					<button class="btn btn-success">정보 수정</button>
				</span>
				<span class="col-md-3 col-md-offset-2">
					<button class="btn btn-warning ">취소</button>
				</span>


			</form>
		</div>
	</div>

</body>

</html>