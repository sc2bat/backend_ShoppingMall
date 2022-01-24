package wm.controller;

import wm.controller.action.Action;
import wm.controller.action.AddCartAction;
import wm.controller.action.BuyNowAction;
import wm.controller.action.CategoryAction;
import wm.controller.action.DupliChkFAction;
import wm.controller.action.IndexAction;
import wm.controller.action.LoginAction;
import wm.controller.action.LoginFAction;
import wm.controller.action.LogoutAction;
import wm.controller.action.SearchZnumAction;
import wm.controller.action.SignUpAction;
import wm.controller.action.SignUpAgreeAction;
import wm.controller.action.SignUpFAction;
import wm.controller.action.UpdateFAction;
import wm.controller.action.UpdateMAction;
import wm.controller.action.WCListAction;
import wm.controller.action.WPDetailAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	public Action getAction(String cmd) {
		Action ac = null; 
		
		if(cmd.equals("index")) {ac = new IndexAction();
		}else if(cmd.equals("loginF")) {ac = new LoginFAction();
		}else if(cmd.equals("login")) {ac = new LoginAction();
		}else if(cmd.equals("logout")) {ac = new LogoutAction();
		}else if(cmd.equals("signUpAgree")) {ac = new SignUpAgreeAction();
		}else if(cmd.equals("signUpF")) {ac = new SignUpFAction();
		}else if(cmd.equals("dupliChkF")) {ac = new DupliChkFAction();
		}else if(cmd.equals("searchZnum")) {ac = new SearchZnumAction();
		}else if(cmd.equals("signUp")) {ac = new SignUpAction();
		}else if(cmd.equals("updateF")) {ac = new UpdateFAction();
		}else if(cmd.equals("updateM")) {ac = new UpdateMAction();
		}else if(cmd.equals("wpDetail")) {ac = new WPDetailAction();
		}else if(cmd.equals("category")) {ac = new CategoryAction();
		}else if(cmd.equals("wcList")) {ac = new WCListAction();
		}else if(cmd.equals("addCart")) {ac = new AddCartAction();
		}else if(cmd.equals("buyNow")) {ac = new BuyNowAction();
		}
		
		return ac;
	}
	
	
}
