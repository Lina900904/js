package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.MemberBean;
import enums.Domain;
import service.MemberServiceImpl;

public class RemoveCommand extends Command{
	List<MemberBean> list;
	public List<MemberBean> getList() {
		return list;
	}

	public RemoveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		//setPage(request.getParameter("page"));
		execute();
		
	}
	
	@Override
	public void execute() {
		switch (Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
		case MEMBER:
			MemberBean dm = new MemberBean();
			// dm.setId(request.getParameter("id"));
			dm.setId(((MemberBean) request.getSession().getAttribute("user")).getId());
			dm.setPassword(request.getParameter("pass"));
			
			MemberServiceImpl.getInstance().remove(dm);
			request.getSession().invalidate();
			
			break;

		default:
			break;
		}
		super.execute();
	}

}
