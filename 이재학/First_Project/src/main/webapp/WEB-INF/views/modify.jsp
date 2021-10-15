<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>회원정보 수정</title>
<script src='main.js'></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<style>
#input {
	width: 260px;
}

.field-error {
	color: #dc3545;
	font-size: 12px;
}

#label1 {
	font-size: 20px;
}

.btn-success {
	background-color: rgb(39, 176, 110);
	color: #fff;
}
</style>
</head>

<body>

	<div class="container" style="display: flex; justify-content: center;">
		<div class="row">
			<form class="form-horizontal" action="modify.do" method="post">
				<fieldset>
					<br>
					<br>

					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label" id="label1">회원정보 수정</label>
					</div>
					<br>
					<hr>

					<!-- 아이디 수정 불가-->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label">이메일 아이디</label>
						<div class="col-md-6">
							<input type="email" name="memberId" class="form-control input-md"
								id="input" value="${loginMember.memberId}" readonly>
						</div>
					</div>

					<!-- 비밀번호 수정-->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label">새 비밀번호</label>
						<div class="col-md-5">
							<input type="password" name="password"
								placeholder="새로운 비밀번호를 입력해주세요" class="form-control input-md"
								id="input">
						</div>
					</div>

					<!-- 비밀번호 확인-->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label">비밀번호 확인</label>
						<div class="col-md-5">
							<input name="repassword" type="password"
								placeholder="비밀번호를 다시 한 번 입력해주세요" class="form-control input-md"
								id="input">
						</div>
					</div>

					<!-- 이름 수정-->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label">이름</label>
						<div class="col-md-5">
							<input type="text" name="name" class="form-control input-md"
								placeholder="고객님의 이름을 입력해주세요" id="input"
								value="${loginMember.name}">
						</div>
					</div>

					<!-- 전화번호 수정-->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label">전화번호</label>
						<div class="col-md-5">
							<input type="text" name="phoneNum" class="form-control input-md"
								placeholder="'-'를 포함해서 입력해주세요" id="input"
								value="${loginMember.phoneNum}">
						</div>
					</div>

					<!-- 주소 수정-->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label">주소</label>
						<div class="col-md-5">
							<input type="text" name="postNum" id="postNum"
								class="form-control input-md" style="width: 160px;"
								value="${loginMember.postNum}" readonly>
							<button class="btn btn-success"
								style="position: relative; bottom: 34px; left: 175px;"
								type="button" onclick="javascript:fn_openAddressPopup();">주소
								검색</button>
							<input type="text" name="address1" class="form-control input-md"
								style="position: relative; bottom: 20px;" id="address1"
								value="${loginMember.address1}" readonly> <input
								type="text" id="address2" name="address2" class="form-control input-md"
								placeholder="나머지 주소를 입력해주세요" id="input">
						</div>
					</div>

					<!--유저이미지 수정-->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label">대표이미지</label>
						<div class="col-md-5">
							<img src="" alt="섬네일"> <input type="text" name="userImage"
								class="form-control input-md"
								style="width: 170px; position: relative; left: 90px;">
						</div>
					</div>

					<!-- 수정 및 취소 버튼 -->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<button name="submit" class="btn btn-success">정보 수정</button>
							&nbsp;
							<button class="btn btn-warning" type="button">취소</button>
							&nbsp;
							<button class="btn btn-info" type="button">회원 탈퇴</button>
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