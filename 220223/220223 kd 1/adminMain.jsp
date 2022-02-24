<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="adminHeader.jsp" %>

<div id="adminBox">
	<h2>dash board</h2>
	<div class="mainNotice">
		<label>공지사항<a href="bs.do?cmd=adminNoticeList">Edit</a></label>
		<table style="width:100%;">
			<tr>
				<th>No.</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
			</tr>
			<c:forEach items="${mainNoticeList }" var="nvo">
				<tr>
					<td style="text-align:center;">${nvo.nseq }</td>
					<td><a href="bs.do?cmd=adminNoticeDetail&nseq=${nvo.nseq }">${nvo.subject}</a></td>
					<td style="text-align:center;">${nvo.id }</td>
					<td style="text-align:right;"><fmt:formatDate value="${nvo.indate }" type="date"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="mainTotal">
		<label>회원수<a href="bs.do?cmd=adminMemberList&sub=y">Edit</a></label>
		<span>${cnt.get(0)}</span>
	</div>
	<div class="mainTotal">
		<label>상품수<a href="bs.do?cmd=adminProductList&sub=y">Edit</a></label>
		<span>${cnt.get(1)}</span>
	</div>
	<div class="mainTotal">
		<label>미처리 주문수<a href="bs.do?cmd=adminOrderList&kind=1&sub=y">Edit</a></label>
		<span>${cnt.get(2)}</span>
	</div>
	<div class="mainTotal">
		<label>미처리 QnA<a href="bs.do?cmd=adminQnaList">Edit</a></label>
		<span>${cnt.get(3)}</span>
	</div>
</div>

<%@ include file="adminFooter.jsp" %>

