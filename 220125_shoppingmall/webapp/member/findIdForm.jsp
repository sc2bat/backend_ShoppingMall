<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findIdForm</title>
<link rel="stylesheet" href="css/shopping.css">
</head>
<body>
<center><h2>Id 찾기</h2></center>
<form method="post" name="frm" action="shop.do">
	<input type="hidden" name="command" value="findIdStep1">
	<table align="center" bgcolor="black" cellspacing="1" width="400">
		<tr align="center" bgcolor="#FDE8FF">
			<td width="430">
				<h3>성명<input type="text" name="name" value="${name }"></h3>
			</td>
		</tr>
		<tr align="center" bgcolor="#FDE8FF">
			<td width="430">
				<h3>전화번호<input type="text" name="phone" value="${phone }"></h3>
			</td>
		</tr>
		<tr align="center" bgcolor="#FDE8FF">
			<td width="430">
				<h3><input type="text" value="인증번호전송"></h3>${msg } <br>
				<input type="submit" value="이동">
			</td>
		</tr>
	</table>
</form>
</body>
</html>