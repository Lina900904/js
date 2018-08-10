package templates;


import java.sql.ResultSet;
import java.sql.SQLException;

import enums.Domain;
import enums.MemberQuery;
import factory.DatabaseFactory;
import lombok.Data;

public class CountQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql",MemberQuery.COUNT.toString());
		System.out.println("sql~~~~"+map.get("sql"));
		
	}
	
	@Override
	void startPlay() {
		// TODO Auto-generated method stub
		
	}


	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			number = (rs.next())?rs.getInt("count"):0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}



}
		
	
		


	
	
	
