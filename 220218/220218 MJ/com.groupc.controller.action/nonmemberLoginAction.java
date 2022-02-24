package com.groupc.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupc.dao.NonMemberDao;
import com.groupc.dto.NonMemberVO;

public class nonmemberLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="member/login.jsp";
		String phone = request.getParameter("phone");
		String od_pass = request.getParameter("od_pass");
		
		NonMemberDao nmdao = NonMemberDao.getInstance();
	    NonMemberVO nmvo = nmdao.getNonMember(phone);
		
		/* */
		if( nmvo == null ) {
	    	request.setAttribute("message", "전화번호가 없음");
	    } else if( nmvo.getPhone() == null ) {
	    	request.setAttribute("message", "비회원정보 오류. 관리자에게 문의하세요");
	    } else if( !nmvo.getOd_pass().equals(od_pass) ) {
	    	request.setAttribute("message", "주문번호가 다름");
	    } else if( nmvo.getOd_pass().equals(od_pass) ) {
	    	request.setAttribute("od_pass", nmvo.getOd_pass());
	    	url="bs.do?cmd=nOrderList";
	    } else {
	    	request.setAttribute("message", "로그인이 실패했어요. 관리자에게 문의하세요");
	    }
	   
	    
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);
	}

}
