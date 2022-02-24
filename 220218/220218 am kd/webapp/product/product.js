
function toDetail(bseq){
	window.location.href = "bs.do?cmd=productDetail&bseq=" + bseq;
}

function writeReview(){
	document.pdfrm2.action = "bs.do?cmd=writeReview";
	document.pdfrm2.submit();
	
}