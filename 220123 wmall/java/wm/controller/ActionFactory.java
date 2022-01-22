package wm.controller;

import wm.controller.action.Action;
import wm.controller.action.DupliChkFAction;
import wm.controller.action.IndexAction;
import wm.controller.action.LoginAction;
import wm.controller.action.LoginFAction;
import wm.controller.action.LogoutAction;
import wm.controller.action.SearchZnumAction;
import wm.controller.action.SignUpAction;
import wm.controller.action.SignUpAgreeAction;
import wm.controller.action.SignUpFAction;

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
		}else if(cmd.equals("signUp")) {ac = new SignUpAction();
		}else if(cmd.equals("dupliChkF")) {ac = new DupliChkFAction();
		}else if(cmd.equals("searchZnum")) {ac = new SearchZnumAction();
		}
		
		return ac;
	}
	
	
}
