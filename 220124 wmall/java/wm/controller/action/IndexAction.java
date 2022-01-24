package wm.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.dao.WPdao;
import wm.dto.WPVO;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WPdao wpdao = WPdao.getInstance();
		
		ArrayList<WPVO> bestList = wpdao.getBestList();
		ArrayList<WPVO> newList = wpdao.getNewList();
		
		request.setAttribute("wblist", bestList);
		request.setAttribute("wnlist", newList);
		
		request.getRequestDispatcher("windex.jsp").forward(request, response);
	}

}
