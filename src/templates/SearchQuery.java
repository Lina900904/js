package templates;

import java.sql.ResultSet;
import java.sql.SQLException;

import domain.MemberBean;
import enums.Domain;
import enums.MemberQuery;
import factory.DatabaseFactory;
import lombok.Data;

public class SearchQuery extends QueryTemplate {

	@Override
	void initialize() {
		map.put("sql", (!map.containsKey("column")) ?
				MemberQuery.LIST.toString()
				:MemberQuery.SEARCH.toString()
			);
			
			
	}
	

	@Override
	void startPlay() {
		try {
			
			
			int j = 0;
			if(map.containsKey("column")){
				j++;
				pstmt.setString(j,"%"
				+map.get("value").toString()+"%");
			}
			j++;
			pstmt.setString(j,
					map.get("beginRow").toString());
			j++;
			pstmt.setString(j,
					map.get("endRow").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean mem= null;
			while (rs.next()) {
				mem =new MemberBean();
				mem.setId(rs.getString("id"));
				mem.setName(rs.getString("name"));
				mem.setPassword(rs.getString("password"));
				mem.setSsn(rs.getString("ssn"));
				mem.setAge(rs.getString("age"));
				mem.setGender(rs.getString("gender"));
				mem.setTeamId(rs.getString("teamid"));
				mem.setRoll(rs.getString("roll"));
				list.add(mem);
				System.out.println("list~~"+list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}





}
