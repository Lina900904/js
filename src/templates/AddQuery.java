package templates;

import java.sql.SQLException;
import java.util.HashMap;

import domain.ImageBean;
import domain.MemberBean;
import enums.Domain;
import enums.ImageSQL;
import enums.MemberQuery;
import lombok.Data;

public class AddQuery extends QueryTemplate {
	
	@Override
	void initialize() {
		
		switch ((Domain)map.get("table")) {
		case MEMBER:
			map.put("sql", MemberQuery.ADD.toString());
			System.out.println(map.get("sql"));
			break;
		case IMG:
			map.put("sql", ImageSQL.UPLOAD_IMG.toString());
			System.out.println(map.get("sql"));
			break;
			

		default:
			break;
		}
		
		
	}
	
	@Override
	void startPlay() {
		try {
			switch ((Domain)map.get("table")) {
			case MEMBER:
				System.out.println("addQuery 진입");
				pstmt.setString(1, (String) map.get("userid"));
				pstmt.setString(2, (String) map.get("password"));
				pstmt.setString(3, (String) map.get("ssn"));
				pstmt.setString(4, (String) map.get("name"));
				pstmt.setString(5, (String) map.get("gender"));
				pstmt.setString(6, (String) map.get("roll"));
				pstmt.setString(7, (String) map.get("teamid"));
				pstmt.setString(8, (String) map.get("age"));
				System.out.println("pstmt"+map);
				break;
			case IMG:
				//pstmt.setString(1, (String) map.get("IMG_SEQ"));
				pstmt.setString(2, img.getImgname() );
				pstmt.setString(3, img.getExtension());
				pstmt.setString(4, img.getUserid());
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
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}






	
	
	
	
	
}
