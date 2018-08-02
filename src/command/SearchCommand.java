package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class SearchCommand extends Command {
	
	private List<MemberBean> member;

	public List<MemberBean> getMember() {
		return member;
	}

	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}

	@Override
	public void execute() {
		String searchOption=request.getParameter("option");
		String searchWord = request.getParameter("word");
		String page = request.getParameter("page");
		String action = request.getParameter("action");
		String domain = super.domain;
		System.out.println(searchOption);		
		System.out.println(searchWord);		
		System.out.println(page);		
		System.out.println(action);		
		System.out.println(domain);		
	

		request.setAttribute("list", MemberServiceImpl.getInstance()
				.memberfindByName(searchOption+"/"+searchWord));
		
		
		
/*		select*from 
		where searchOption like '%searchWord%'*/
		
		
	/*	case MEMBER:
			this.member=
			
			MemberServiceImpl.getInstance().memberfindByName(request.getParameter("teamid"));
			break;
		

		default:
			break;*/
		
		super.execute();
	
	
	}


	
	
}
