<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>

<article>
	<h2>Cart List</h2>
	<form method="post" name="form">
		<c:choose>
			<c:when test="${clist.size() == 0 }">
				<h3 style="color:red; text-align:center;">Cart empty</h3>
			</c:when>
			<c:otherwise>
				<table id="cartList">
					<tr>
						<th>상품명</th>
						<th>수량</th>
						<th>가격</th>
						<th>주문일</th>
						<th>삭제</th>
					</tr>
					<c:forEach items="${clist}" var="wc">
						<tr>
							<td>
								<a href="wm.do?cmd=wpDetail&pseq=${wc.pseq }" target="_blank">
								<h3>${wc.pname}</h3></a>
							</td>
							<td>	${wc.quantity }</td>
							<td><fmt:formatNumber value="${wc.price_s * wc.quantity }" type="currency" /></td>
							<td><fmt:formatDate value="${wc.indate }" type="date" /></td>
							<td><input type="checkbox" name="cseq" value="${wc.cseq }"></td>
						</tr>
					</c:forEach>
					<tr>
						<th colspan="2">TotalPrice</th>
						<th colspan="2">
							<fmt:formatNumber value="${totalPrice}" type="currency" />
						</th>
						<th>
							<a href="#" onClick="wc_delete();"><h3>Delete cart</h3></a>
						</th>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
		<div id="buttons" style="float:right;">
			<input type="button" value="to main" class="cancel" onClick="location.href='wm.do?cmd=index'">
			<c:if test="${clist.size() != 0 }">
				<input type="button" value="to order" class="submit" onClick="woInsert();">
			</c:if>
		</div>
	</form>
</article>

<%@ include file="../footer.jsp"%>