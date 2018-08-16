package command;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import enums.Term;
import service.MemberServiceImpl;

public class AddCommand extends Command{
	MemberBean joinm;
	ImageBean img;
	public AddCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1,request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		//setPage("page");
		execute(); //this.이 생략되어있다
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) { 
		case MEMBER:
			System.out.println("조인안으로 진입");
			joinm = new MemberBean();			
			joinm.setId(request.getParameter("userid"));
			joinm.setName(request.getParameter("name"));
			joinm.setPassword(request.getParameter("password"));
			joinm.setSsn(request.getParameter("ssn"));
			joinm.setAge(request.getParameter("age"));
			joinm.setGender(request.getParameter("gender"));
			joinm.setTeamId(request.getParameter("teamid"));
			joinm.setRoll(request.getParameter("roll"));
			MemberServiceImpl.getInstance().add(joinm);
	
			request.setAttribute("pagename", "retrieve");
			
			System.out.println(joinm);
			

	
			break;
		
		

		default:
			break;
		
		}
		super.execute();
		

		
	}
	
	
}
