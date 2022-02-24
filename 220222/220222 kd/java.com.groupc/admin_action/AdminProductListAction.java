package com.groupc.controller.admin_action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupc.controller.action.Action;
import com.groupc.dao.AdminDao;
import com.groupc.dto.AdminVO;
import com.groupc.dto.ProductVO;
import com.groupc.util.Paging;

public class AdminProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/admin_productList.jsp";
		
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
				
		if(avo == null) {
			url = "bs.do?cmd=admin";
		}else {
			String sub = request.getParameter("sub");
			
			if(sub != null) {
				session.removeAttribute("page");
				session.removeAttribute("key");
			}
			
			int page = 1;
			
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			}else if(session.getAttribute("page") != null) {
				page = (int)session.getAttribute("page");
			}else {
				page = 1;
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
			
			int count = adao.getAdminCount("bookproduct", "bname", key);
			
			paging.setTotalCount(count);
			request.setAttribute("paging", paging);
			
			ArrayList<ProductVO> productList = adao.getProductList(paging, key);
			request.setAttribute("productList", productList);
			request.setAttribute("key", key);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
