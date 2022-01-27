package com.ezenac.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.ezenac.controller.action.Action;
import com.ezenac.dao.AdminDao;
import com.ezenac.dto.AdminVO;
import com.ezenac.dto.OrderVO;
import com.ezenac.util.Paging;

public class AdminOrderListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/order/orderList.jsp";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		
		if(avo == null) {
			url = "shop.do?command=admin";
		}else {
			
			String sub = request.getParameter("sub");
			if(sub != null) {
				session.removeAttribute("key");
				session.removeAttribute("page");
			}
			
			int page = 1;
			if(request.getParameter("page") != null) { // 보려는 페이지가  파라미터로 전달될때
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			}else if(session.getAttribute("page") != null) { // 돌아갈 페이지값을 잃어버렸을때
				page = (int)session.getAttribute("page");
			}else { // 처음 리스트에 진입해서 1페이지를 봐야할 때 
//				page = 1;
				session.removeAttribute("page");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			AdminDao adao = AdminDao.getInstance();


			String key = "";
			if(request.getParameter("key") != null) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			}else if(session.getAttribute("key") != null) {
				key = (String)session.getAttribute("key");
			}else {
				session.removeAttribute("key");
				key = "";
			}
			
			int count = adao.getAllCount("order_view", "mname", key);
			paging.setTotalCount(count);
			
			ArrayList<OrderVO> orderList = adao.listOrder(paging, key);
			
			request.setAttribute("orderList", orderList);
			request.setAttribute("paging", paging);
			request.setAttribute("key", key);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
