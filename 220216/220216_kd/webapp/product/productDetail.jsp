<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../header.jsp"%>
<%@ include file="product_left.jsp"%>


<br><br><br>
<div id="product_Area">
	<div style="height:20px;"></div>
	<div style="width: 700px;"></div>
		<form class="detailbox" name="pdfrm1">
			<input type="hidden" value="${productVO.bseq }">
			<div class="pdLeft">
				<img alt="" src="images/book/${productVO.image }">
			</div>
			<div class="pdRight">
				<div class="pdRightList" style="font-size:140%; font-weight:bold;">${productVO.bname }</div>
				<div class="pdRightList"style="font-size:90%; color:gray;">
					<div>저자 : ${productVO.writer}</div>
					<div>&nbsp;|&nbsp;</div>
					<div>출판사 : ${productVO.publisher }</div>
				</div>
				<div class="pdRightList" style="font-size:90%; color:gray;">
					<fmt:formatDate value="${productVO.indate }" type="date"/></div>
				<div class="pdRightList" style="font-size:120%; color:red; font-weight:bold;">
					<fmt:formatNumber value="${productVO.price }" type="currency"/></div>
				<div class="pdRightList" style="font-size:90%; color:gray;">적립금 : price * 0.05</div>
				<div class="pdRightList" style="font-size:90%; color:gray;">평점 평균 | 리뷰수</div>
			</div>
		</form>
		<div class="pdbott">
			<ol>
				<li id="pd1">
					<a href="#pd1">이책의 분류</a>
					<a href="#pd2" style="background-color:white; color: green;">도서 정보</a>
					<a href="#pd3" style="background-color:white; color: green;">독자 서평</a></li>
				<li>
					<div class="pdcontent">문학</div>
				</li>
				<li id="pd2">
					<a href="#pd1" style="background-color:white; color: green;">이책의 분류</a>
					<a href="#pd2">도서 정보</a>
					<a href="#pd3" style="background-color:white; color: green;">독자 서평</a></li>
				<li>
				<li>
					<div class="pdcontent" style="padding-right:20px;">
						나무위키는 파라과이 Umanle S.R.L.가 운영하는 위키 웹사이트이다. 리그베다 위키의 2015년 4월 11일자 
						데이터베이스를 기반으로 같은 해 4월 17일 시작되었다.
					</div>
				</li>
				<li id="pd3">
					<a href="#pd1" style="background-color:white; color: green;">이책의 분류</a>
					<a href="#pd2" style="background-color:white; color: green;">도서 정보</a>
					<a href="#pd3">독자 서평</a></li>
				<li>
				<li>
					<form name="pdfrm2" style="padding:60px 0px 0 20px;">
						<div>독자서평 쓰기</div>
						<c:choose>
							<c:when test="${empty loginUser}">
								<br>
								<p>로그인을 하시면 독자서평을 작성할 수 있습니다</p>
								<a href="bs.do?cmd=loginForm" class="pdto_login">로그인하기</a>
								<br><br><br>
							</c:when>
							<c:otherwise>
								<br>
								<div>도서평점</div>
								<div id="radio_score">
									<input type="radio" value="1" name="radio_review">
									<div class="starimg"></div>
									<input type="radio" value="2" name="radio_review">
									<div class="starimg"></div>
									<div class="starimg"></div>
									<input type="radio" value="3" name="radio_review">
									<div class="starimg"></div>
									<div class="starimg"></div>
									<div class="starimg"></div>
									<input type="radio" value="4" name="radio_review">
									<div class="starimg"></div>
									<div class="starimg"></div>
									<div class="starimg"></div>
									<div class="starimg"></div>
									<input type="radio" value="5" name="radio_review">
									<div class="starimg"></div>
									<div class="starimg"></div>
									<div class="starimg"></div>
									<div class="starimg"></div>
									<div class="starimg"></div>
								</div>
								<br>
								<div>
									내용
									<br>
									<textarea id="review_content" onClick="review_loginCheck()" name="review_content" cols="70" rows="6"
									placeholder="로그인을 하시면 독자서평을 작성할 수 있습니다"></textarea>
									<a href="#" onClick="writeReview()" class="pd_review_btn">등록하기</a>
								</div>
							</c:otherwise>
						</c:choose>
					</form>
					<br>
					<br>
					<c:forEach items="${reviewList }" var="rvo" varStatus="stat">
						<div id="reviewbox" style="border: 0.5px dashed gray;">
							<ul>
								<li>${rvo.id }</li>
								<li>&nbsp;|&nbsp;</li>
								<li style="padding-top:2px;">
									<c:choose>
										<c:when test="${rvo.score == 1}">
											<div class="starimg"></div></c:when>
										<c:when test="${rvo.score == 2}">
											<div class="starimg"></div>
											<div class="starimg"></div></c:when>
										<c:when test="${rvo.score == 3}">
											<div class="starimg"></div>
											<div class="starimg"></div>
											<div class="starimg"></div></c:when>
										<c:when test="${rvo.score == 4}">
											<div class="starimg"></div>
											<div class="starimg"></div>
											<div class="starimg"></div>
											<div class="starimg"></div></c:when>
										<c:when test="${rvo.score == 5}">
											<div class="starimg"></div>
											<div class="starimg"></div>
											<div class="starimg"></div>
											<div class="starimg"></div>
											<div class="starimg"></div></c:when>
									</c:choose>
								</li>
								<li>&nbsp;|&nbsp;</li>
								<li style="margin-right:60px;">${rvo.rindate }</li>
							</ul>
							<textarea cols="50" rows="4" readonly>${rvo.rcontent }</textarea>
						</div>
					</c:forEach>
				</li>
			</ol>
		</div>
</div>


<%@ include file="../footer.jsp"%>