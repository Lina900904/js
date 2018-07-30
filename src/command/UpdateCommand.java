package command;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class UpdateCommand extends Command{
	public UpdateCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	
	
	@Override
	public void execute() {
		switch (Domain.valueOf(Sentry.cmd.domain.toUpperCase())) {
		case MEMBER	:
			MemberBean member = (MemberBean) request.getSession().getAttribute("user");
			System.out.println("==변경전==\n"+member);
			member.setPassword(request.getParameter("newpass"));
			member.setTeamId(request.getParameter("teamid"));
			member.setRoll(request.getParameter("roll"));
			System.out.println("==변경할 정보=="+member);
			MemberServiceImpl.getInstance().memberUpdate(member);
		default:
			break;
		}
		super.execute();
		
	}
}
