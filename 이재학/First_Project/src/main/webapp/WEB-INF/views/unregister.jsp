<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset='utf-8'>
<title>회원 탈퇴</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
.field-error {
	color: #dc3545;
	font-size: 12px;
}
</style>
<script type="text/javascript">
	$(document).ready(function() {

		$("#submit").on("click", function() {
			if ($("#password").val() == "") {
				alert("비밀번호를 입력해주세요.");
				$("#password").focus();
				return false;
			}
		});

	})
</script>

</head>

<body>
	<div class="container" style="display: flex; justify-content: center;">
		<div class="row">
			<form class="form-horizontal" action="unregister.do" method="post">
				<fieldset>
					<br>
					<br>

					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label" id="label1">회원 탈퇴</label>
					</div>
					<hr>
					<!-- 이메일 아이디 입력-->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label">이메일 아이디</label>
						<div class="col-md-6">
							<input type="email" name="memberId"
								value="${loginMember.memberId}" placeholder="아이디를 입력해주세요"
								class="form-control input-md" id="input" readonly>
						</div>
					</div>
					<br>

					<!-- 비밀번호 입력-->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label">비밀번호</label>
						<div class="col-md-5">
							<input type="password" name="password" placeholder="비밀번호를 입력해주세요"
								class="form-control input-md" id="input">
							<c:if test="${errors.passwordValid}">
								<p class="field-error">비밀번호가 일치하지 않습니다!</p>
							</c:if>
						</div>
					</div>

					<!-- 탈퇴 사유 입력-->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label">탈퇴 사유</label>
						<div class="col-md-5">
							<textarea rows="6" style="width: 290px;" class="form-control"
								placeholder="탈퇴 사유를 입력해주세요"></textarea>
						</div>
					</div>

					<!--체크박스-->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-5">
							<input type="checkbox">회원을 탈퇴하시겠습니까?
						</div>
					</div>

					<!-- 탈퇴 및 취소 버튼 -->
					<div class="col-md-12 form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-4">
							<button name="submit" class="btn btn-success">회원 탈퇴</button>
							&nbsp; <a href="/index.jsp"><button class="btn btn-warning"
									type="button">취소</button></a>&nbsp;
						</div>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>

</html>