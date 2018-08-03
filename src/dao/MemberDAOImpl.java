package dao;

import java.sql.*;

import java.util.*;


import domain.*;
import enums.*;
import factory.*;

import oracle.jdbc.driver.DBConversion;
import pool.*;
import template.PstmtQuery;
import template.QueryTemplate;


public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	
	private MemberDAOImpl() {};


	@Override
	public void insertMember(MemberBean member) {

		try { 
		DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeUpdate(
							String.format(MemberQuery.INSERT_MEMBER.toString(),						           
						             member.getId(),
						             member.getPassword(), 
						             member.getSsn(),
						             member.getName(),
						             member.getGender(),
						             member.getRoll(),
						             member.getTeamId(),
						             member.getAge()));
	
		} catch (Exception e) {   
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectMemberList() {

		List<MemberBean> lst = new ArrayList<>();
		try {
			Class.forName(DBConstant.ORACLE_DRIVER);
			ResultSet rs = DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(MemberQuery.SELECT_ALL.toString());

			while(rs.next()) {
				MemberBean m = new MemberBean();
				m.setId(rs.getString("MEM_ID"));
				m.setName(rs.getString("NAME"));
				m.setPassword(rs.getString("PASSWORD"));
				m.setRoll(rs.getString("ROLL"));
				m.setSsn(rs.getString("SSN"));
				m.setTeamId(rs.getString("TEAM_ID"));
				m.setAge(rs.getString("AGE"));
				m.setGender(rs.getString("GENDER"));
				lst.add(m);
				
	
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		return lst;
	}

	@Override
	public List<MemberBean> selectMemberSome(String word) {
		QueryTemplate q = new PstmtQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map= new HashMap<>();
		map.put("column", word.split("/")[0]);
		map.put("value", word.split("/")[1]);
		map.put("table", Domain.MEMBER);
		q.play(map);
		for(Object s : q.getList()) {
			list.add((MemberBean) s);
		}
				
		
		return list;
		
	}
		
		
		
		
		
		
		
		
		
		
		
/*		List<MemberBean> teamList = new ArrayList<>();
		String sql = " SELECT MEM_ID , "
	              + "   TEAM_ID , "
	              + "    NAME ,  "		        
	              + "    ROLL ,  "
	              + "    PASSWORD ,  "
	              + "    SSN ,        "
	              + "    AGE ,        "
	              + "    GENDER        "
	              + "    FROM MEMBER  "
	              + "    WHERE  " + word.split("/")[0] 
					+ " LIKE '%" + word.split("/")[1]+"%' ";
		MemberBean m = null;
		try {
		
		ResultSet rs= DatabaseFactory.createDatabase(Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
				.getConnection()
				.createStatement()
				.executeQuery(sql);
		 
			while(rs.next()) {
			m = new MemberBean();
				m.setId(rs.getString("MEM_ID"));
				m.setName(rs.getString("NAME"));
				m.setPassword(rs.getString("PASSWORD"));
				m.setRoll(rs.getString("ROLL"));
				m.setSsn(rs.getString("SSN"));
				m.setTeamId(rs.getString("TEAM_ID"));
				m.setAge(rs.getString("AGE"));
				m.setGender(rs.getString("GENDER"));
				teamList.add(m);

			}
	
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		
		return teamList;*/




	@Override
	public MemberBean selectMemberOne(String id) {

		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(MemberQuery.SELECT_ID.toString(),
						              id));
			while(rs.next()) {
			m= new MemberBean();
           m.setId(rs.getString("MEM_ID"));
           m.setName(rs.getString("NAME"));
           m.setRoll(rs.getString("ROLL"));
           m.setPassword(rs.getString("PASSWORD"));
           m.setSsn(rs.getString("SSN"));
           m.setTeamId(rs.getString("TEAM_ID"));
           m.setAge(rs.getString("AGE"));
           m.setGender(rs.getString("GENDER"));
           System.out.println(m);
			}
		} catch (Exception e) {   
			e.printStackTrace();
		} 
		
	
	return m;

	}

	@Override
	public int countMember() {
		int count = 0;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							MemberQuery.COUNT_MEMBER.toString());

			while(rs.next()) {
				count = rs.getInt("count");
				
                }
			
		} catch (Exception e) {   
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public void updateMember(MemberBean member) {
		System.out.println("==DAO UPDATE==");
		try {
			DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.UPDATE_MEMBER.toString(),        
					member.getPassword(),
					member.getRoll(),
					member.getTeamId(),
					member.getId()));
			System.out.println("==DAO UPDATE SUCCESS==");
		} catch (Exception e) {   
			e.printStackTrace();
		}
	}

	@Override
	public MemberBean deleteMember(MemberBean member) {

		MemberBean m =null;
		
		try {
			 DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.DELETE_MEMBER.toString(),        
		              member.getId(),member.getPassword()));
				
	
                
			
		} catch (Exception e) {   
			e.printStackTrace();
		}
		return m;
	}


	

	@Override
	public MemberBean login(MemberBean member) {
		MemberBean m = null;
		
		try {
			ResultSet rs =  DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(MemberQuery.LOGIN.toString(),        
		              member.getId(),member.getPassword()));
			
		

			while(rs.next()) {
				m = new MemberBean();
                m.setId(rs.getString("MEM_ID"));
                m.setName(rs.getString("NAME"));
                m.setTeamId(rs.getString("TEAM_ID"));                  
                m.setRoll(rs.getString("ROLL"));
                m.setPassword(rs.getString("PASSWORD"));
                m.setSsn(rs.getString("SSN"));
                m.setAge(rs.getString("AGE"));
                m.setGender(rs.getString("GENDER"));
            	System.out.println("dao받은값====="+m);
                }
			
		} catch (Exception e) {   
			e.printStackTrace();
		}

		return m;
	}





	
	
}