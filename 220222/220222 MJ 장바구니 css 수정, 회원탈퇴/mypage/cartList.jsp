<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@ include file="sub_img.html"%> 
<%@ include file="sub_menu.jsp" %>

<div id="qna">
<article>
<h2>장바구니</h2><hr>
<form name="formm" method="post">
	<c:choose>
		<c:when test="${cartList.size() == 0}">
			<h3 style="color: red;text-align: center;">장바구니가 비었습니다.</h3> 
		</c:when>
		<c:otherwise>
			<table id="cartList">
				<tr><th width="280px" height="50px">상품명</th><th width="70px">수 량</th><th width="120px">가 격</th><th width="140px">주문일</th><th width="70px">삭 제</th></tr>
					<c:forEach items="${cartList}" var="cartVO">
						<tr><td><a href="bs.do?cmd=productDetail&bseq=${cartVO.bseq}" target="_blank" >
							<h3> ${cartVO.bname} </h3></a></td><td> ${cartVO.quantity} </td>
						<td><fmt:formatNumber value="${cartVO.price*cartVO.quantity}"	type="currency"/></td>
						<td><fmt:formatDate value="${cartVO.indate}" type="date" /></td>
						<td><input type="checkbox" name="cseq" value="${cartVO.cseq}"></td></tr>
					</c:forEach>
				<tr><th colspan="2"> 총 액 </th><th colspan="2">
       				<fmt:formatNumber value="${totalPrice}" type="currency" /></th>
       				<th><a href="#" onClick="go_cart_delete();"><h3>삭제하기</h3></a></th></tr> 
			</table>
		</c:otherwise>
	</c:choose>
<hr>
<div class="clear"></div>
<div id="cartbtn2" style="float: right">
    <input type="button" value="쇼핑 계속하기" class="cancel" onclick="location.href='bs.do?cmd=index'">    
    <c:if test= "${cartList.size() != 0}">
   		<input type="button" value="주문하기"  class="submit" onclick="go_order_insert();">
    </c:if>
</div>
</form>
</article>
</div>



<%@ include file="../footer.jsp" %>