function go_order_insert(){
	
	document.formm.action = "bs.do?cmd=orderInsert";
	document.formm.submit();
	
}


function cartyn(bseq){
	var a = confirm("상품을 장바구니에 넣어두시겠습니까?");
	if(a){
		location.href="bs.do?cmd=cartInsert&bseq="+bseq+"&quantity=1";
		return true;
	}else{
		return false;
	}
}


function buyyn(bseq){
	var a = confirm("상품을 바로 구매하시겠습니까?");
	if(a){
/*		var url = "bs.do?cmd=idBuyCheckForm&id="+document.getElementById('checking').value+"&bseq="+bseq+"&quantity=1";*/
		if(document.getElementById('checking').value){
			location.href="bs.do?cmd=cartInsert&bseq="+bseq+"&quantity=1";
			return true;
		}else{
			if(confirm("비회원으로 구매하시겠습니까?")){
				location.href="bs.do?cmd=nmemberBuyForm&bseq="+bseq+"&quantity=1";
			}else{
				alert("로그인 후 이용해주세요.");
				return false;
			}
		}
	}else{
		return false;
	}
}


function cartpyn(bseq){
	var a = confirm("상품을 장바구니에 넣어두시겠습니까?");
	if(a){
		location.href="bs.do?cmd=cartInsert&bseq="+bseq+"&quantity="+document.getElementById('quantity').value;
		return true;
	}else{
		return false;
	}
}


function buypyn(bseq){
	var a = confirm("상품을 바로 구매하시겠습니까?");
	if(a){
		if(document.getElementById('checking').value){
			location.href="bs.do?cmd=orderOne&bseq="+bseq+"&quantity="+document.getElementById('quantity').value;
			return true;
		}else{
			if(confirm("비회원으로 구매하시겠습니까?")){
				location.href="bs.do?cmd=nmemberBuyForm&bseq="+bseq+"&quantity="+document.getElementById('quantity').value;
			}else{
				alert("로그인 후 이용해주세요.");
				return false;
			}
		}
	}else{
		return false;
	}
}




function add_multi(){
	var count = 0;
	var checkbox = document.getElementById('checkbox');

	if(checkbox.length==undefined){
		if(checkbox.checked==true){
			count++;
		}else{
			for(var i=0; i<checkbox.length; i++){
				if(checkbox[i].checked==true){
					count++;
				}
			}
		}
	}
	
	if(count==0){
		alert("장바구니에 추가할 항목을 선택해주세요.");
	}else{
		var a = confirm("선택하신 상품들을 장바구니에 추가하시겠습니까?");
		if(a){
			document.frm.action="bs.do?cmd=cartInsertMulti";
			document.frm.submit();
		}else{
			return false;
		}
	}
}


/*function cartyn(bseq){
	var a = confirm("상품을 장바구니에 넣어두시겠습니까?");
	if(a){
		location.href="bs.do?cmd=cartInsert&bseq="+bseq+"&quantity=1";
		return true;
	}else{
		return false;
	}
}  원본 임시저장*/






/*function buyyn(bseq){
	var a = confirm("상품을 바로 구매하시겠습니까?");
	if(a){
		location.href="bs.do?cmd=orderOne&bseq="+bseq+"&quantity=1";
		return true;
	}else{
		return false;
	}
}*/


/*function buypyn(bseq){
	var a = confirm("상품을 바로 구매하시겠습니까?");
	if(a){
		location.href="bs.do?cmd=orderOne&bseq="+bseq+"&quantity="+document.getElementById('quantity').value;
		return true;
	}else{
		return false;
	}
}*/