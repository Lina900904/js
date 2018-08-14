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
			//joinm.setSubject(ParamMap.gatValuse(request,"subject"));
			MemberServiceImpl.getInstance().add(joinm);	
			request.setAttribute("pagename", "add");
			
			img = new ImageBean();
			/*img.setExtension(extension);
			img.setImgname(imgname);
			img.setImgseq(imgseq);
			img.setUserid(userid);*/
			
		
			System.out.println("회원가입 성공");
			
			 File file = new File(Term.UPLOAD_PATH.toString());
			 String path = Term.UPLOAD_PATH.toString();
			 String sep = File.separator;
			 String ext = path.substring(path.lastIndexOf(".") + 1);
			 String fileName = path.substring(path.lastIndexOf(sep) + 1, path.lastIndexOf("."));
			System.out.println(path);
			System.out.println(sep);
			System.out.println(ext);
			System.out.println(path);
			
			//String img = "";
			// ImageServiceImpl.getInstance().insertImg(img);
			 
			 String imgPath = "/upload/" +img; 
			 request.setAttribute("img", imgPath);
			 
			break;
		/*	joinm.setAge(request.getParameter(String.valueOf(
					Integer.valueOf(new SimpleDateFormat("yyyy").format(new Date()))-1900+1
					-
					Integer.parseInt(joinm.getSsn().substring(0, 2)))));
					

			if(request.getParameter("gender").substring(8, 1).equals("1")) {
				joinm.setGender("남자");
			}else {
				joinm.setGender("여자");
			}*/
		
		

		default:
			break;
		
		}
		super.execute();
		

		
	}
	
	
}
