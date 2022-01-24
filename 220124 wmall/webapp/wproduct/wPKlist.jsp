<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.jsp"%>

<article>
	<h2>Product List</h2>
	<c:forEach items="${klist}" var="wpk">
		<div id="item">
			<a href="wm.do?cmd=wpDetail&pseq=${wpk.pseq }">
				<img src="wimages/${wpk.image }">
				<h3>${wpk.name }</h3>
				<p>${wpk.price_s }</p>
			</a>
		</div>
	</c:forEach>
	<div class="clear"></div>
</article>

<%@ include file="../footer.jsp"%>