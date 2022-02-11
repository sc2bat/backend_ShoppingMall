package com.groupc.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.groupc.dao.CartDao;
import com.groupc.dto.CartVO;
import com.groupc.dto.MemberVO;

public class CartInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");
		String url = "";
		if(mvo==null) {
			url = "bs.do?cmd=loginForm";
		}else {
			
			CartVO cvo = new CartVO();
			cvo.setId(mvo.getId());
			cvo.setBseq(Integer.parseInt(request.getParameter("bseq")));
			cvo.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			CartDao cdao = CartDao.getInstance();
			cdao.insertCart(cvo);
			url = "bs.do?cmd=cartList";     
			//insert의 대상은 cart테이블, select의 대상은 cart_view뷰
		}
		
		response.sendRedirect(url);

	}

}
