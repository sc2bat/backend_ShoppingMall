<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html"%>

<article>
	<h2>Update WM</h2>
	<form method="post" name="upForm">
	<input type="hidden" name="cmd" value="updateM">
		<fieldset>
			<legend>Basic Info</legend>
			<label>User ID</label>
			<input type="text" name="um_id" value="${loginUser.id }" readonly> <br>
			<label>Password</label>
			<input type="password" name="um_pwd"> <br>
			<label>retype Password</label>
			<input type="password" name="um_repwd"> <br>
			<label>Name</label>
			<input type="text" name="um_name" value="${loginUser.name }"> <br>
			<label>Email</label>
			<input type="text" name="um_email" value="${loginUser.email}">
		</fieldset>
		
		<fieldset>
			<legend>Optional</legend>
			<label>Zip code</label>
			<input type="text" name="um_zip_num" size="10" value="${loginUser.zip_num }">
			<input type="button" value="get Address" class="dup" onClick="post_zip();"> <br>
			<label>Address</label>
			<input type="text" name="addr1" size="50" value="${addr1 }"> <br>
			<label>&nbsp;</label>
			<input type="text" name="addr2" size="25" value="${addr2 }"> <br>
			<label>Phone</label>
			<input type="text" name="um_phone" value="${loginUser.phone }"> <br>
		</fieldset>
		<div class="clear"></div>
		<div id="buttons">
			<input type="button" value="update Info" class="submit" onClick="go_update();">
			<input type="reset" value="reset" class="cancel">
		</div>
	</form>
</article>

<%@ include file="../footer.jsp"%>