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
	public void insertMember(MemberBean member);
	public List<MemberBean> selectMemberList();
	public List<MemberBean> selectList(Map<?, ?>param);
	public List<MemberBean> selectMemberSome(String word);
	public MemberBean selectMemberOne(String id);
	public int countMember();
	public void updateMember(MemberBean member);
	public MemberBean deleteMember(MemberBean member);
	public MemberBean login(MemberBean member);

	

}
