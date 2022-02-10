package com.groupc.controller;

import com.groupc.controller.action.Action;
import com.groupc.controller.action.CartDeleteAction;
import com.groupc.controller.action.CartInsertAction;
import com.groupc.controller.action.CartListAction;
import com.groupc.controller.action.ContractAction;
import com.groupc.controller.action.FindZipNumAction;
import com.groupc.controller.action.IdCheckFormAction;
import com.groupc.controller.action.IndexAction;
import com.groupc.controller.action.LoginAction;
import com.groupc.controller.action.LoginFormAction;
import com.groupc.controller.action.LogoutAction;
import com.groupc.controller.action.MypageAction;
import com.groupc.controller.action.OrderListAction;
import com.groupc.controller.action.QnaListAction;
import com.groupc.controller.action.joinFormAction;

public class ActionFactory {
	private ActionFactory () {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	public Action getAction(String cmd) {
		Action ac = null;
		
		if(cmd.equals("index")) {ac = new IndexAction();}
		
		/**/
		// login
		else if( cmd.equals("loginForm")) { ac = new LoginFormAction();}
		else if( cmd.equals("login")) { ac = new LoginAction();}
		else if( cmd.equals("logout") ) ac = new LogoutAction();
		
		// mypage
		else if( cmd.equals("mypage")) { ac = new MypageAction();}
		
		
		//join
		else if(cmd.equals("joinForm")) {ac = new joinFormAction();}
		
		// qna
		else if(cmd.equals("qnaList")) {ac = new QnaListAction();}
		
		// order
		else if(cmd.equals("orderList")) {ac = new OrderListAction();}
//		else if(cmd.equals("orderInsert") ) ac = new OrderInsertAction();

		// cart
		else if(cmd.equals("cartList")) {ac = new CartListAction();}
		else if(cmd.equals("cartInsert")) ac = new CartInsertAction();
		else if(cmd.equals("cartDelete") ) ac = new CartDeleteAction();
		
		// contract
		else if(cmd.equals("contract")) {ac = new ContractAction();}
		
		// idCheckForm
		else if(cmd.equals("idCheckForm")) ac = new IdCheckFormAction();
		
		// findZipNum
		else if(cmd.equals("findZipNum")) ac = new FindZipNumAction();
		
		return ac;
	}
	
	

}
