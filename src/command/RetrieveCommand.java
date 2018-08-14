package command;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import enums.Action;
import enums.Domain;
import enums.Term;
import service.ImageServiceImpl;
import service.MemberServiceImpl;

public class RetrieveCommand extends Command{

	


	public RetrieveCommand(HttpServletRequest request){
		setRequest(request);
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		execute();
	}

	
	@Override
	public void execute() {
		ImageBean img = new ImageBean();
		//img.setExtension(request.);
		 request.setAttribute("member", MemberServiceImpl.getInstance()
				 .retrieve(request.getParameter("id")));
		
		 super.execute();
		
		
	}
}
