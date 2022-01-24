package wm.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.dao.WMdao;
import wm.dto.WMVO;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "wmem/login.jsp";
		String id = request.getParameter("login_id");
		String pwd = request.getParameter("login_pwd");
		
		WMdao wmdao = WMdao.getInstance();
		WMVO wmvo = wmdao.getMember(id);
		
		if(wmvo == null) {
			request.setAttribute("message", "loginAction none ID");
		}else if(wmvo.getPwd() == null) {
			request.setAttribute("message", "loginAction Account Error");
		}else if(!wmvo.getPwd().equals(pwd)) {
			request.setAttribute("message", "Wrong Password");
		}else if(wmvo.getPwd().equals(pwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", wmvo);
			url = "wm.do?cmd=index";
		}else {
			request.setAttribute("message", "Failed Sign in");
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
