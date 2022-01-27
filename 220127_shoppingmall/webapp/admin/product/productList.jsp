<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/admin/header.jsp"%>
<%@ include file="/admin/sub_menu.jsp"%>

<article>
	<h1>상품 리스트</h1>
	<form name="frm" method="post">
		<table>
			<tr>
				<td width="642">
					상품명
					<input type="text" name="key" value="${key }">
<!-- 					<input type="button" class="btn" name="btn_search" value="검색" onClick="go_search();"> -->
					<input type="button" class="btn" name="btn_search" value="검색" onClick="go_search('adminProductList');">
					<input type="button" class="btn" name="btn_total" value="전체보기" onClick="go_total('adminProductList');">
					<input type="button" class="btn" name="btn_write" value="상품등록" onClick="go_wrt();">
				</td>
			</tr>
		</table>
	</form>
	<table id="productList">
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>원가</th>
			<th>판매가</th>
			<th>등록일</th>
			<th>사용유무</th>
		</tr>
		<c:forEach items="${productList }" var="productVO">
			<tr>
				<td height="23" align="center">${productVO.pseq }</td>
				<td style="text-align:left; padding-left:50px;">
					<a href="#" onClick="go_detail('${productVO.pseq}')">${productVO.name }</a>
				</td>
				<td><fmt:formatNumber value="${productVO.price1 }"/></td>
				<td><fmt:formatNumber value="${productVO.price2 }"/></td>
				<td><fmt:formatDate value="${productVO.indate }" type="date"/></td>
				<td>
					<c:choose>
						<c:when test="${productVO.useyn == 'n' }">미사용</c:when>
						<c:otherwise>사용</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br> <br>

<!-- 	<div id="paging" align="center" style="font-size:110%; font-weight:bold;"> -->
<%-- 		<c:url var="action" value="shop.do?command=adminProductList"/> --%>
<%-- 		<c:if test="${paging.prev }"> --%>
<%-- 			<a href="${action }&page=${paging.beginPage-1}">◀</a>&nbsp; --%>
<%-- 		</c:if> --%>
<%-- 		<c:forEach begin="${paging.beginPage }" end="${paging.endPage }" var="index"> --%>
<%-- 			<c:choose> --%>
<%-- 				<c:when test="${paging.page == index }"> --%>
<%-- 					<span style="color:red;">${index }&nbsp;</span> --%>
<%-- 				</c:when> --%>
<%-- 				<c:otherwise> --%>
<%-- 					<a href="${action }&page=${index}&key=${key}">${index }</a>&nbsp; --%>
<%-- 				</c:otherwise> --%>
<%-- 			</c:choose> --%>
<%-- 		</c:forEach> --%>
<%-- 		<c:if test="${paging.next }"> --%>
<%-- 			<a href="${action }&page=${paging.endPage+1}">▶</a> --%>
<%-- 		</c:if> --%>
<!-- 	</div> -->

<%-- 	 <jsp:include page="/admin/paging/paging.jsp"></jsp:include> --%>
	<!-- 전달되는 파라미터로 command 값을 조정 -->
	 <jsp:include page="/admin/paging/paging.jsp">
	 	<jsp:param name="command" value="shop.do?command=adminProductList" />
	 </jsp:include>
<%-- 	 	<jsp:param name="page" value="${paging.page}" /> --%>
<%-- 	 	<jsp:param name="beginPage" value="${paging.beginPage}" /> --%>
<%-- 	 	<jsp:param name="endPage" value="${paging.endPage}" /> --%>
<%-- 	 	<jsp:param name="prev" value="${paging.prev}" /> --%>
<%-- 	 	<jsp:param name="next" value="${paging.next}" /> --%>
	 <!-- include 로 paging.jsp 를 불러오면서 그 페이지 안에 command 값을 파라미터로 전송해줍니다 -->
	 <br> <br>
</article>

<%@ include file="/admin/footer.jsp"%>







