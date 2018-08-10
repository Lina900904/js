package enums;

import templates.ColumnFinder;

public enum MemberQuery {
	LOGIN, ADD,RETRIEVE,COUNT,UPDATE,DELETE, SEARCH, LIST, ;	
@Override
	public String toString() {
		String query="";
		switch(this) {
		case LOGIN :
			query=" SELECT * "
		              + "    FROM MEMBER  "
		              + "    WHERE ID LIKE ? AND PASSWORD LIKE ? ";
			break;
		case ADD :
			query= "     INSERT INTO MEMBER "
		              + "    ( * )  "
		              + "    VALUES ( ? , ? , ? , ? , ? , ?, ? , ?, ?) ";
			break;
		case 	RETRIEVE :
			query = "SELECT" + ColumnFinder.find(Domain.MEMBER)
		              + "    FROM MEMBER  " 
					+ "  WHERE ID LIKE ? " ;
			break;
		case 	COUNT :
			query = " SELECT COUNT(*) AS COUNT "
					+ " FROM MEMBER ";
			
			break;
		case 	UPDATE :
			query = " UPDATE  " 
					+ " MEMBER SET %s = ? "
					+ " WHERE ID LIKE ? ";
			
			break;
		case 	DELETE :
			query = " DELETE FROM MEMBER " + 
					" WHERE ID LIKE ?  AND PASSWORD LIKE ? ";
			
			break;
		case 	SEARCH :
			query = " select t.* "
					+ " from(select rownum seq, m.* "
					+ " from member m "
					+ " where %s like ? "
					+ " order by seq desc) t "
					+ 	" where t.seq between ? and ? ";
			
			break;
	
		
	case 		LIST :
		query = " select t.* "
				+ " from ( select rownum seq, m.* "
				+ " from member m "
				+ " order by seq desc ) t "
				+ 	" where t.seq between ? and ? ";
		
		break;

	}

	
	
		return query;
	}

}
