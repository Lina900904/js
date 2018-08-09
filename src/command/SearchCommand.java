package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Action;
import enums.Domain;
import proxy.PageProxy;
import proxy.Pagination;
import service.MemberServiceImpl;

public class SearchCommand extends Command{


	public SearchCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	
	}
	
	@Override
	public void execute() {
		System.out.println("1.SearchCommand : " );
		Map<String, Object> param= new HashMap<>();
		String pageNumber = request.getParameter("pageNumber");
		PageProxy pxy = new PageProxy();
		int pn = (pageNumber==null)?1:Integer.parseInt(pageNumber);
		pxy.carryOut(pn);
		Pagination page = pxy.getPagination();
		param.put("beginRow", String.valueOf(page.getBeginRow()));
		param.put("endRow",  String.valueOf(page.getEndRow()));
		request.setAttribute("page", page);
		request.setAttribute("list", MemberServiceImpl.getInstance().search(param));
		

		
		
		
		//팩토리 패턴
		/* String beginRow = "1";
			String endRow = "5";
			param.put("beginRow", beginRow);
			param.put("endRow", endRow);
			List<MemberBean> mems = MemberServiceImpl.getInstance().getList(param);
			param.put("beginRow", String.valueOf(beginRow));
			param.put("endRow",  String.valueOf(endRow));
			
			request.setAttribute("count", MemberServiceImpl.getInstance().memberCount());
			int count = MemberServiceImpl.getInstance().memberCount();
			request.setAttribute("list", MemberServiceImpl.getInstance().memberList());
			request.setAttribute("seletList", MemberServiceImpl.getInstance().getList(param));		
			request.setAttribute("beginPage", "1" );
			request.setAttribute("endPage", count%5==0?count/5 :count/5+1 );
			request.setAttribute("endPage", (count/Integer.parseInt(endRow))<6 
					? (count%Integer.parseInt(endRow)==0?count/Integer.parseInt(endRow) 
							:count/Integer.parseInt(endRow)+1) : Integer.parseInt(endRow));*/

	

	super.execute();
	}



	
}
