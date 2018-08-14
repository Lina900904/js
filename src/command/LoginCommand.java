package command;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDAOImpl;
import domain.MemberBean;
import enums.*;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand (HttpServletRequest request) {
		setRequest(request); //super가 생략되어 있음, 위에 request와는 본질적으로 다르지만 setRequest를 해줌으로써 같아짐
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
		
		
	}
	@Override
	public void execute() {
	
		System.out.println("로그인커맨드 진입~~~~~~!!!!");
		request.setAttribute("pagename", "login");
		super.execute(); //-> view
		MemberBean lom= new MemberBean();
	
		lom.setId(request.getParameter("userid"));
		lom.setPassword(request.getParameter("password"));
		System.out.println(lom);
	
		if(MemberServiceImpl.getInstance().login(lom)) {
			System.out.println("Login Success!!!");
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("user", 
					MemberServiceImpl
					.getInstance()
					.retrieve(request.getParameter("userid")));
	
			System.out.println("request user : \n"+request.getAttribute("user"));
		}else{request.setAttribute("match", "FALSE");
			System.out.println("null값");
			}
		
}
	
}
