<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../adminHeader.jsp" %>

<div id="adminBox" style="width:1100px;">
	<h3>Member OrderList</h3>
	<form name="form" method="post">
		<input type="button" name="button_search" value="전체보기" onClick="go_ListTotal('adminOrderList')">
		<input type="text" name="key" value="${key}" placeholder="주문번호 검색">
		<input type="button" name="button_search" value="검색" onClick=""><br>
		<input type="button" name="button_search" value="'배송 준비'로 바꾸기" onClick="orderChange(2);">
		<input type="button" name="button_search" value="'배송중'으로 바꾸기" onClick="orderChange(3);">
		<input type="button" name="button_search" value="'배송 완료'로 바꾸기" onClick="orderChange(4);">
		<input type="button" name="button_search" value="'주문 취소'로 바꾸기" onClick="orderChange(5);">
	</form>
	
	<form name="frm" method="post">
	<input type="hidden" name="kind" value="${kind}">
	<table id="productList" style="width:1000px;">
		<tr>
			<th>주문번호</th>
			<th>회원 ID</th>
			<th>책</th>
			<th>수량</th>
			<th>총 결제 금액</th>
			<th>주문 날짜</th>
			<th>주문 상태</th>
			<th>주문 선택</th>
		</tr>
	<c:forEach items="${orderList }" var="ovo">
	<c:choose>
			<c:when test="${ovo.result==1 || ovo.result==2 || ovo.result==3}">
			<tr>
				<td style="height:64px">${ovo.odseq}</td>
				<td>${ovo.id}</td>
				<td><a href="bs.do?cmd=adminProductDetail&bseq=${ovo.bseq}">${ovo.bname }</a></td>
				<td>${ovo.quantity }</td>
				<td><fmt:formatNumber value="${ovo.price*ovo.quantity}" type="currency"/></td>
				<td><fmt:formatDate value="${ovo.indate }" type="date"/></td>
				<td>
					<c:if test="${ovo.result==1}">주문 접수</c:if>
					<c:if test="${ovo.result==2}">배송 준비</c:if>
					<c:if test="${ovo.result==3}">배송중</c:if>
				</td>
				<td><input type="checkbox" name="orderCheck" value="${ovo.odseq}"></td>
			</tr>
			
			</c:when>
 	
			<c:otherwise>
			<tr>
				<td style="height:64px">${ovo.odseq}</td>
				<td>${ovo.id}</td>
				<td><a href="bs.do?cmd=adminProductDetail&bseq=${ovo.bseq}">${ovo.bname }</a></td>
				<td>${ovo.quantity }</td>
				<td><fmt:formatNumber value="${ovo.price*ovo.quantity}" type="currency"/></td>
				<td><fmt:formatDate value="${ovo.indate }" type="date"/></td>
				<td>
					<c:if test="${ovo.result==4}">배송 완료</c:if>
					<c:if test="${ovo.result==5}">주문 취소</c:if>
				</td>
				<td><input type="checkbox" name="orderCheck" disabled></td>
			</tr>
			</c:otherwise>
		
		</c:choose>
	</c:forEach>
	</table>
</form>
	<jsp:include page="/admin/paging/admin_paging.jsp">
	 	<jsp:param name="cmd" value="bs.do?cmd=adminOrderList&kind=${kind}" />
	 </jsp:include>
</div>


<%@ include file="../adminFooter.jsp" %>