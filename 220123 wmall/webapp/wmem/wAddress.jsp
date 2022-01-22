<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>wAddress</title>
<link rel="stylesheet" href="css/watch.css">
<script src="wmem/wMem.js"></script>
</head>
<body>

<div id="popup">
	<h1>Searching Address</h1>
	<form action="wm.do" method="post" name="afrm">
	<input type="hidden" name="cmd" value="searchZnum">
		동 이름 : <input type="text" name="dong">
					<input type="submit" name="search" class="submit">
	</form>
	<table id="zipcode">
		<tr>
			<th width="100">zip num</th>
			<th>Address</th>
		</tr>
		<c:forEach items="${aList}" var="AVO">
			<tr>
				<td>${AVO.zip_num }</td>
				<td>
					<a href="#" onClick="Addr_result('${AVO.zip_num}', '${AVO.sido}', '${AVO.gugun}', '${AVO.dong}')">
					${AVO.sido} ${AVO.gugun} ${AVO.dong} ${AVO.bunji}</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>