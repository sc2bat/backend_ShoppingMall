<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NZIP</title>
<link rel="stylesheet" href="css/book.css">
<script src="member/member.js"></script>
</head>
<body>
<div id="popup">
	<h1>우편번호검색</h1>
	<form method="post" name="formm" action="bs.do">
		<input type="hidden" name="cmd" value="findZipNum">
		동 이름 : <input name="dong" type="text">
		<input type="submit" value="찾기" class="submit">
	</form>
	
	<table id="zipcode">
		<tr><th width="100">우편번호</th><th>주소</th></tr>
		<c:forEach items="${addressList}" var="addressVO">
			<tr>
				<td>${addressVO.zip_num}</td>
				<td><a href="#" onClick="result('${addressVO.zip_num}', '${addressVO.sido}', '${addressVO.gugun}', '${addressVO.dong}');">
				${addressVO.zip_num} ${addressVO.sido} ${addressVO.gugun} ${addressVO.dong}</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>