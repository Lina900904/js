package enums;

public enum MemberQuery {
	LOGIN, INSERT_MEMBER,SELECT_ID,COUNT_MEMBER,UPDATE_MEMBER,DELETE_MEMBER, SELECT_ALL, SELECT_TEAM, GET_LIST, ;	
	@Override
	public String toString() {
		String query="";
		switch(this) {
		case LOGIN :
			query=" SELECT id , "
		              + "   teamId , "
		              + "    NAME ,  "		        
		              + "    ROLL ,  "
		              + "    PASSWORD ,  "
		              + "    SSN ,        "
		              + "    AGE ,        "
		              + "    GENDER        "
		              + "    FROM MEMBER  "
		              + "    WHERE id LIKE '%s' AND PASSWORD LIKE '%s' ";
			break;
		case INSERT_MEMBER :
			query= "     INSERT INTO MEMBER "
		              + "    ( id  , "
		              + "   PASSWORD   , "
		              + "   SSN  , "
		              + "   NAME , "
		              + "   GENDER , "
		              + "   ROLL , "
		              + "   teamId , "
		              + "   AGE ) "
		              + "    VALUES ( '%s' , '%s' , '%s' , '%s' , '%s' , '%s', '%s' , '%s' ) ";
			break;
		case 	SELECT_ID :
			query = " SELECT id , "
		              + "    teamId , "
		              + "    NAME ,  "		        
		              + "    ROLL ,  "
		              + "    PASSWORD ,  "
		              + "    SSN ,       "
		              + "    AGE ,       "
		              + "    GENDER        "
		              + "    FROM MEMBER  " 
					+ "  WHERE id LIKE '%s' " ;
			break;
		case 	COUNT_MEMBER :
			query = " SELECT COUNT(*) AS count "
					+ " FROM MEMBER ";
			
			break;
		case 	UPDATE_MEMBER :
			query = " UPDATE MEMBER " 
					+ " SET PASSWORD = '%s' ,"
					+ " ROLL = '%s' ,"
					+ " teamId = '%s' "  
					+ " WHERE id = '%s' ";
			
			break;
		case 	DELETE_MEMBER :
			query = " DELETE FROM MEMBER " + 
					" WHERE id = '%s'  AND PASSWORD = '%s' ";
			
			break;
		case 	SELECT_ALL :
			query = " SELECT id , "
		              + "    teamId , "
		              + "    NAME ,  "		        
		              + "    ROLL ,  "
		              + "    PASSWORD ,  "
		              + "    SSN ,        "
		              + "    GENDER  ,      "
		              + "    AGE        "
		              + "    FROM MEMBER  " ;
			
			break;
			
		case 		SELECT_TEAM :
			query = " SELECT id , "
		              + "    teamId , "
		              + "    NAME ,  "		        
		              + "    ROLL ,  "
		              + "    PASSWORD ,  "
		              + "    SSN ,      "
		              + "    GENDER  ,      "
		              + "    AGE        "
		              + "    FROM MEMBER  " 
					+ "  WHERE teamId LIKE '%s' " ;
			
			break;
	
		
	case 		GET_LIST :
		query = " select t.* "
				+ " from(select rownum seq, m.* "
				+ " from member m "
				+ " order by seq desc) t "
				+ 	" where t.seq between '%s' and '%s' ";
		
		break;

	}

	
	
		return query;
	}

}
