package templates;

import java.sql.PreparedStatement;
import java.util.*;

import domain.ImageBean;
import domain.MemberBean;
import enums.Vendor;
import factory.DatabaseFactory;
import lombok.Data;
import pool.DBConstant;

//step1
@Data
public abstract class QueryTemplate {
	HashMap<String, Object> map;
	List<Object> list;
	PreparedStatement pstmt;
	Object o;
	int number;
	int count;
	ImageBean img ;
	

	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();

	public final void play(Map<?, ?> param) {
		img = new ImageBean();
		this.o=null;
		this.number = 0;
		this.pstmt = null;
		this.list = new ArrayList<>();
		this.map = new HashMap<>();
		this.map.put("Vendor", Vendor.ORACLE);
		this.map.put("dbId", DBConstant.USERNAME);
		this.map.put("dbPass", DBConstant.PASSWORD);
		Iterator<?> keys = param.keySet().iterator();
		while (keys.hasNext()) {
			String key = (String) keys.next();
			this.map.put(key, param.get(key));
		}
		initialize();
		pstmtInit();
		startPlay();
		endPlay();
	}
	
	public final void play() {
		this.number = 0;
		this.pstmt = null;
		this.map = new HashMap<>();
		this.map.put("Vendor", Vendor.ORACLE);
		this.map.put("dbId", DBConstant.USERNAME);
		this.map.put("dbPass", DBConstant.PASSWORD);
		initialize();
		pstmtInit();
		startPlay();
		endPlay();
	}

	public final void play(ImageBean img) {
		img = new ImageBean();
		this.map = new HashMap<>();
		this.pstmt = null;
		this.map.put("Vendor", Vendor.ORACLE);
		this.map.put("dbId", DBConstant.USERNAME);
		this.map.put("dbPass", DBConstant.PASSWORD);
		initialize();
		pstmtInit();
		startPlay();
		endPlay();
	}
	
	public void pstmtInit() {
		try {
			pstmt = DatabaseFactory
					.createDatabase2(map)
					.getConnection()
					.prepareStatement((String) map.get("sql"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
