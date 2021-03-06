package com.ezenac.controller;

import com.ezenac.controller.action.Action;
import com.ezenac.controller.action.CartDeleteAction;
import com.ezenac.controller.action.CartInsertAction;
import com.ezenac.controller.action.CartListAction;
import com.ezenac.controller.action.CategoryAction;
import com.ezenac.controller.action.ContractAction;
import com.ezenac.controller.action.EditFormAction;
import com.ezenac.controller.action.FindZipNumAction;
import com.ezenac.controller.action.IdCheckFormAction;
import com.ezenac.controller.action.IndexAction;
import com.ezenac.controller.action.JoinAction;
import com.ezenac.controller.action.JoinFormAction;
import com.ezenac.controller.action.LoginAction;
import com.ezenac.controller.action.LoginFormAction;
import com.ezenac.controller.action.LogoutAction;
import com.ezenac.controller.action.MemberUpdateAction;
import com.ezenac.controller.action.OrderInsertAction;
import com.ezenac.controller.action.ProductDetailAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	public Action getAction(String command) {
		Action ac = null;
		
		if(command.equals("index")) {ac = new IndexAction();
		}else if(command.equals("loginForm")) {ac = new LoginFormAction();
		}else if(command.equals("login")) {ac = new LoginAction();
		}else if(command.equals("logout")) {ac = new LogoutAction();
		}else if(command.equals("contract")) {ac = new ContractAction();
		// 회원가입 전 회원약관에 동의를 위해 contract 
		}else if(command.equals("joinForm")) {ac = new JoinFormAction();
		}else if(command.equals("idCheckForm")) {ac = new IdCheckFormAction();
		}else if(command.equals("findZipNum")) {ac = new FindZipNumAction();
		}else if(command.equals("join")) {ac = new JoinAction();
		}else if(command.equals("editForm")) {ac = new EditFormAction();
		}else if(command.equals("memberUpdate")) {ac = new MemberUpdateAction();
		}else if(command.equals("productDetail")) {ac = new ProductDetailAction();
		}else if(command.equals("category")) {ac = new CategoryAction();
		}else if(command.equals("cartInsert")) {ac = new CartInsertAction();
		}else if(command.equals("cartList")) {ac = new CartListAction();
		}else if(command.equals("cartDelete")) {ac = new CartDeleteAction();
		}else if(command.equals("orderInsert")) {ac = new OrderInsertAction();
		}
		
		return ac;
	}
	
	
}
