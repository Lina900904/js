package enums;

public enum Term {
	WEBPATH, MAIN, CONTEXT, COMMON, UPLOAD_PATH;
	
	@Override
	public String toString() {
		String res = "";
		switch(this) {
		case CONTEXT : 
			res = "context";
			break;
		case WEBPATH : 
			res = "/WEB-INF/view/";
			break;
		case MAIN : 
			res = "/main.jsp";
			break;
		case UPLOAD_PATH :
			res = "C:\\Users\\1027\\eclipse\\jee-oxygen\\eclipse\\JEE workspace\\GMS-Model2\\WebContent\\resources\\img\\upload\\";
			break;
		
			
		
		


		}
		return res;
	}
}
