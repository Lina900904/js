package templates;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import enums.ImageSQL;
import enums.MemberQuery;

public class RetrieveQuery extends QueryTemplate {
	
	@Override
	void initialize() {

		switch ((Domain) map.get("table")) {
		case MEMBER:
			map.put("sql",MemberQuery.RETRIEVE.toString());
			break;
		case IMG:
			map.put("sql", ImageSQL.RETRIEVE.toString());

			break;
		default:
			break;
		}
	}
	@Override
	void startPlay() {
		try {
	
			
			switch ((Domain) map.get("table")) {

			case MEMBER:
				pstmt.setString(1, (String) map.get("userid"));
				break;
			case IMG:
				pstmt.setString(1,(String)map.get("id"));
				break;
			default:
				break;
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Override
	void endPlay() {

		try {
			ResultSet rs = pstmt.executeQuery();
			switch ((Domain) map.get("table")) {
			case MEMBER:
				while(rs.next()) {
					MemberBean o = new MemberBean();
					o.setId(rs.getString("ID"));
					o.setTeamId(rs.getString("TEAMID"));
					o.setName(rs.getString("NAME"));
					o.setAge(rs.getString("AGE"));
					o.setRoll(rs.getString("ROLL"));
					o.setGender(rs.getString("GENDER"));
					o.setPassword(rs.getString("PASSWORD"));
					o.setSsn(rs.getString("SSN"));
					System.out.println("쿼리 리트리버 입장" + o);
					super.o=o;
				}
				break;
			case IMG:
		
				
				while(rs.next()) {
					ImageBean o = new ImageBean();
					o.setId(rs.getString("id"));
					o.setImgname(rs.getString("imgname"));
					o.setExtension(rs.getString("extension"));

			System.out.println("modify 쿼리 입장" + o);
	}
				
				break;
			default:
				break;
			}
		
			
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}






	
	
	
	
	
}
