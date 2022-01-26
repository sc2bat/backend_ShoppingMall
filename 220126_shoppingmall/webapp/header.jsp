<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html></html>
<head>
<meta charset="UTF-8">
<title>shop index</title>
<link rel="stylesheet" href="css/shopping.css?after">
<script type="text/javascript" src="member/member.js"></script>
<script type="text/javascript" src="mypage/mypage.js"></script>
</head>
<body>

<div id="wrap">
<header><!-- 로고, 주상단메뉴, 카테고리 메뉴 등이 표시되는 영역 -->
	<div id="logo"><!-- 메인 로고 이미지 -->
		<a href="shop.do?command=index">
			<img src="images/logo.png" width="180" height="100">
		</a>
	</div>
	<nav id="top_menu"><!-- 상단 메뉴 : 로그인 CART MyPage 등 -->
		<ul>
			<c:choose>
				<c:when test="${empty loginUser }">
					<li><a href="shop.do?command=loginForm">Login</a></li>
					<li><a href="shop.do?command=contract">Join</a></li>
				</c:when>
				<c:otherwise>
					<li>${loginUser.name }(${loginUser.id })</li>
<%-- 					<li><a href="shop.do?command=editForm&id=${loginUser.id }">정보수정</a></li> --%>
					<li><a href="shop.do?command=editForm">정보수정</a></li>
					<li><a href="shop.do?command=logout">Logout</a></li>
				</c:otherwise>
			</c:choose>
			<li><a href="shop.do?command=cartList">CART</a></li>
			<li><a href="shop.do?command=myPage">MyPage</a></li>
			<li><a href="shop.do?command=qnaList">Q&amp;A</a></li>
			<li></li>
		</ul>
	</nav>
	
	<nav id="category_menu"><!-- 카테고리 메뉴 Heels Boots Sandals 등 -->
		<ul>
			<li><a href="shop.do?command=category&kind=1">Heels</a></li>
			<li><a href="shop.do?command=category&kind=2">Boots</a></li>
			<li><a href="shop.do?command=category&kind=3">Sandals</a></li>
			<li><a href="shop.do?command=category&kind=4">Sneakers</a></li>
			<li><a href="shop.do?command=category&kind=5">Sleeper</a></li>
			<li><a href="shop.do?command=category&kind=6">On Sale</a></li>
		</ul>
	</nav>
</header>
	





























<!-- 파일이 이어져야 하기 때문에 끝나는 태그 삭제 -->
<!-- </body> -->
<!-- </html> -->