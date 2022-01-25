
function go_search(){
	if(document.frm.key.value == ""){
		return;
	}
	
	var url = "shop.do?command=adminProductList&page=1";
	// 검색어로 검색한 결과의 1페이지로 이동
	
	document.frm.action = url;
	document.frm.submit();
}

function go_total(){
	document.frm.key.value = "";
	document.frm.action = "shop.do?command=adminProductList&page=1";
	document.frm.submit();
}

// web inf\lib\cos.jar
function go_wrt(){
	document.frm.action = "shop.do?command=adminProductWriteForm";
	document.frm.submit();
}


function go_save(){
	var theForm = document.frm;
	
	if(theForm.kind.value == ""){
		alert("상품분류를 선택하세요");
		theForm.kind.focus();
	}else if(theForm.name.value == ""){
		alert("상품명을 입력하세요");
		theForm.name.focus();
	}else if(theForm.price1.value == ""){
		alert("원가를 입력하세요");
		theForm.price1.focus();
	}else if(theForm.price2.value == ""){
		alert("판매가를 입력하세요");
		theForm.price2.focus();
	}else if(theForm.content.value == ""){
		alert("상품 상세를 입력하세요");
		theForm.content.focus();
	}else if(theForm.image.value == ""){
		alert("상품이미지를 넣으세요");
		theForm.image.focus();
	}else {
		theForm.action = "shop.do?command=adminProductWrite";
		theForm.submit();
	}
}

function cal(){
	if(document.frm.price2.value == "" || document.frm.price1.value == ""){
		return;
	}
	document.frm.price3.value = document.frm.price2.value - document.frm.price1.value;
}


function go_detail(pseq){
	var url = "shop.do?command=adminProductDetail&pseq=" + pseq;
	document.frm.action = url;
	document.frm.submit();
}

function go_mod(pseq){
	var url = "shop.do?command=adminProductUpdateForm&pseq=" + pseq;
	location.href = url;
//	document.frm.action = url;
//	document.frm.submit();
}

function go_mov(){
	location.href = "shop.do?command=adminProductList";
}

function go_mod_save(){
	var f = document.frm;
	if(f.kind.value == ""){
		alert("상품분류를 선택하세요");
		f.kind.focus();
	}else if(f.name.value == ""){
		alert("상품명을 입력하세요");
		f.name.focus();
	}else if(f.price1.value == ""){
		alert("원가를 입력하세요");
		f.price1.focus();
	}else if(f.price2.value == ""){
		alert("판매가를 입력하세요");
		f.price2.focus();
	}else if(f.content.value == ""){
		alert("상품 상세 내역을 입력하세요");
		f.content.focus();
	}else {
		if(confirm("수정하시겠습니까? ")){
			f.action = "shop.do?command=adminProductUpdate";
			f.submit();
		}
	}
}




























