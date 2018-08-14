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

public class AddQuery extends QueryTemplate {
	ImageBean img=null;
	
	@Override
	void initialize() {
		switch (map.get("table").toString()) {
		case "IMAGE":
			map.put("imgUp", 
					String.format(				
					ImageSQL.UPLOAD_IMG.toString(),
					img.getImgseq(),
					img.getImgname(),
					img.getExtension(),
					img.getUserid()));
				System.out.println("IMG SQL문 내부 ");
			break;

		default:
			break;
		}
		
		
	}
	

	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	@Override
	void startPlay() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
