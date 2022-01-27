
/*
function go_search(){
	if(document.frm.key.value == ""){
		return;
	}
	
	var url = "shop.do?command=adminProductList&page=1";
	// 검색어로 검색한 결과의 1페이지로 이동
	
	document.frm.action = url;
	document.frm.submit();
}
*/

/*
function go_total(){
	document.frm.key.value = "";
	document.frm.action = "shop.do?command=adminProductList&page=1";
	document.frm.submit();
}
*/

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

/*
function go_search_order(){
	if(document.frm.key.value == 0){
		return;
	}
	
	var url = "shop.do?command=adminOrderList&page=1";
	document.frm.action = url;
	document.frm.submit();
}
*/

/*
function go_total_order(){
	document.frm.key.value="";
	document.frm.action = "shop.do?command=adminOrderList&page=1";
	document.frm.submit();
}
*/

function go_search(comm){
	if(document.frm.key.value == 0){
		return;
	}
	
//	alert(comm);
	
	var url = "shop.do?command=" + comm + "&page=1";
	document.frm.action = url;
	document.frm.submit();
}

function go_total(comm){
	document.frm.key.value="";
	document.frm.action = "shop.do?command=" + comm + "&page=1";
	document.frm.submit();
}

function go_order_save(){
	// 현재 화면에 보여지고 있는 주문들의 체크박스가 몇개가 체크되어 있는지 갯수를 count 합니다
	var count = 0;
	
	// 만약 하나라서 배열이 생성되지 않으면 undefined 
	if(document.frm.result.length == undefined){ // 화면에 표시된 체크박스가 하나인 경우
		if(document.frm.result.checked == ture){
			count++;
		}
	}else{ // 화면에 표시된 체크박스가 두개 이상인 경우
		for(var i = 0; i < document.frm.result.length; i++){
			if(document.frm.result[i].checked == true){
				count++;
			}
		}
	}
	
	// count 값이 0 이면, 더 진행하지 않고 orderList.jsp 로 되돌아갑니다
	if(count == 0){
		alert("주문처리할 항목을 선택해주세요");
	// count 값이 1 이상이라면, 현재 폼안에 있는 체크박스 value 값들을 갖고, 
	// 처리완료로 처리하러 command = AdminOrderSave 로 이동하여
	}else{
		document.frm.action = "shop.do?command=adminOrderSave";
		document.frm.submit();
	}	
	
	// 처리하고(주문의 result 값을 '1' -> '2' 로 변경) orderList.jsp 로 되돌아옵니다
}


function go_view(qseq){
	location.href="shop.do?command=adminQnaDetail&qseq=" + qseq;
}


function go_rep(qseq){
	document.frm.action = "shop.do?command=adminQnaRepSave&qseq=" + qseq;
	document.frm.submit();
	
	// 답변 글 등록 & rep 필드를 2로 업데이트
}













