package templates;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import enums.ImageSQL;
import enums.MemberQuery;
import factory.DatabaseFactory;
import lombok.Data;

public class ModifyQuery extends QueryTemplate {

	@Override
	void initialize() {

	
			map.put("sql", MemberQuery.UPDATE.toString());
	

	}

	@Override
	void startPlay() {
		try {
	
			pstmt.setString(1,(String)map.get("newpass"));
			pstmt.setString(2,(String)map.get("teamid"));
			pstmt.setString(3,(String)map.get("roll"));
			pstmt.setString(4,(String)map.get("id"));
			
		


	}catch(SQLException e){
		e.printStackTrace();
	}

	}

	@Override
	void endPlay() {
		try {
		
			
					pstmt.executeQuery();
					
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
