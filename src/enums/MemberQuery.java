package enums;

public enum MemberQuery {
	LOGIN, INSERT_MEMBER,SELECT_ID,COUNT_MEMBER,UPDATE_MEMBER,DELETE_MEMBER, SELECT_ALL, SELECT_TEAM, GET_LIST, ;	
@Override
	public String toString() {
		String query="";
		switch(this) {
		case LOGIN :
			query=" SELECT MEM_ID , "
		              + "   TEAM_ID , "
		              + "    NAME ,  "		        
		              + "    ROLL ,  "
		              + "    PASSWORD ,  "
		              + "    SSN ,        "
		              + "    AGE ,        "
		              + "    GENDER        "
		              + "    FROM MEMBER  "
		              + "    WHERE MEM_ID LIKE '%s' AND PASSWORD LIKE '%s' ";
			break;
		case INSERT_MEMBER :
			query= "     INSERT INTO MEMBER "
		              + "    ( MEM_ID  , "
		              + "   PASSWORD   , "
		              + "   SSN  , "
		              + "   NAME , "
		              + "   GENDER , "
		              + "   ROLL , "
		              + "   TEAM_ID , "
		              + "   AGE ) "
		              + "    VALUES ( '%s' , '%s' , '%s' , '%s' , '%s' , '%s', '%s' , '%s' ) ";
			break;
		case 	SELECT_ID :
			query = " SELECT MEM_ID , "
		              + "    TEAM_ID , "
		              + "    NAME ,  "		        
		              + "    ROLL ,  "
		              + "    PASSWORD ,  "
		              + "    SSN ,       "
		              + "    AGE ,       "
		              + "    GENDER        "
		              + "    FROM MEMBER  " 
					+ "  WHERE MEM_ID LIKE '%s' " ;
			break;
		case 	COUNT_MEMBER :
			query = " SELECT COUNT(*) AS count "
					+ " FROM MEMBER ";
			
			break;
		case 	UPDATE_MEMBER :
			query = " UPDATE MEMBER " 
					+ " SET PASSWORD = '%s' ,"
					+ " ROLL = '%s' ,"
					+ " TEAM_ID = '%s' "  
					+ " WHERE MEM_ID = '%s' ";
			
			break;
		case 	DELETE_MEMBER :
			query = " DELETE FROM MEMBER " + 
					" WHERE MEM_ID = '%s'  AND PASSWORD = '%s' ";
			
			break;
		case 	SELECT_ALL :
			query = " SELECT MEM_ID , "
		              + "    TEAM_ID , "
		              + "    NAME ,  "		        
		              + "    ROLL ,  "
		              + "    PASSWORD ,  "
		              + "    SSN ,        "
		              + "    GENDER  ,      "
		              + "    AGE        "
		              + "    FROM MEMBER  " ;
			
			break;
			
		case 		SELECT_TEAM :
			query = " SELECT MEM_ID , "
		              + "    TEAM_ID , "
		              + "    NAME ,  "		        
		              + "    ROLL ,  "
		              + "    PASSWORD ,  "
		              + "    SSN ,      "
		              + "    GENDER  ,      "
		              + "    AGE        "
		              + "    FROM MEMBER  " 
					+ "  WHERE TEAM_ID LIKE '%s' " ;
			
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
