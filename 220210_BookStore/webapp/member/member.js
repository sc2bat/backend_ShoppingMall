function go_next(){
	var chk = document.contractFrm.okon.checked;
	if(!chk)  {
		alert("회원 약관에 동의하셔야 회원가입이 가능합니다.");
  	}else {
    	document.contractFrm.action = "bs.do?cmd=joinForm";
		document.contractFrm.submit();
  	}
}


function idcheck(){
	if(document.joinForm.id.value==""){
		alert("아이디를 입력하세요");
		document.joinForm.id.focus();
		return;
	}
	var url = "bs.do?cmd=idCheckForm&id=" + document.joinForm.id.value;
	var opt = "toolbar=no, menubar=no, resizable=no, width=500, height=250, scrollbars=no";
	window.open(url, "IdCheck", opt);
}

function idok(userid){
	opener.joinForm.id.value = userid;
	opener.joinForm.reid.value = userid;
	self.close();
}


function post_zip(){
	var url = "bs.do?cmd=findZipNum";
	var opt = "toolbar=no, menubar=no, resizable=no, width=550, height=300, top=300, left=300, scrollbars=no";
	window.open(url, "우편번호 찾기", opt);
}