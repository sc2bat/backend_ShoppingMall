<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookStore</title>
<link rel="stylesheet" href="css/book.css">
<script src="member/member.js"></script>
<script src="mypage/mypage.js"></script>
</head>
<body>
<div id="wrap">
	<header>
		<div>
			<nav id="top_menu">
				<ul>
					<li><a href="bs.do?cmd=qna">고객센터</a></li>
					<li><a href="bs.do?cmd=orderView" style="width:80px;">주문/배송조회</a></li>
					<li><a href="bs.do?cmd=cart">장바구니</a></li>
					<li><a href="bs.do?cmd=joinForm">회원가입</a></li>
					<li><a href="bs.do?cmd=loginForm">로그인</a></li>
					<li><a href="bs.do?cmd=mypage">마이페이지</a></li>
				</ul>
			</nav>
		</div>
		<br><br>
		
		<!-- 검색창 -->
		<div>
			<div id="logo">
				<a href="bs.do?cmd=index"><img alt="" src="images/main/logo.png"></a>
			</div>
			<div>
				<input type="text" name="search">
				<input type="submit" value="검색" class="submit" onClick="">
			</div>
		</div>
		<br><br>
		
		<nav id="index_menu">
			<ul>
				<li><a href="bs.do?cmd=menu&kind=1">베스트도서</a></li>
				<li><a href="bs.do?cmd=menu&kind=2">신간도서</a></li>
				<li><a href="bs.do?cmd=menu&kind=3">국내도서</a></li>
				<li><a href="bs.do?cmd=menu&kind=4">외국도서</a></li>
			</ul>
		</nav>
	
	</header>





<!-- </div> -->