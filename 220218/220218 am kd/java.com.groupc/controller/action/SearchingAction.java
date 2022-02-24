package com.groupc.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupc.dao.ProductDao;
import com.groupc.dao.ReviewDao;
import com.groupc.dto.ProductVO;
import com.groupc.dto.ReviewVO;
import com.groupc.util.Paging;

public class SearchingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "bs.do?cmd=index";
//		
//		String option = request.getParameter("option");
//		String str = request.getParameter("str");
//		
		HttpSession session = request.getSession();
		
		String sub = request.getParameter("sub");
		if(sub!=null && sub.equals("y")) {
			session.removeAttribute("option");
			session.removeAttribute("str");
			session.removeAttribute("page");
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
		
		String option="";
		if( request.getParameter("option") != null ) {
			option = request.getParameter("option");
			session.setAttribute("option", option);
		} else if( session.getAttribute("option")!= null ) {
			option = (String)session.getAttribute("option");
		} else {
			session.removeAttribute("option");
			option = "";
		}
		String str="";
		if( request.getParameter("str") != null ) {
			str = request.getParameter("str");
			session.setAttribute("str", str);
		} else if( session.getAttribute("str")!= null ) {
			str = (String)session.getAttribute("str");
		} else {
			session.removeAttribute("str");
			str = "";
		}
		
		ProductDao pdao = ProductDao.getInstance();
		
		int count = pdao.getProductCount(str, option);
		paging.setTotalCount(count);
		request.setAttribute("paging", paging);
		
		
		ReviewDao rdao = ReviewDao.getInstance();
		if(option.equals("리뷰")) {
			ArrayList<ReviewVO> searchViewList = rdao.getSearchViewList(str);
			request.setAttribute("searchViewList", searchViewList);
			url = "product/viewReview.jsp";
		}else {
			ArrayList<ProductVO> searchViewList = pdao.getSearchViewList(option, str, paging);
			request.setAttribute("productViewList", searchViewList);
			url = "product/viewProduct.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
