package com.ezenac.controller.admin.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.controller.action.Action;
import com.ezenac.dao.AdminDao;
import com.ezenac.dto.AdminVO;
import com.ezenac.dto.QnaVO;

public class AdminQnaRepSaveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "shop.do?command=adminQnaDetail";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo == null) {
			url = "shop.do?command=admin";
		}else {
//			int qseq = Integer.parseInt(request.getParameter("qseq"));
//			QnaDao qdao = QnaDao.getInstance();
//			QnaVO qvo = qdao.qnaRepSave(qseq);
//			
//			request.setAttribute("qnaVO", qvo);
			
			AdminDao adao = AdminDao.getInstance();
			QnaVO qvo = new QnaVO();
			
			qvo.setQseq(Integer.parseInt(request.getParameter("qseq")));
			qvo.setReply(request.getParameter("reply"));
			
			adao.updateQna(qvo);
			
			url = url + "&qseq=" + qvo.getQseq();
		}
			
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
