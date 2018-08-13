package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class FileCommand extends Command{


	public FileCommand(HttpServletRequest request){
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		execute();
	}

	
	@Override
	public void execute() {
		 request.setAttribute("member", MemberServiceImpl.getInstance()
				 .retrieve(request.getParameter("id")));
		 super.execute();
		
		
	}
}
