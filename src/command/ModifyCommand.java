package command;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import enums.Term;
import service.MemberServiceImpl;

public class ModifyCommand extends Command{
	public ModifyCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		// setPage(request.getParameter("page"));
		execute();
	}
	
	
	@Override
	public void execute() {
		switch (Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
		case MEMBER	:
			MemberBean member = (MemberBean) request.getSession().getAttribute("member");
			System.out.println("==변경전==\n"+member);
			HashMap<String, Object> map = new HashMap<>();
			request.setAttribute("pagename", "retrieve");
			
			map.put("table", Domain.IMG);
			map.put("newpass", request.getParameter("newpass"));
			map.put("teamid", request.getParameter("teamid"));
			map.put("roll", request.getParameter("roll"));
			map.put("id", member.getId());

			
			System.out.println("==변경할 정보=="+member);
			MemberServiceImpl.getInstance().modify(map);
			

						 
		
		
		default:
			break;
		}
		super.execute();
		
	}
}
