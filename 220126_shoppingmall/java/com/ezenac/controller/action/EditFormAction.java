package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dto.MemberVO;

public class EditFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		String addr = mvo.getAddress();
		
		// addr 값
		if(addr != null) {
			// 주소형식 : 서울시 마포구 대현동 번지 및 나머지 주소
			int k1 = addr.indexOf(" "); // 첫번째 공백의 위치를 찾음
			int k2 = addr.indexOf(" ", k1 +1); // 첫번째 공백 위치의 다음위치부터 두번째 공백 위치를 찾음
			int k3 = addr.indexOf(" ", k2 +1); // 두번째 공백위치 다음 위치부터 세번째 공백 위치 찾음
			
			// 서울시 마포구 대현동 111-15 : 세번째 공백 위치 k3 값 -> 11 (0부터 시작)
			// 맨앞부터 세번째 공백 위치 바로 전까지 주소 앞부분
			String addr1 = addr.substring(0, k3);
			
			// 세번째 공백 뒷글자부터 맨끝까지 주소 뒷부분
			String addr2 = addr.substring(k3+1);
			
			request.setAttribute("addr1", addr1);
			request.setAttribute("addr2", addr2);
			
		}
		
		RequestDispatcher dp = request.getRequestDispatcher("member/updateForm.jsp");
		dp.forward(request, response);
	}

}
