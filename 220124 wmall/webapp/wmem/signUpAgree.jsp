<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="sub_img.html"%>
<%@ include file="sub_menu.html"%>

<article>
	<h2>signUp agreement</h2>
	<form id="agree" method="post" name="agreeFrm">
		2021년 12월 29일 오후 9시에 새 공식 로고가 공개되었다. <br>
		데뷔와 함께 공식 로고를 공개하고 해당 로고를 컨셉에 맞춰 다양한 바리에이션으로 활용하는 일반적인 아이돌
		 그룹과 달리, 무려 4년간 공식 로고 없이 매 앨범마다 새로운 로고를 사용해 왔다.
		 <br><br>
		 
		 <textarea cols="100" rows="15">
		 	fromis_9의 멤버는 2017년 7월 13일부터 9월 29일까지 약 2달간 엠넷이 기획한 국내 최초 걸그룹 전문 교육기관을 표방한 
		 	프로젝트이자 서바이벌 오디션 방송 프로그램인 아이돌학교에서 육성회원의 투표를 통해 9명이 선정되었다.
		 	1997년생 3명, 1998년생 2명, 2000년생 3명, 2003년생 1명. 멤버들 생일이 골고루 있는 편이다. 이새롬과 이서연을 빼고는 달이 겹치지 않는다. 
		 	이걸 두고 노지선은 ''겨울의 시작부터 꽃샘추위까지 골고루 즐길 수 있습니다!"라고 했다. 출신지도 서울특별시, 부산광역시, 광주광역시, 
		 	강원도, 전라도, 경상도까지 다양한 편이다. 모든 멤버가 본명을 사용한다. 다만 방송에서는 성을 떼고 이름만 부르는 경우가 많다.
		 </textarea>
		 <br><br>
		 
		 <div style="text-align: center;">
		 	<input type="radio" name="agree">agree &nbsp;&nbsp;&nbsp;
		 	<input type="radio" name="agree" checked>disagree
		 </div>
		 
		 <input type="button" value="Next" class="submit" onClick="signAgree();" style="float:right;">
	</form>
</article>

<%@ include file="../footer.jsp"%>