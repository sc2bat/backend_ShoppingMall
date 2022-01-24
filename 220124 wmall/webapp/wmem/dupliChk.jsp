<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dupliChk</title>
<link rel="stylesheet" href="css/watch.css">
<script src="wmem/wMem.js"></script>
</head>
<body>
<h1>Check ID Duplicate</h1>
<form action="wm.do" method="post" name="dupliFrm">
	<input type="hidden" name="cmd" value="dupliChkF">
	User ID : <input type="text" name="dupli_id" value="${chkid }">
					<input type="submit" value="check" class="submit"> <br> <br> <br>
	<div>
		<c:if test="${result == 1 }">
			<script type="text/javascript">opener.document.upForm.su_id.value="";</script>
			${id } was used
		</c:if>
		<c:if test="${result == -1 }">
			${id } can use
			<input type="button" value="confirm" class="cancel" onClick="idOk('${chkid}');"> 
		</c:if>
	</div>
</form>
</body>
</html>