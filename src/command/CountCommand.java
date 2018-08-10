package command;

import javax.servlet.http.HttpServletRequest;

import service.MemberServiceImpl;

public class CountCommand extends Command{
	
	public CountCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	 @Override
	public void execute() {
		 System.out.println("카운트 진입했어~~~");
		
		 request.setAttribute("count",MemberServiceImpl.getInstance().count());
		
		super.execute();
	}

}
