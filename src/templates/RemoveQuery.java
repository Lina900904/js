package templates;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import factory.DatabaseFactory;
import lombok.Data;

public class RemoveQuery extends QueryTemplate {

	@Override
	void initialize() {
		
		map.put("sql", MemberQuery.DELETE.toString());
	
	
		
	}

	
	@Override
	void startPlay() {
		try {
			pstmt.setString(1,(String)map.get("id"));
			pstmt.setString(2,(String)map.get("passwordS"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

		
	

	@Override
	void endPlay() {
		try {

			pstmt.executeQuery();
				
			
			System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}







	
	
	
	
	
}
