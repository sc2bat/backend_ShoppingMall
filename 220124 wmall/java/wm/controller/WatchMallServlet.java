package wm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wm.controller.action.Action;

@WebServlet("/wm.do")
public class WatchMallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public WatchMallServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		ActionFactory af = ActionFactory.getInstance();
		Action ac = af.getAction(cmd);
		
		if(ac != null) {
			ac.execute(request, response);
		}else {
			System.out.println("ac == null / check cmd");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
