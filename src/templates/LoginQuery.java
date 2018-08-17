package templates;

import enums.MemberQuery;

import java.sql.ResultSet;
import java.sql.SQLException;


import domain.*;

public class LoginQuery extends QueryTemplate {

	@Override
	void initialize() {
		System.out.println("로그인 쿼리~~~");
		map.put("sql",MemberQuery.LOGIN.toString());
	}
	@Override
	void startPlay() {
		try {
			pstmt.setString(1, (String) map.get("id"));
			pstmt.setString(2, (String) map.get("pass"));
			System.out.println("startPlay"+map.get("id")+"/"+map.get("pass"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	void endPlay() {
		try {
			 ResultSet rs = pstmt.executeQuery();
				System.out.println(" ResultSet" );
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
				System.out.println("로그인 쿼리 입장" + o);
		}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}



