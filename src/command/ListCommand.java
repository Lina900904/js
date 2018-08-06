package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		request.setAttribute("count", MemberServiceImpl.getInstance().memberCount());
		Map<String, Object> param = new HashMap<>();
		String beginRow = "1";
		String endRow = "5";
		param.put("beginRow", beginRow);
		param.put("endRow", endRow);
		List<MemberBean> mems = MemberServiceImpl.getInstance().getList(param);
		
		 // request.setAttribute("list", MemberServiceImpl.getInstance().memberList());
		request.setAttribute("seletList", MemberServiceImpl.getInstance().getList(param));		
		request.setAttribute("beginPage", "1" );
		//request.setAttribute("endPage", count%5==0?count/5 :count/5+1 );
		int count = (int) request.getAttribute("count");
		request.setAttribute("endPage", (count/Integer.parseInt(endRow))<6 
				? (count%Integer.parseInt(endRow)==0?count/Integer.parseInt(endRow) 
						:count/Integer.parseInt(endRow)+1) : Integer.parseInt(endRow));


	

	super.execute();
	}

	private Map<?, ?> param() {
		// TODO Auto-generated method stub
		return null;
	}



	
}
