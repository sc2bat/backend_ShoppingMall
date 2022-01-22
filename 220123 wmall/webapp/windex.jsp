<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<div id="main_img">
	<img alt="" src="img/main.jpg" style="border-radius:20px 20px 20px 20px; border:2px solid white;">
</div>

<h2>New Item</h2>
<div id="bestWatch">
	<c:forEach items="${wnlist }" var="wpVO">
		<div id="item">
			<a href="wm.do?cmd=wpDetail=${wpVO.pseq }">
				<img src="wimages/${wpVO.image }">
				<h3>${wpVO.name } - <fmt:formatNumber value="${wpVO.price_s }" type="currency" /></h3>
			</a>
		</div>
	</c:forEach>
</div>

<div class="clear"></div>

<h2>Best Item</h2>
<div id="bestWatch">
	<c:forEach items="${wblist }" var="wpVO">
		<div id="item">
			<a href="wm.do?cmd=wpDetail=${wpVO.pseq }">
				<img src="wimages/${wpVO.image }">
				<h3>${wpVO.name } - <fmt:formatNumber value="${wpVO.price_s }" type="currency" /></h3>
			</a>
		</div>
	</c:forEach>
</div>

<%@ include file="footer.jsp"%>