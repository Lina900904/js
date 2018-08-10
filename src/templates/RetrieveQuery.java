package templates;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;
import lombok.Data;

public class RetrieveQuery extends QueryTemplate {

	@Override
	void initialize() {

			
	
	
		
	}

	
		
	

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem = null;
			while (rs.next()) {
				mem = new MemberBean();			 
				mem.setId(rs.getString("userid"));
				mem.setName(rs.getString("name"));
				mem.setPassword(rs.getString("password"));
				mem.setSsn(rs.getString("ssn"));
				mem.setAge(rs.getString("age"));
				mem.setGender(rs.getString("gender"));
				mem.setTeamId(rs.getString("teamid"));
				mem.setRoll(rs.getString("roll"));
				list.add(mem);
				
			}
			System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}





	@Override
	void startPlay() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
