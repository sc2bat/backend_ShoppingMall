package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.dao.MemberDao;
import com.ezenac.dto.MemberVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		 MemberDao mdao = MemberDao.getInstance();
		 MemberVO mvo = mdao.getMember(id);
		
		if(mvo == null) {
			request.setAttribute("message", "아이디가 없음");
		}/*else if( !mvo.getUseyn().equals("y")) {
			request.setAttribute("message", "탈퇴한 회원입니다");
		}*/else if(mvo.getPwd() == null) {
			request.setAttribute("message", "회원정보 오류 관리자에게 문의");
		}else if( !mvo.getPwd().equals(pwd)) {
			request.setAttribute("message", "비밀번호가 다름");
		}else if( mvo.getPwd().equals(pwd) && !mvo.getUseyn().equals("y")) {
			request.setAttribute("message", "탈퇴하거나 휴면계정입니다 고객센터에 문의");
		}else if( mvo.getPwd().equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			url = "shop.do?command=index";
		}else {
			request.setAttribute("message", "로그인 실패 관리자에게 문의");
		}
		
		RequestDispatcher dp = request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
