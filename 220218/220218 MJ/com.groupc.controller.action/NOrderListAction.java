package com.groupc.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupc.dao.OrderDao;
import com.groupc.dto.MemberVO;
import com.groupc.dto.NOrderVO;

public class NOrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "nonmember/nOrderList.jsp";
		
		String od_pass = (String) request.getAttribute("od_pass");
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		
		if(mvo != null) {
			url = "bs.do?cmd=index";
		}else {
			OrderDao odao = OrderDao.getInstance();
			NOrderVO novo = odao.nOrderByOd_Pass(od_pass);
			request.setAttribute("novo", novo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
