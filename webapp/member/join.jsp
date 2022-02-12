<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<article>
<form method="post" name="joinForm">
	<input type="hidden" name="cmd" value="join">
	<fieldset><legend>Basic Info</legend>
		<label>User ID</label><input type="text" name="id" size="12"><input type="hidden" name="reid">
		<input type="button" value="중복체크" class="dup" onclick="idcheck()"><br>
		<label>Password</label><input type="password" name="pwd"><br>
		<label>Retype Password</label><input type="password" name="pwdCheck"><br>
		<p>* 비밀번호는 최소 8자 이상의 비밀번호를 입력하셔야 합니다.<br/>
		영문(대/소문자), 숫자, 특수기호로 조합하셔야 개인정보 노출 위험이 적습니다.<br/>
		비밀번호 입력란과 비밀번호 확인란의 내용이 같아야 합니다.</p>
		<label>Name</label><input type="text" name="name"><br>
		<label>Gender</label>
			<input type="radio" name="gender" value="1" checked="checked">남자&nbsp;
			<input type="radio" name="gender" value="2">여자<br>
		<label>E-Mail</label><input type="text" name="email"><br>
	</fieldset>
	<fieldset><legend>Optional</legend>
		<label>Zip Code</label><input type="text" name="zip_num" size="10">
		<input type="button" value="주소 찾기" class="dup" onclick="post_zip()"><br>
		<label>Address</label><input type="text" name="addr1" size="50"><br>
		<label>&nbsp;</label><input type="text" name="addr2" size="25"><br>
		<label>Phone Number</label><input type="text" name="phone"><br>
	</fieldset>
	<div class="clear"></div>
	개인정보 수집 및 이용에 대한 안내(선택)
	<input type="radio" name="info" value="1">동의
	<input type="radio" name="info" value="2" checked="checked">미동의
	
	<div id="buttons">
		<input type="button" value="회원가입" class="submit" onclick="go_save()">
		<input type="button" value="취소" onClick="main()">
	</div>
</form></article>

<%@ include file="../footer.jsp" %>