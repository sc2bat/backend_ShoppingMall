package com.groupc.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupc.dao.MemberDao;
import com.groupc.dto.MemberVO;

public class PwdResultAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/pwdResult.jsp";
		String id1 = "";
		id1 = request.getParameter("id1");
		String phone = request.getParameter("phone");
		
		String id2 = "";
		id2 = request.getParameter("id2");
		String email = request.getParameter("email");
		
		MemberVO mvo = null;
		if(id2=="") {
			MemberDao mdao = MemberDao.getInstance();
			mvo = mdao.checkMemberPwd(id1, phone, email);
		}else {
			MemberDao mdao = MemberDao.getInstance();
			mvo = mdao.checkMemberPwd(id2, phone, email);
		}
		
		
		if(mvo==null) {
			url = "member/findPwd.jsp";
			request.setAttribute("message", "입력하신 정보와 일치하는 회원이 없습니다.");
		}
		
		request.setAttribute("MemberVO", mvo);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
