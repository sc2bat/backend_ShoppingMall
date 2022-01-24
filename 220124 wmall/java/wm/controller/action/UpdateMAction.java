package wm.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wm.dao.WMdao;
import wm.dto.WMVO;

public class UpdateMAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WMVO wmvo = new WMVO();
		wmvo.setId(request.getParameter("um_id"));
		wmvo.setPwd(request.getParameter("um_pwd"));
		wmvo.setName(request.getParameter("um_name"));
		wmvo.setEmail(request.getParameter("um_email"));
		wmvo.setZip_num(request.getParameter("um_zip_num"));
		wmvo.setAddress(request.getParameter("addr1") + " " + request.getParameter("addr2"));
		wmvo.setPhone(request.getParameter("um_phone"));
		
		WMdao wmdao = WMdao.getInstance();
		wmdao.updateWM(wmvo);
		
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", wmvo);
		
		request.getRequestDispatcher("wm.do?cmd=index").forward(request, response);
	}

}
