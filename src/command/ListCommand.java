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
		int pageNumber=0;
		int pageSize=0;
		int blockSize=0;	
		int rowCount=0; 
		int pageCount=0;
		int clockCount=0;
		int beginRow=0;
		int endRow=0;
		int beginPage= pageNumber-((pageNumber-1)%blockSize-1) ;; 
		int endPage=0;
		int prevBlock=0; 
		int nextBlock=0;
		boolean existPrev=false;
		boolean existNext=false;
	
	
	 	if(rowCount % pageSize>0) {
	 		pageCount++;
	 	}
	 	
		  
	 	if(endPage%pageCount==0) {
	 		endPage =beginPage*pageSize;
	 	}else {
	 		endPage =beginPage*(pageSize+1);
	 	}
	 
	 	if(prevBlock>=0) {
	 		existPrev = true;
	 	}
	
	 	if(prevBlock<=pageCount) {
	 		existPrev = true;
	 	}

		Map<String, Object> map = new HashMap<>();
		map.put("beginRow", String.valueOf(beginRow));
		map.put("endRow", String.valueOf(endRow));
		Map<String, Object> prame =new HashMap<>();
		request.setAttribute("existPrev", existPrev);
		request.setAttribute("existNext", existNext);
		request.setAttribute("count", rowCount);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("page", page);

		
		
		
		
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
