<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>adminLogin</title>
<link rel="stylesheet" href="admin/css/admin.css">
<script type="text/javascript">
	function workerCheck(){
		if(document.frm.workId.value == ""){
			alert("아이디를 입력하세요");
			return false;
		}else if(document.frm.workPwd.value == ""){
			alert("비밀번호를 입력하세요");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<div id="wrap">
	<header>
		<div id="logo">
			<img alt="" src="admin/images/bar_01.gif" style="float:left;">
			<img alt="" src="admin/images/text.gif">
		</div>
	</header>
	<div class="clear"></div>
	<article>
		<div id="loginform">
			<form name="frm" method="post" action="shop.do">
				<input type="hidden" name="command" value="adminLogin">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="workId" size="10"></td>						
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="workPwd" size="10"></td>						
					</tr>
					<tr align="center">
						<td colspan="2">
							<input type="submit" class="btn" value="로그인" onClick="return workerCheck();">
							<br> <br> <h4 style="color:red;">${message }</h4>
						</td>						
					</tr>
				</table>
			</form>
		</div>
	</article>
</div>
</body>
</html>