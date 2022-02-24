package com.groupc.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupc.dao.NonMemberDao;
import com.groupc.dto.NOrderVO;

public class FindNMOd_passAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/findNMOd_pass.jsp";
		
		String nmPhone = request.getParameter("nmPhone");
		String nmName = request.getParameter("nmName");
		if(nmName != null && nmPhone != null) {
			NonMemberDao nmdao = NonMemberDao.getInstance();
			ArrayList<NOrderVO> nmOrderList = nmdao.findOd_pass(nmName, nmPhone);
			request.setAttribute("nmOrderList", nmOrderList);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
