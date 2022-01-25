package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//		session.invalidate(); // session 모든 정보를 지우지 않고 관리자에게 영향이 있을 수 있기에 일반사용자만
		session.removeAttribute("loginUser");
		
		RequestDispatcher dp = request.getRequestDispatcher("shop.do?command=index");
		dp.forward(request, response);
	}

}
