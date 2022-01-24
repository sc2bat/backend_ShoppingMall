<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html"%>

<article>
	<h1>Login</h1>
	<form method="post" action="wm.do" name="loginFrm">
	<input type="hidden" name="cmd" value="login">
		<fieldset>
			<legend></legend>
			<label>User ID</label>
			<input name="login_id" type="text"> <br>
			<label>Password</label>
			<input name="login_pwd" type="password"> <br>
		</fieldset>
		<div id="buttons">
			<input type="submit" value="sign in" class="submit" onClick="return loginCheck();">
			<input type="button" value="sign up" class="cancel" onClick="location.href='wm.do?cmd=signUp'">
			<input type="button" value="Find Account" class="submit" onClick="find_id();">
		</div>
		<br> <br>
		<div>&nbsp;&nbsp;&nbsp;${message }</div>
	</form>
</article>

<%@ include file="../footer.jsp"%>