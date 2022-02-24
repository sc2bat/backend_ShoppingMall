/**
 * 
 */

/* admin login */
function adminCheck(){
	  if(document.frm.adminId.value==""){
	      	alert("아이디를 입력하세요.");
	      	document.frm.adminId.focus();
	      	return false;
	  }else if(document.frm.adminPwd.value==""){
	     	alert("비밀번호를 입력하세요.");
	      	document.frm.adminPwd.focus();
	      	return false;
	  }
	  return true;  
}


/* admin side bar action */
$(function(){
	$(".sideList").click(function(){
		var num = $(this).index(".sideList");
		$(".sideList").css({"height":"50px"});
		$(".sideList ul").css({"height":"1px","visibility":"hidden"});
		$(".sideList .listbutton").css({"transform":"rotate(0deg)"});
		$(".sideList").eq(num).css({"height":"200px"});
		$(".sideList ul").eq(num).css({"height":"130px","visibility":"visible"});
		$(".sideList .listbutton").eq(num).css({"transform":"rotate(90deg)"});
	});
});
	
	
/* admin product productList 220221 */
function go_productList(){	
	location.href = "bs.do?cmd=adminProductList";
}

function go_ListTotal(cmd){
	document.form.key.value = "";
	document.form.action = "bs.do?cmd=" + cmd + "&sub=y";
	document.form.submit();
}

function go_prodcutListDetail(bseq){
	location.href = "bs.do?cmd=adminProductDetail&bseq=" + bseq;
}

function go_update_product(bseq){
	location.href = "bs.do?cmd=adminProductUpdateForm&bseq=" + bseq;
}

function go_update(){
	if(document.form.bname.value == ""){
		alert("제목 미입력");
		document.form.bname.focus();
	}else if(document.form.writer.value == ""){
		alert("작가 미입력");
		document.form.writer.focus();
	}else if(document.form.byear.value == ""){
		alert("출판년도 미입력");
		document.form.byear.focus();
	}else if(document.form.price.value == ""){
		alert("가격 미입력");
		document.form.price.focus();
	}else if(document.form.publisher.value == ""){
		alert("출판사 미입력");
		document.form.publisher.focus();
	}else if(document.form.genre_radio.value == ""){
		alert("장르 미선택");
		document.form.genre_radio.focus();
	}else if(document.form.content.value == ""){
		alert("내용 미입력");
		document.form.content.focus();
	}else{
		if(confirm("수정하시겠습니까?")){
			document.form.action = "bs.do?cmd=adminProductUpdate";
			document.form.submit();
		}
	}
}

function go_productUploadForm(){
	location.href = "bs.do?cmd=adminProductUploadForm";
}

function go_productUpload(){
	if(document.form.bname.value == ""){
		alert("제목 미입력");
		document.form.bname.focus();
	}else if(document.form.writer.value == ""){
		alert("작가 미입력");
		document.form.writer.focus();
	}else if(document.form.byear.value == ""){
		alert("출판년도 미입력");
		document.form.byear.focus();
	}else if(document.form.price.value == ""){
		alert("가격 미입력");
		document.form.price.focus();
	}else if(document.form.publisher.value == ""){
		alert("출판사 미입력");
		document.form.publisher.focus();
	}else if(document.form.content.value == ""){
		alert("내용 미입력");
		document.form.content.focus();
	}else if(document.form.image.value == ""){
		alert("표지 미선택");
		document.form.image.focus();
	}else{
		if(confirm("등록하시겠습니까?")){
			document.form.action = "bs.do?cmd=adminProductUpload";
			document.form.submit();
		}
	}
}

function go_delete_product(bseq){
	location.href = "bs.do?cmd=adminProductDelete&bseq=" + bseq;
}

/* 220222 admin member */

function go_member_update(id){
	if(document.form.name.value == ""){
		alert("이름 미입력");
		document.form.name.focus();
	}else if(document.form.pwd.value == ""){
		alert("비밀번호 미입력");
		document.form.pwd.focus();
	}else if(document.form.pwd.value != document.form.pwd_re.value){
		alert("비밀번호가 다름");
		document.form.pwd_re.focus();
	}else if(document.form.email.value == ""){
		alert("이메일 미입력");
		document.form.email.focus();
	}else if(document.form.phone.value == ""){
		alert("전화번호 미입력");
		document.form.phone.focus();
	}else if(document.form.zip_num.value == ""){
		alert("지번 미입력");
		document.form.zip_num.focus();
	}else if(document.form.address.value == ""){
		alert("주소 미입력");
		document.form.address.focus();
	}else{
		if(confirm("수정하시겠습니까?")){
			document.form.action = "bs.do?cmd=adminMemberUpdate&id=" + id;
			document.form.submit();
		}
	}
}

function go_member_useyn(id){
	location.href = "bs.do?cmd=adminMemberUpdateUseyn&id=" + id;
}

function go_product_bestyn(bseq){
	location.href = "bs.do?cmd=adminProductUpdateBestyn&bseq=" + bseq;
}



















