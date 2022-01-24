<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>resetPwComplete</title>
<link rel="stylesheet" href="css/shopping.css">
<script type="text/javascript">
	function move_login(){
		opener.location.href="shop.do?command=loginForm";
		self.close();
	}
</script>
</head>
<body>
<h2>비밀번호 재설정 완료</h2>
<table align="center" bgcolor="black" cellspacing="1" width="400">
	<tr align="center" bgcolor="#FDE88F" height="200">
		<td>
			<h3>비밀번호 재설정이 완료되었습니다</h3> <br>
			<input type="button" value="로그인페이지로" onClick="move_login();">
		</td>
	</tr>
</table>
</body>
</html>