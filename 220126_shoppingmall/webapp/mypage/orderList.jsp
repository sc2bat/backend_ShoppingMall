<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>

<article>
	<form action="">
		<h2>Order List</h2>
		<table id="cartList">
<!-- 방금 주문한 주문 목록만 보여주고, 같은 화면이 다시 나타나지 않습니다. 이후 해당내용은 주문내역에서 다른 주문과 함께 볼 수 있습니다. -->
			<tr>
				<th>상품명</th>
				<th>수 량</th>
				<th>가 격</th>
				<th>주문일</th>
				<th>진행상태</th>
			</tr>
			<c:forEach items="${orderList }" var="orderVO">
				<tr>
					<td>
						<a href="shop.do?command=productDetail&pseq=${oderVO.pseq }">
							<h3>${orderVO.pname }</h3></a>
					</td>
					<td>${orderVO.quantity }</td>
					<td><fmt:formatNumber value="${orderVO.price2 * orderVO.quantity }" type="currency" /></td>
					<td><fmt:formatDate value="${orderVO.indate}" type="date" /></td>
					<td>처리 진행 중</td>
				</tr>
			</c:forEach>
			<tr>
				<th colspan="2">총 액</th>
				<th colspan="2"><fmt:formatNumber value="${totalPrice }" type="currency"/></th>
				<th>주문 처리가 완료되었습니다.</th>
			</tr>
		</table>
	</form>
</article>

<%@ include file="../footer.jsp"%>
