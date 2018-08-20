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
		execute();
	
	}
	
	// 팀검색, 이름검색, 아이디
	
	
	
	
	
	
	@Override
	public void execute() {
		Map<String,String> paramMap = new HashMap<>();
		String pageNumber = request.getParameter("pageNumber");
		PageProxy pxy = new PageProxy();
		pxy.carryOut((pageNumber==null)
				? 1:
			Integer.parseInt(pageNumber));
	
		Pagination page = pxy.getPagination();
		String[] arr1 = {"domain","beginRow","endRow"};
		String[] arr2 = {
				request.getServletPath()
					.split("/")[1]
					.split("\\.")[0],
				String.valueOf(page.getBeginRow()),
				String.valueOf(page.getEndRow())
		};
		for(int i = 0; i < arr1.length; i++){
			paramMap.put(arr1[i],arr2[i]);
		}
		request.setAttribute("pagename", "search");
		request.setAttribute("page", page);
		request.setAttribute("list",
				MemberServiceImpl.getInstance()
					.search(paramMap));
		request.setAttribute("count", MemberServiceImpl.getInstance().count());
		System.out.println("count 값~~"+request.getAttribute("count"));
		super.execute();
		
		
		
	}



	
}
