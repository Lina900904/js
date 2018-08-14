package templates;

import enums.MemberQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.*;

public class LoginQuery extends QueryTemplate {

	MemberBean mem = null;
	@Override
	void initialize() {
		System.out.println("로그인 쿼리~~~");
		
		map.put("sql",String.format(MemberQuery.LOGIN.toString()));
		
		
	}

	@Override
	void startPlay() {
		mem= (MemberBean) map.get("member");
		try {
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPassword());
			
			
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
				mem.setId(rs.getString("ID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setAge(rs.getString("AGE"));
				mem.setRoll(rs.getString("ROLL"));
				mem.setGender(rs.getString("GENDER"));
				mem.setPassword(rs.getString("PASSWORD"));
				mem.setSsn(rs.getString("SSN"));
				System.out.println("로그인 쿼리 입장" + mem.getName());
		}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}



