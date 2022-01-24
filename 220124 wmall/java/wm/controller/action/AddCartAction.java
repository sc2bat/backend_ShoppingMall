package wm.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.dao.WCdao;
import wm.dto.WCVO;
import wm.dto.WMVO;

public class AddCartAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		WMVO wmvo = (WMVO)session.getAttribute("loginUser");
		
		String url = "";
		if(wmvo == null) {
			url = "wm.do?cmd=loginF";
		}else {
			WCVO wcvo = new WCVO();
			wcvo.setId(wmvo.getId());
			wcvo.setPseq(Integer.parseInt(request.getParameter("pd_pseq")));
			wcvo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			
			WCdao wcdao = WCdao.getInstance();
			wcdao.insertC(wcvo);
			
			url = "wm.do?cmd=wcList";
		}
		response.sendRedirect(url);
	}

}
