package dao;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domain.MemberBean;
import domain.MemberBean;

public interface MemberDAO {
	public void insert(MemberBean member);
	public List<MemberBean> selectSome(Map<?, ?>param);
	public MemberBean selectOne(String id);
	public int count();
	public void update(Map<?, ?>param);
	public void delete(MemberBean member);
	public boolean login(MemberBean member);

	

}
