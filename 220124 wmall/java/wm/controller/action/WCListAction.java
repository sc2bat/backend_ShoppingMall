package wm.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.dao.WCdao;
import wm.dto.WCVO;
import wm.dto.WMVO;

public class WCListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "wmypage/cartList.jsp";
		
		HttpSession session = request.getSession();
		WMVO wmvo = (WMVO)session.getAttribute("loginUser");
		
		if(wmvo == null) {
			url = "wm.do?cmd=loginF";
		}else {
			WCdao wcdao = WCdao.getInstance();
			ArrayList<WCVO> clist = wcdao.selectC(wmvo.getId());
			request.setAttribute("clist", clist);
			
			int totalPrice = 0;
			for(WCVO wcvo : clist) {
				totalPrice += wcvo.getPrice_s()*wcvo.getQuantity();
			}
			request.setAttribute("totalPrice", totalPrice);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
