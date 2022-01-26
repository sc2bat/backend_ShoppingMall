package com.ezenac.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezenac.dao.ProductDao;
import com.ezenac.dto.ProductVO;

public class ProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전달된 상품번호로 상품의 상세내역을 조회
		int pseq = Integer.parseInt(request.getParameter("pseq"));
		ProductDao pdao = ProductDao.getInstance();
		ProductVO pvo = pdao.getProduct(pseq);
		
		// 조회된 상품을 request 담고, productDetail.jsp 로 이동합니다
		request.setAttribute("productVO", pvo);
		
//		RequestDispatcher dp = request.getRequestDispatcher("product/productDetail.jsp");
//		dp.forward(request, response);
		
		request.getRequestDispatcher("product/productDetail.jsp").forward(request, response);
	}

}
