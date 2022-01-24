package wm.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.dao.WPdao;
import wm.dto.WPVO;

public class WPDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		
		WPdao wpdao = WPdao.getInstance();
		WPVO wpvo = wpdao.getProduct(pseq);
		
		request.setAttribute("wpD", wpvo);
		
		request.getRequestDispatcher("wproduct/wpDtail.jsp").forward(request, response);
	}

}
