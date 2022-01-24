<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html"%>

<article>
	<form method="post" name="upForm">
	<input type="hidden" name="cmd" value="signUp">
		<fieldset>
			<legend>Basic Info</legend>
			<label>User ID</label>
				<input type="text" name="su_id" size="12">
				<input type="hidden" name="su_reid">
				<input type="button" value="chk_dupli" class="dup" onClick="dupli_chk();"> <br>
			<label>Password</label>
				<input type="password" name="su_pwd"> <br>
			<label>retype Password</label>
				<input type="password" name="su_repwd"> <br>
			<label>Name</label>
				<input type="text" name="su_name"> <br>
			<label>Email</label>
				<input type="text" name="su_email"> <br>
		</fieldset>
		<fieldset>
			<legend>Optional</legend>
			<label>Zip_Code</label>
				<input type="text" name="su_znum" size="10">
				<input type="button" value="get Address" class="dup" onClick="post_zip()"> <br> 
			<label>Address</label>
				<input type="text" name="addr1" size="50"> <br>
			<label>&nbsp;</label>
				<input type="text" name="addr2" size="25"> <br>
			<label>Phone</label>
				<input type="text" name="su_phone"> <br>
		</fieldset>
		<div class="clear"></div>
		<div id="buttons">
			<input type="button" value="sign Up" class="submit" onClick="go_save();">
			<input type="reset" value="reset" class="cancel">
		</div>
	</form>
</article>

<%@ include file="../footer.jsp"%>