<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="sidemenu">
	<h1 style="padding-left:20px;">MyPage</h1>
	<div>쇼핑
		<ul>
			<li><a href="bs.do?cmd=orderList">주문목록</a></li>
			<li><a href="bs.do?cmd=tracking">배송조회</a></li>
			<li><a href="bs.do?cmd=cancelList">취소내역</a></li>
		</ul>
	</div>
	<div>활동
		<ul>
			<li><a href="bs.do?cmd=qnaWriteForm">문의하기</a></li>
			<li><a href="bs.do?cmd=qnaList">문의목록</a></li>
			<li><a href="bs.do?cmd=reviewList">리뷰관리</a></li>
		</ul>
	</div>
	<div>정보
		<ul>
			<li><a href="bs.do?cmd=editForm">정보 수정</a></li>
			<li><a href="#" onClick="confirmOfDelete()">회원 탈퇴</a></li>
		</ul>
	</div>
</div>
