package command;

import javax.servlet.http.HttpServletRequest;

import dao.MemberDAOImpl;
import domain.ImageBean;
import domain.MemberBean;
import enums.*;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand (HttpServletRequest request) {
		System.out.println("*** [2] LoginCommand Contructor ENTER");
		setRequest(request); //super가 생략되어 있음, 위에 request와는 본질적으로 다르지만 setRequest를 해줌으로써 같아짐
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		execute();
	}
	@Override
	public void execute() {
		System.out.println("*** [3] LoginCommand execute() ENTER");
		request.setAttribute("pagename", "retrieve");
		super.execute(); //-> view
		MemberBean lom= new MemberBean();
	
		lom.setId(request.getParameter("userid"));
		lom.setPassword(request.getParameter("password"));
		System.out.println("*** [4] LoginCommand lom toString :: "+lom);
	
		if(MemberServiceImpl.getInstance().login(lom)) {
			System.out.println("*** [5] LoginCommand SUCCESS ");
			request.setAttribute("match", "TRUE");
			request.getSession().setAttribute("member", 
					MemberServiceImpl
					.getInstance()
					.retrieve(request.getParameter("userid")));
			
			request.getSession().setAttribute("profile", 
					"/upload/"+ImageServiceImpl.getInstance().retrieve(lom.getId())
					);
			
			System.out.println(request.getSession().getAttribute("member"));
			//request.getSession().setAttribute("profile", arg1);
	
		}else{
			request.setAttribute("match", "FALSE");
			System.out.println("*** [5] LoginCommand FAIL ");
		}
		
}
}
