<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/book.css">
<script src="script/jquery-3.6.0.js"></script>
<script src="member/member.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div>
		<div id="findHeader">
			<div class="findHeader1">
				<a href="bs.do?cmd=index" id="fhLogo"><img src="../main/logo.png"></a>
				<span class="fhTextOn"><a href="bs.do?cmd=findId">아이디 찾기</a></span>
				<span class="division">&nbsp;|&nbsp;</span>
				<span class="fhTextOff"><a href="bs.do?cmd=findPwd">비밀번호 찾기</a></span>
				
				<div id="sideButton">
					<span class="sideButton1"><a href="bs.do?cmd=loginForm">로그인</a></span>
					<span class="sideButton1"><a href="bs.do?cmd=contract">회원가입</a></span>
				</div>
			</div>
		</div>
회원님의 비밀번호는 [${MemberVO.pwd}] 입니다.
<input type="button" value="로그인하러 가기" onClick="location.href='bs.do?cmd=loginForm'">
</div>
</body>
</html>