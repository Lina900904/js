package template;

import java.sql.PreparedStatement;
import java.util.*;

import enums.Vendor;
import lombok.Data;
import pool.DBConstant;

//step1
@Data
public abstract class QueryTemplate {
	HashMap<String, Object>map;
	List<Object>list;
	PreparedStatement pstmt;
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();
	
	public final void play(HashMap<String, Object>map) {
	this.pstmt = null;
	this.list= new ArrayList<>();
	this.map = map;
	this.map.put("Vendor", Vendor.ORACLE);
	this.map.put("userid", DBConstant.USERNAME);
	this.map.put("password", DBConstant.PASSWORD);
	initialize();
	startPlay();
	endPlay();
	}
}




