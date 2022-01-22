<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fromis9</title>
<link rel="stylesheet" href="css/watch.css">
<script src="wmem/wMem.js"></script>
<script src="wmypage/wMypage.js"></script>
</head>
<body>
<div id="wrap">
	<header>
		<div id="logo">
			<a href="wm.do?cmd=index">
				<img src="img/logo.png" width="180" height="100" >
			</a>
		</div>
		<nav id="top_menu">
			<ul>
				<c:choose>
					<c:when test="${empty loginUser }">
						<li><a href="wm.do?cmd=loginF">LOGIN</a></li>
						<li><a href="wm.do?cmd=signUpAgree">Sign Up</a></li>
					</c:when>
					<c:otherwise>
						<li>${loginUser.name }(${loginUser.id })</li>
						<li><a href="wm.do?cmd=editF">UPDATE INFO</a></li>
						<li><a href="wm.do?cmd=logout">LOGOUT</a></li>
					</c:otherwise>
				</c:choose>
				<li><a href="wm.do?cmd=wcList">CART</a></li>
				<li><a href="wm.do?cmd=wmMypage">MY PAGE</a></li>
				<li><a href="wm.do?cmd=wqnaList">Q&amp;A</a></li>
			</ul>
		</nav>
		
		<nav id="category_menu">
			<ul>
				<li><a href="wm.do?cmd=category&kind=1">손목시계</a></li>
				<li><a href="wm.do?cmd=category&kind=2">탁상시계</a></li>
				<li><a href="wm.do?cmd=category&kind=3">벽시계</a></li>
				<li><a href="wm.do?cmd=category&kind=4">LED시계</a></li>
				<li><a href="wm.do?cmd=category&kind=5">애플워치</a></li>
				<li><a href="wm.do?cmd=category&kind=6">갤워치</a></li>
			</ul>
		</nav>
	</header>
<!-- </body> -->
<!-- </html> -->