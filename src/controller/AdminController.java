package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import enums.Action;

/**
 * Servlet implementation class Admin
 */
@WebServlet( "/admin.do")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action =request.getParameter("action");
		String page = request.getParameter("page");
		Receiver.init(request, response); // sentry.cmd를 만들었다
		
		
				
			switch(Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
			
			case RETRIEVE :
				Carrier.forword(request, response);
				break;
				
			case SEARCH :
				Carrier.forword(request,response);			
			break;
			case MOVE :
				Carrier.forword(request, response);
			break;
		
			default:
				break;

	}

			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
