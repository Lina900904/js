package command;

import javax.servlet.http.HttpServletRequest;

public class ParamMap { // 체크박스 값을 가져오는 유틸
	public static String gatValuse(HttpServletRequest request, String name) {
		String[] values = request.getParameterMap().get(name);
		StringBuffer buff = new StringBuffer();
		for(String s : values) {
			buff.append(s+",");
			
		}
		System.out.println(buff.toString().substring(0,buff.toString().length()-1));
		return buff.toString().substring(0,buff.toString().length()-1);
		
	}

}
