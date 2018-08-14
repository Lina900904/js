package enums;

public enum ImageSQL {
	UPLOAD_IMG, DOWNLOAD_IMG,;
	
	@Override
	public String toString() {
		String sql = "";
		switch (this) {
		case UPLOAD_IMG:
			sql = " INSERT INTO IMAGE "
					+ " (IMG_SEQ,IMG_NAME,EXTENSION,ID) "
					+ " VALUES( ? , ? , ? , ? ) " ;
			break;

		default:
			break;
		}
		
		
		
		
		return sql;
		
		
	}
}
