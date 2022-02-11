package com.groupc.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.groupc.dao.ProductDao;
import com.groupc.dto.ProductVO;

public class MenuAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "";
		String kind = request.getParameter("kind");

		ProductDao pdao = ProductDao.getInstance();
		
		if(kind.equals("1")) {
			ArrayList<ProductVO> bestList = pdao.getBestList();
			request.setAttribute("bestList", bestList);
			url = "bestProduct.jsp";
		}else if(kind.equals("2")) {
			ArrayList<ProductVO> newList = pdao.getNewList();
			request.setAttribute("newList", newList);
			url = "newProduct.jsp";
		}else if(kind.equals("3")) {
			ArrayList<ProductVO> localList = pdao.getLocalList();
			request.setAttribute("localList", localList);
			url = "localProduct.jsp";
		}else if(kind.equals("4")) {
			ArrayList<ProductVO> globalList = pdao.getGlobalList();
			request.setAttribute("globalList", globalList);
			url = "globalProduct.jsp";
		}else if(kind.equals("5")) {
			url = "event.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
