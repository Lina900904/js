package template;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import factory.DatabaseFactory;
import lombok.Data;

public class PstmtQuery extends QueryTemplate {

	@Override
	void initialize() {
	
			map.put("sql", String.format(
					" SELECT "
					+ColumnFinder.find(Domain.MEMBER)
					+ " FROM %s "
					+ " WHERE %s "
					+ " LIKE ? ",
					map.get("table"),
					map.get("column")));
			
	
	
		
	}

	@Override
	void startPlay() {
		System.out.println("====================");
		System.out.println(map.get("sql"));
		
			try {
				pstmt = DatabaseFactory
						.createDatabase2(map)
						.getConnection()
						.prepareStatement((String)map.get("sql"));
				pstmt.setString(1, "%"+map.get("value").toString()+"%");
						
						
			} catch (SQLException e) {
				e.printStackTrace();
			}
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

	
	
	
	
	
}
