package command;


import enums.Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.*;
import domain.MemberBean;



public class Commander {

	public static  Command order(HttpServletRequest request, HttpServletResponse response) {
		Command cmd = null;
		switch(Action.valueOf(request.getParameter("action").toUpperCase())) {
		case MOVE :
			System.out.println("무브진입");
			cmd = new MoveCommand(request);  
			// cmd는 sentry.cmd임
			// 이객체는 case문이 실행되고 나면 사라짐 그래서 sentry.cmd를 만들어서 그곳에 붙어 있게함
			//여러 형태로 sentry.cmd를 만들수있다, 아래처럼(다형성)
			break;
		case ADD : 
			System.out.println("조인진입");
			cmd =new AddCommand(request);
			break;
		case LOGIN : 
			System.out.println("로그인 진입");
			cmd = new LoginCommand(request);
			break;
		case RETRIEVE :
			
			cmd = new RetrieveCommand(request);
			break;
		case SEARCH :
			System.out.println("찾기 진입");
			//List<MemberBean> mems= ((SearchCommand) Sentry.cmd).getMember();
			cmd = new SearchCommand(request);
			break;
		case MODIFY :
			System.out.println("업데이트 진입");
			cmd = new ModifyCommand(request);
			break;
		case REMOVE :
			cmd = new RemoveCommand(request);
			break;
		case COUNT :
			System.out.println("카운트 진입");
			cmd = new CountCommand(request);
			break;

		default:
			break;
			
		
			

		}
		return cmd;
	}
		
}
