package templates;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate {
	
	
	@Override
	void initialize() {
		map.put("sql",MemberQuery.RETRIEVE.toString());
		
		
	}
	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String) map.get("userid"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	void endPlay() {

		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				o = new MemberBean();
				((MemberBean)o).setId(rs.getString("ID"));
				((MemberBean)o).setTeamId(rs.getString("TEAMID"));
				((MemberBean)o).setName(rs.getString("NAME"));
				((MemberBean)o).setAge(rs.getString("AGE"));
				((MemberBean)o).setRoll(rs.getString("ROLL"));
				((MemberBean)o).setGender(rs.getString("GENDER"));
				((MemberBean)o).setPassword(rs.getString("PASSWORD"));
				((MemberBean)o).setSsn(rs.getString("SSN"));
				System.out.println("쿼리 리트리버 입장" + o);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}






	
	
	
	
	
}
