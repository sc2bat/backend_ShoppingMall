
function loginCheck(){
	if(document.loginFrm.login_id.value == ""){
		alert("ID none");
		document.loginFrm.login_id.focus();
		return false;
	}
	if(document.loginFrm.login_pwd.value == ""){
		alert("Password none");
		document.loginFrm.login_pwd.focus();
		return false;
	}
	return true;
}

function signAgree(){
	if(document.agreeFrm.agree[1].checked == true){
		alert("Agreement is disagree");
	}else{
		document.agreeFrm.action = "wm.do?cmd=signUpF";
		document.agreeFrm.submit();
	}
}

function dupli_chk(){
	if(document.upForm.su_id.value == ""){
		alert("su_id is None");
		document.upForm.su_id.focus();
		return;
	}
	var url = "wm.do?cmd=dupliChkF&dupli_id=" + document.upForm.su_id.value;
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250, scrollbars=no";
	window.open(url, "Chk duplicate", opt);
}

function idOk(id){
	opener.upForm.su_id.value = id;
	opener.upForm.su_reid.value = id;
	self.close();
}

function post_zip(){
	var url = "wm.do?cmd=searchZnum";
	var opt = "toolbar=no, menubar=no, resizable=no, width=550, height=300, top=300, left=300, scrollbars=no";
	window.open(url, "Searching znum", opt);	 
}

//아이디입력	중복확인	비번	비번 일치	이름	이메일
function go_save(){
	if(document.upForm.su_id.value == ""){
		alert("save su_id none");
		document.upForm.su_id.focus();
	}else if(document.upForm.su_id.value != document.upForm.su_reid.value){
		alert("save check duplicate id");
		document.upForm.su_id.focus();
	}else if(document.upForm.su_pwd.value == ""){
		alert("save su_pwd none");
		document.upForm.su_pwd.focus();
	}else if(document.upForm.su_pwd.value != document.upForm.su_repwd.value){
		alert("su_pwd != su_repwd");
		document.upForm.su_repwd.focus();
	}else if(document.upForm.su_name.value == ""){
		alert("su_name none");
		document.upForm.su_name.focus();
	}else if(document.upForm.su_email.value == ""){
		alert("su_email none");
		document.upForm.su_email.focus();
	}else{
		document.upForm.action = "wm.do";
		document.upForm.submit();
	}
}

function Addr_result(zip_num, sido, gugun, dong){
	opener.document.upForm.su_znum.value = zip_num;
	opener.document.upForm.addr1.value = sido + " " + gugun + " " + dong;
	self.close();
}
























