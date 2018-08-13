package templates;

import enums.MemberQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.*;

public class LoginQuery extends QueryTemplate {
	MemberBean mem = null;
	@Override
	void initialize() {
		
		map.put("sql",String.format(MemberQuery.LOGIN.toString(),
				mem.getId(),mem.getPassword()));
		System.out.println("@@@@@ dao에서 ID, PASS : "+mem.getId()+mem.getPassword());
		
		
	}

	@Override
	void startPlay() {

		
	}

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				  mem.setId(rs.getString("MEM_ID"));
				  mem.setName(rs.getString("NAME"));
				  mem.setTeamId(rs.getString("TEAM_ID"));                  
				  mem.setRoll(rs.getString("ROLL"));
				  mem.setPassword(rs.getString("PASSWORD"));
				  mem.setSsn(rs.getString("SSN"));
				  mem.setAge(rs.getString("AGE"));
				  mem.setGender(rs.getString("GENDER"));
				  
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
