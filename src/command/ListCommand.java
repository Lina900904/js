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
		int pageSize = 5;
	 	int pageCount =0;
		int pageNumber = 0;
		int blockSize=0;

		Map<String, Object> param = new HashMap<>();
		int beginPage = pageNumber-((pageNumber-1)%blockSize-1) ;
		int endPage =pageCount;	
		int endRow = pageNumber*pageSize;
		
		

	 	int count = MemberServiceImpl.getInstance().memberCount();
	 	int rowCount  = 0;
	 	if(rowCount % pageSize==0) {
	 		int pageCount = rowCount/pageSize;
	 	}else {
	 		int pageCount = rowCount/pageSize+1;
	 	}

		int prevBlock = beginPage-blockSize;
		int nextBlock = beginPage-blockSize;
		int beginRow =0;
		
	 	

	 	if(endPage%pageCount==0) {
	 		endPage =beginPage*pageSize;
	 	}else {
	 		endPage =beginPage*(pageSize+1);
	 	}
	 	boolean existPrev = false;
	 	if(prevBlock>=0) {
	 		existPrev = true;
	 	}
		boolean existNext = false;
	 	if(existNext<=pageCount) {
	 		existPrev = true;
	 	}

		List<MemberBean> mems = MemberServiceImpl.getInstance().getList(param);
	
		
		request.setAttribute("count", MemberServiceImpl.getInstance().memberCount());
		request.setAttribute("seletList", MemberServiceImpl.getInstance().getList(param));		

		
		
		
		
		
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
