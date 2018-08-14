package templates;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import factory.DatabaseFactory;
import lombok.Data;

public class RetrieveQuery extends QueryTemplate {
	MemberBean mem = null;
	
	@Override
	void initialize() {
		map.put("sql",
				String.format(
						MemberQuery.RETRIEVE.toString()));
		
		
	}
	@Override
	void startPlay() {
		try {
			pstmt.setString(1, mem.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			mem = new MemberBean();
			while(rs.next()) {
				mem.setId(rs.getString("USERID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setGender(rs.getString("GENDER"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				System.out.println("쿼리 리트리버 입장" + mem.getName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}






	
	
	
	
	
}
