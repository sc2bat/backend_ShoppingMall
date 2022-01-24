package wm.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.dao.WMdao;
import wm.dto.WAVO;

public class SearchZnumAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dong = request.getParameter("dong");
		if(dong != null) {
			if(dong.equals("") == false) {
				WMdao wmdao = WMdao.getInstance();
				ArrayList<WAVO> alist = wmdao.selectA(dong);
				request.setAttribute("aList", alist);
			}
		}
		request.getRequestDispatcher("wmem/wAddress.jsp").forward(request, response);
	}

}
