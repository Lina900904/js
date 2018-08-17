package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import enums.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import command.Carrier;
import command.SearchCommand;
import command.Receiver;
import domain.MemberBean;
import service.MemberServiceImpl;

@WebServlet("/member.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String page = request.getParameter("page");
		Receiver.init(request, response); // sentry.cmd를 만들었다
		System.out.println("================pagename : "+request.getAttribute("pagename"));
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE:
			System.out.println("무브안으로 진입");
			Carrier.forword(request, response);
			break;
		case ADD:

			Carrier.redirect(request, response, "/member.do?action=move&page=login");
			break;

		case LOGIN:
			System.out.println("*** [1] MemberController - case LOGIN");

			if (request.getAttribute("match").equals("TRUE")) {
				Carrier.forword(request, response);
			} else {
				Carrier.redirect(request, response, "/member.do?action=move&page=login");
				System.out.println("----로그인실패----");
			}
			break;
		case RETRIEVE:
			Carrier.forword(request, response);
			break;
		case SEARCH:

			Carrier.forword(request, response);
			break;
		case MODIFY:
			System.out.println("modify 진입~~");
			Carrier.forword(request, response);
			break;
		case REMOVE:
			Carrier.forword(request, response);
			break;
		case FILEUPLOAD:
			Carrier.forword(request, response);
			break;

			
		default:Carrier.redirect(request, response, "");
			break;

		}

	}


}
