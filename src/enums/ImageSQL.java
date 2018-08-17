package enums;

public enum ImageSQL {
	UPLOAD_IMG, RETRIEVE,;
	@Override
	public String toString() {
		String sql = "";
		switch (this) {
		case UPLOAD_IMG:
			sql = " INSERT INTO IMAGE "
					+ " ( IMG_SEQ, IMG_NAME, EXTENSION, ID ) "
					+ " VALUES( IMG_SEQ.NEXTVAL , ? , ? , ? ) " ;
			break;
		case RETRIEVE:
			sql = " SELECT IMG_NAME, EXTENSION, ID "
					+ " FROM IMAGE " 
					+ " WHERE ID LIKE ?  ";
			break;
		default:
			break;
		}
		return sql;
		
	}
}
