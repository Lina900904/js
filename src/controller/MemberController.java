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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
			System.out.println("!!!!!!!!!#####");

			if (request.getAttribute("match").equals("TRUE")) {
				// request.getSession().setAttribute("user", request.getAttribute("user"));
				Receiver.cmd.execute();
				Carrier.forword(request, response);
			} else {
				Carrier.redirect(request, response, "/member.do?action=move&page=retrieve");
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
			System.out.println("----1-----");
			if (!ServletFileUpload.isMultipartContent(request)) {
				System.out.println("업로드 파일 없음");
				return;
			}
			System.out.println("----2. 업로드 파일이 존재-----");
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(1024 * 1024 * 40);// 40MB
			upload.setSizeMax(1024 * 1024 * 50); // 50MB
			List<FileItem> items = null;
	
			try {
				System.out.println("----3.try 내부 진입-----");
				File file = null;
				items =upload.parseRequest((new ServletRequestContext(request)));
				System.out.println("----4 아이템 생성-----");
				Iterator<FileItem>iter = items.iterator();
				while (iter.hasNext()) {
					System.out.println("----5. while 진입-----");
					FileItem item = (FileItem)iter.next();
					if(!item.isFormField()) {
						System.out.println("----6.if 진입-----");
						String fileName = item.getName();
						file = new File(Term.UPLOAD_PATH+fileName);
						item.write(file);
						System.out.println("----7. 업로드 성공 ---");
						System.out.println(fileName);
						//이미지 테이블에 id, image name, ext저장
						
						
					}else {
						System.out.println("----8. 업로드 실패----");
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Carrier.redirect(request, response, "/member.do?action=retrieve&page=login");
			System.out.println("----2-----");
			break;

		default:Carrier.redirect(request, response, "");
			break;

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
