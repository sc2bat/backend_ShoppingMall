package com.ezenac.controller.admin.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezenac.controller.action.Action;
import com.ezenac.dao.AdminDao;
import com.ezenac.dto.AdminVO;
import com.ezenac.dto.ProductVO;
import com.ezenac.util.Paging;

public class AdminProductListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/product/productList.jsp";
		HttpSession session = request.getSession();
		AdminVO avo = (AdminVO)session.getAttribute("loginAdmin");
		if(avo == null) {
			url = "shop.do?command=admin";
		}else {
			
			String sub = request.getParameter("sub");
//			if(sub != null && sub.equals("y")) {
			if(sub != null) {
				session.removeAttribute("key");
				session.removeAttribute("page");
			}
			
			int page = 1;
			if(request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				// 보고 있던 목록으로 돌아가기
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
			if(request.getParameter("key") != null ) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			}else if(session.getAttribute("key") != null) {
				key = (String)session.getAttribute("key");
			}else {
				session.removeAttribute("key");
				key= "";
			}
			// 검색어는 레코드 갯수를 세는 동작부터 영향을 줌
//			int count = adao.getAllCount();
			// getAllCount 를 여러 테이블에서 사용할수 있게끔 테이블명 필드명 변수
			int count = adao.getAllCount("shopproduct", "name", key);
			
			
			paging.setTotalCount(count);
			request.setAttribute("paging", paging);
					
					
//			ArrayList<ProductVO> productList = adao.listProduct(paging);
			ArrayList<ProductVO> productList = adao.listProduct(paging, key);
			request.setAttribute("productList", productList);
			request.setAttribute("key", key);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
