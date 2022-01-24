
function add_cart(){
	if(document.pdFrm.quantity.value == ""){
		alert("pdFrm quantity none");
		document.pdFrm.quantity.focus();
	}else{
		document.pdFrm.action = "wm.do?cmd=addCart";
		document.pdFrm.submit();
	}
}

function buy_now(){
	document.pdFrm.action = "wm.do?cmd=buyNow";
	document.pdFrm.submit();
}