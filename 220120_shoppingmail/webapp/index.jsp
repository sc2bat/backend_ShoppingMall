<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ include file="header.jsp" %>

<!-- 메인 이미지 시작 -->
<div id="main_img">
	<img style="border-radius:20px 20px 20px 20px; border:2px solid white;" src="images/main_img.jpg">
</div>

<!-- 신상품 -->
<h2>New Item</h2>
<div id="bestProduct">
	<c:forEach items="${newList }" var="productVO">
		<div id="item"> <!-- 상품 한개, 한칸 -->
			<a href="shop.do?command=productDetail&pseq=${productVO.pseq }">
				<img src="product_images/${productVO.image }" /> <!-- 상품 이미지 -->
				<h3>${productVO.name } - <fmt:formatNumber value="${productVO.price2 }" type="currency" /></h3>
			</a>
		</div>
	</c:forEach>
</div>

<div class="clear"></div>

<!-- 베스트 상품 -->
<h2>Best Item</h2>
<div id="bestProduct">
	<c:forEach items="${bestList }" var="productVO">
		<div id="item"> <!-- 상품 한개, 한칸 -->
			<a href="shop.do?command=productDetail&pseq=${productVO.pseq }">
				<img src="product_images/${productVO.image }" /> <!-- 상품 이미지 -->
				<h3>${productVO.name } - <fmt:formatNumber value="${productVO.price2 }" type="currency" /></h3>
			</a>
		</div>
	</c:forEach>
</div>

<%@ include file="footer.jsp" %>