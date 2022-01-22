package wm.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.dao.WMdao;
import wm.dto.WMVO;

public class DupliChkFAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("dupli_id");
		
		WMdao wmdao = WMdao.getInstance();
		WMVO wmvo = wmdao.getMember(id);
		
		if(wmvo == null) {
			request.setAttribute("result", -1);
		}else {
			request.setAttribute("result", 1);
		}
		
		request.setAttribute("chkid", id);
		
		request.getRequestDispatcher("wmem/dupliChk.jsp").forward(request, response);
	}

}
