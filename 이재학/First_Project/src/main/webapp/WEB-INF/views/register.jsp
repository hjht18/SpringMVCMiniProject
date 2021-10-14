<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<title>회원가입</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="container">
		<div class="col-md-6 col-md-offset-3">
			<form action="register.do" method="post">
				<h2>회원가입</h2>
				<div class="col-md-12">
					<label>이메일(아이디)</label>
				</div>
				<div class="form-group col-md-8">
					<input type="email" name="memberId" class="form-control"
						placeholder="이메일을 입력해주세요">
				</div>
				<span class="col-md-3">
					<button class="btn btn-info">중복확인</button>
					<br>
				<br>
				</span>
				<div class="col-md-12">
					<label>비밀번호</label>
				</div>
				<div class="form-group col-md-12">
					<input type="password" name="password" class="form-control"
						placeholder="비밀번호를 입력해주세요"><br>
				</div>

				<div class="col-md-12">
					<label>비밀번호 확인</label>
				</div>
				<div class="form-group col-md-12">
					<input type="password" class="form-control"
						placeholder="비밀번호를 다시 한 번 입력해주세요"><br>
				</div>

				<div class="col-md-12">
					<label>이름</label>
				</div>
				<div class="form-group col-md-12">
					<input type="text" name="name" class="form-control"
						placeholder="고객님의 이름을 입력해주세요"><br>
				</div>

				<div class="col-md-12">
					<label>전화번호</label>
				</div>
				<div class="form-group col-md-8">
					<input type="text" name="phoneNum" class="form-control" placeholder="'-'를 포함해서 입력해주세요">
				</div>

				<div class="col-md-12">
					<label>주소</label>
				</div>
			
				<div class="form-group col-md-8">
					<input type="text" id="postNum" name="postNum" class="form-control">
				</div>
				<span class="col-md-3">
					<button type="button" onclick="javascript:fn_openAddressPopup();">주소 검색</button>
					<!-- <button class="btn btn-info">검색</button>  -->
					<br>
				<br>
				</span>
				<div class="form-group col-md-12">
					<input type="text" id="address1" name="address1" class="form-control">
				</div>
				<div class="form-group col-md-12">
					<input type="text" id="address2" name="address2" class="form-control"
						placeholder="나머지 주소를 입력해주세요"><br>
				</div>

				<div class="col-md-12">
					<label>대표이미지</label>
				</div>
				<div class="col-md-4">
					<img src="" alt="섬네일">
				</div>
				<div class="form-group col-md-7">
					<!-- type = "file" 로 수정 필요 -->
					<input type="text" name="userImage" class="form-control">
				</div>

				<span class="col-md-3 col-md-offset-2">
					<button class="btn btn-success" type="submit">회원 가입</button>
				</span> <span class="col-md-3 col-md-offset-2">
					<button class="btn btn-warning ">취소</button>
				</span>
			</form>
		</div>
	</div>
	<script>
		
	<%-- 예제파일의 memberReg.jsp 부분을 참고하였습니다 -->

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