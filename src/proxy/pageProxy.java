package proxy;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class pageProxy implements proxy {
	HttpServletRequest request;
	
	@Override
	public Map<?, ?> carrayOut(Map<?, ?> param) {
		Map<String, Object> map =new HashMap<>();
		request= (HttpServletRequest) param.get("request");
		/*request.setAttribute("existPrev", existPrev);
		request.setAttribute("existNext", existNext);
		request.setAttribute("count", rowCount);
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("page", page);*/
		map.put("request", request);
		
		return map;
	}
	
}
