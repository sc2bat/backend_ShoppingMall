package wm.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.dao.WPdao;
import wm.dto.WPVO;

public class CategoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String kind = request.getParameter("kind");
		
//		System.out.println(kind); 1
		
		WPdao wpdao = WPdao.getInstance();
		ArrayList<WPVO> klist = wpdao.selectPK(kind);
		
//		System.out.println(klist.size()); 0
		
		request.setAttribute("klist", klist);
		
		request.getRequestDispatcher("wproduct/wPKlist.jsp").forward(request, response);
	}

}
