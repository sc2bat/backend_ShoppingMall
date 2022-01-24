package wm.controller.action;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.dao.WMdao;
import wm.dto.WMVO;

public class SignUpAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WMdao wmdao = WMdao.getInstance();
		WMVO wmvo = new WMVO();
		
		wmvo.setId(request.getParameter("su_id"));
		wmvo.setPwd(request.getParameter("su_pwd"));
		wmvo.setName(request.getParameter("su_name"));
		wmvo.setEmail(request.getParameter("su_email"));
		wmvo.setZip_num(request.getParameter("su_znum"));
		wmvo.setAddress(request.getParameter("addr1") + " " + request.getParameter("addr2"));
		wmvo.setPhone(request.getParameter("su_phone"));
		
		int result = wmdao.insertWM(wmvo);
		String message = "";
		if(result == 1) {
			message = "signUp Success";
		}else {
			message = "signUp Failed";
		}
		
		response.sendRedirect("wm.do?cmd=loginF&message=" + URLEncoder.encode(message, "UTF-8"));
	}

}
