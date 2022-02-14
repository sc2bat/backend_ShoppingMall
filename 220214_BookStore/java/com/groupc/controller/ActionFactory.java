package com.groupc.controller;

import com.groupc.controller.action.Action;
import com.groupc.controller.action.CartDeleteAction;
import com.groupc.controller.action.CartInsertAction;
import com.groupc.controller.action.CartListAction;
import com.groupc.controller.action.ContractAction;
import com.groupc.controller.action.FindIdAction;
import com.groupc.controller.action.FindPwdAction;
import com.groupc.controller.action.FindZipNumAction;
import com.groupc.controller.action.IdCheckFormAction;
import com.groupc.controller.action.IdResultAction;
import com.groupc.controller.action.IndexAction;
import com.groupc.controller.action.JoinAction;
import com.groupc.controller.action.LoginAction;
import com.groupc.controller.action.LoginFormAction;
import com.groupc.controller.action.LogoutAction;
import com.groupc.controller.action.MenuAction;
import com.groupc.controller.action.MypageAction;
import com.groupc.controller.action.OrderListAction;
import com.groupc.controller.action.ProSideAction;
import com.groupc.controller.action.PwdResultAction;
import com.groupc.controller.action.QnaListAction;
import com.groupc.controller.action.joinFormAction;
import com.groupc.controller.action.nonmemberLoginAction;
import com.groupc.controller.admin_action.AdminAction;
import com.groupc.controller.admin_action.AdminLoginAction;
import com.groupc.controller.admin_action.AdminLogoutAction;

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
		
		// nonmember
		else if( cmd.equals("nonmemberlogin")) { ac = new nonmemberLoginAction();}
		
		// mypage
		else if( cmd.equals("mypage")) { ac = new MypageAction();}
		
		
		//join
		else if(cmd.equals("joinForm")) {ac = new joinFormAction();}
		else if(cmd.equals("join")) {ac = new JoinAction();}
		
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
		
		// findId
		else if(cmd.equals("findId")) ac = new FindIdAction();
		else if(cmd.equals("findPwd")) ac = new FindPwdAction();
		
		// idResult
		else if(cmd.equals("idResult")) ac = new IdResultAction();
		
		// pwdResult
		else if(cmd.equals("pwdResult")) ac = new PwdResultAction();
		
		// menu&kind
		else if(cmd.equals("menu"))ac = new MenuAction(); // top_menu action
		else if(cmd.equals("proSide"))ac = new ProSideAction(); // prodcut side_menu action
		
		// admin
		else if(cmd.equals("admin"))ac = new AdminAction();
		else if(cmd.equals("adminLogin"))ac = new AdminLoginAction();
		else if(cmd.equals("adminLogout"))ac = new AdminLogoutAction();
		
		return ac;
	}
	
	

}
