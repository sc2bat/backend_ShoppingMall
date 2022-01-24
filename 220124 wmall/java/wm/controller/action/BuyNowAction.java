package wm.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.dao.WOdao;
import wm.dao.WPdao;
import wm.dto.WMVO;
import wm.dto.WPVO;

public class BuyNowAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		int pseq = Integer.parseInt(request.getParameter("pd_pseq"));
		int quantity =  Integer.parseInt(request.getParameter("quantity"));
		
		HttpSession session = request.getSession();
		WMVO wmvo = (WMVO)session.getAttribute("loginUser");
		
		if(wmvo == null) {
			url = "wm.do?cmd=loginF";
		}else {
			WPdao wpdao = WPdao.getInstance();
			WPVO wpvo = wpdao.getProduct(pseq);
			
			WOdao wodao = WOdao.getInstance();
			int oseq = wodao.insertBNow(wpvo, wmvo.getId(), quantity);
			
			url = "wm.do?cmd=woList&oseq=" + oseq;
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
}
