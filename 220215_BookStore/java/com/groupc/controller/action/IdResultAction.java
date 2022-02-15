package com.groupc.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupc.dao.MemberDao;
import com.groupc.dto.MemberVO;

public class IdResultAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/idResult.jsp";
		String name1 = "";
		name1 = request.getParameter("name1");
		String phone = request.getParameter("phone");
		
		String name2 = "";
		name2 = request.getParameter("name2");
		String email = request.getParameter("email");
		
		MemberVO mvo = null;
		if(name2=="") {
			MemberDao mdao = MemberDao.getInstance();
			mvo = mdao.checkMemberId(name1, phone, email);
		}else {
			MemberDao mdao = MemberDao.getInstance();
			mvo = mdao.checkMemberId(name2, phone, email);
		}
		
		
		if(mvo==null) {
			url = "member/findId.jsp";
			request.setAttribute("message", "입력하신 정보와 일치하는 회원이 없습니다.");
		}
		
		request.setAttribute("MemberVO", mvo);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
