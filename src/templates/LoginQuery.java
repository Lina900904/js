package templates;

import enums.MemberQuery;
import domain.*;

public class LoginQuery extends QueryTemplate {
	
	@Override
	void initialize() {
		map.put("sql",String.format(MemberQuery.LOGIN.toString(),
				member.getId()));
	}

	@Override
	void startPlay() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void endPlay() {
		// TODO Auto-generated method stub
		
	}

}
