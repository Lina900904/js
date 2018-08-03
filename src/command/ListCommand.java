package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Action;
import enums.Domain;
import service.MemberServiceImpl;

public class ListCommand extends Command{


	public ListCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	
	}
	
	@Override
	public void execute() {
	request.setAttribute("list", MemberServiceImpl.getInstance().memberList());
	
	request.setAttribute("count", MemberServiceImpl.getInstance().memberCount());
	
	int count = (int) request.getAttribute("count");
	
	request.setAttribute("pageNum", count%5==0?count/5 :count/5+1 );
	 System.out.println(request.getAttribute("count"));

	
	

	super.execute();
	}



	
}
