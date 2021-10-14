<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <script src='main.js'></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.js"></script>
    <!------ Include the above in your HEAD tag ---------->
    <style>
        body{
  
    font-size:12px;
    color:#fff;
}
.simple-login-container{
    width:300px;
    max-width:100%;
    margin:50px auto;
}
.simple-login-container h2{
    text-align:center;
    font-size:20px;
}

.simple-login-container .btn-login{
    background-color:  #5ca848;
    color:#fff;
}
a{
    color:#5ca848;
}
.hr-sect {
	display: flex;
	flex-basis: 100%;
	align-items: center;
	color: rgba(0, 0, 0, 0.35);
	font-size: 12px;
	margin: 8px 0px;
}

.hr-sect::before,
.hr-sect::after {
	content: "";
	flex-grow: 1;
	background: rgba(0, 0, 0, 0.35);
	height: 1px;
	font-size: 0px;
	line-height: 0px;
	margin: 0px 16px;
}
    </style>


</head>
<body>
	
    <div class="simple-login-container">
        <div class="row">
            <div class="col-md-12 form-group">
                <a href="javascript:kakaoLogin();"><img src="/img/kakao_login_medium_wide.png" alt="카카오로 로그인하기" width="300px" height="45px"></a>
            </div>
        </div> 
        <div class="row">
            <div class="col-md-12 form-group">
                <img src="https://freshcode.s3.ap-northeast-2.amazonaws.com/img/new_secret_coupon/20211001-renewal/banner.jpg" alt="첫 주문 혜택 페이지로 가기" width="100%" height="100px">
            </div>
        </div> 
        <div class="hr-sect">OR</div><br>
        <div class="row">
            <div class="col-md-12 form-group">
                <input type="text" id="memberId" name="memberId" class="form-control" placeholder="이메일 아이디">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 form-group">
                <input type="password" id="password" name="password" placeholder="패스워드" class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 form-group" style="display: flex; justify-content: center;">
                <button type="submit" class="btn btn-success" >로그인</button>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12" style="display: flex; justify-content: center;">
                <a href="register.do">아직 회원이 아니신가요? 회원이 되어 보세요</a>
            </div>
        </div>
    </div>
    <hr>
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