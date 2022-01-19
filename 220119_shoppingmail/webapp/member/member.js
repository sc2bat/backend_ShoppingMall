
function loginCheck(){
	if(document.loginFrm.id.value == ""){
		alert("아이디는 필수 입력사항입니다");
		document.loginFrm.id.focus();
		return false;
	}
	if(document.loginFrm.pwd.value == ""){
		alert("비밀번호는 필수 입력사항입니다");
		document.loginFrm.pwd.focus();
		return false;
	}
	return true;
}

function go_next(){
	// 자바스크립트에서 jsp 페이지 내의 radio 버튼을 바라볼때, 같은 name의 okin 인 것이 여러개라면
	// name 값에 의한 배열로 인식되어 사용됩니다.
	// 동의함버튼 : okon[0], 동의안함 버튼 : okon[1]
	
	if(document.contractFrm.okon[1].checked == true){
		// 동의 안함 버튼이 선택된 상태
		alert("약관 동의해주세요");
	}else{
		// contractFrm 폼에 action도 없고 submit도 없는 것을 스크립트 명령으로 설정하고 submit 까지 실행합니다
		document.contractFrm.action = "shop.do?command=joinForm";
		document.contractFrm.submit();
	}
}

function idCheck(){
	if(document.joinForm.id.value==""){
		alert("아이디 입력해주세요");
		document.joinForm.id.focus();
		return;
	}
	var url = "shop.do?command=idCheckForm&id="+document.joinForm.id.value;
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250";
	window.open(url, "IdCheck", opt);
}

function idok(userid){
	opener.joinForm.id.value = userid;
	opener.joinForm.reid.value = userid;
	self.close();
}

function post_zip(){
	var url = "shop.do?command=findZipNum";
	var opt = "toolbar=no, menubar=no, resizable=no, width=550";
	opt = opt + "height=300, top=300, left=300";
	window.open(url, "우편번호 찾기", opt);
}

function result(zip_num, sido, gugun, dong){
	opener.document.joinForm.zip_num.value=zip_num;
	opener.document.joinForm.addr1.value = sido + " " + gugun + " " + dong;
	self.close();
}

function go_save(){
	if(document.joinForm.id.value == ""){
		alert("아이디를 입력해주세요");
		document.joinForm.id.focus();
	}else if(document.joinForm.reid.value != document.joinForm.id.value){
		alert("아이디 중복체크해주세요");
		document.joinForm.id.focus();
	}else if(document.joinForm.pwd.value == ""){
		alert("비밀번호를 입력해주세요");
		document.joinForm.pwd.focus();
	}else if(document.joinForm.pwd.value != document.joinForm.pwdCheck.value){
		alert("비밀번호 확인과 비밀번호가 다름");
		document.joinForm.pwdCheck.focus();
	}else if(document.joinForm.name.value == ""){
		alert("이름 입력해주세요");
		document.joinForm.name.focus();
	}else if(document.joinForm.email.value == ""){
		alert("이메일 입력해주세요");
		document.joinForm.email.focus();
	}else{
		document.joinForm.action = "shop.do";
		document.joinForm.submit();
	}
}