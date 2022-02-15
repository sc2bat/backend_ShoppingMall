<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<%@ include file="product_left.jsp"%>


<br><br><br>
<div id="product_Area">
	<div style="width: 700px; height:20px; border-bottom:1px solid black;"></div>
	<c:forEach items="${productViewList}" var="pvo" varStatus="stat">
		<form class="listbox" name="frm">
			<input type="hidden" value="${pvo.bseq }">
			<div class="list_in" style="width:20px; margin-top:90px;">
				<input type="checkbox" id="checkbox">
			</div>
			<div class="list_in" style="width:110px;">
				<img alt="" src="images/book/${pvo.image}">
			</div>
			<div class="list_in" style="width:330px;">
				<div style="font-size:130%; font-weight:bold">${pvo.bname}</div>
				<div>
					<p>${pvo.writer}&nbsp;|&nbsp;${pvo.publisher}&nbsp;|&nbsp;${pvo.byear}</p>
				</div>
				<div style=" overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">
					<span>${pvo.content}</span>
				</div>
				<div>${pvo.price}</div>
				<div>
					<p>score | review cnt</p>
				</div>
			</div>
			<div class="list_in" style="width:130px; padding:20px 0 0 70px;">
				수량
				<input type="text" name="quantity" maxlength="2" value="1">
				개
			</div>
			<div class="list_in" style="width:140px; padding:20px 0 0 60px;">
				<a href="#">상세설명</a>
				<a href="#">장바구니</a>
				<a href="#">바로구매</a>
			</div>
		</form>
	</c:forEach>
</div>


<%@ include file="../footer.jsp"%>