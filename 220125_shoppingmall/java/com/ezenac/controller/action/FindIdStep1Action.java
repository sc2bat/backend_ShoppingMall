package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenac.dao.MemberDao;
import com.ezenac.dto.MemberVO;

public class FindIdStep1Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="member/findIdForm.jsp";
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMemberByname(name, phone);
		
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		
		if(mvo == null) {
			request.setAttribute("msg", "해당 이름의 회원이 없음");
		}else {
			request.setAttribute("MemberVO", mvo);
			url = "member/findIdconfirmNumber.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
