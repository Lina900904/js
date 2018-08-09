package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
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
			MemberBean member = (MemberBean) request.getSession().getAttribute("user");
			System.out.println("==변경전==\n"+member);
			Map<?, ?> param = new HashMap<>();
			
			member.setPassword(request.getParameter("newpass"));
			member.setTeamId(request.getParameter("teamid"));
			member.setRoll(request.getParameter("roll"));
			System.out.println("==변경할 정보=="+member);
			MemberServiceImpl.getInstance().modify(param);
		default:
			break;
		}
		super.execute();
		
	}
}
