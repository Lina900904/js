package dao;

import java.sql.*;

import java.util.*;


import domain.*;
import enums.*;
import factory.*;

import oracle.jdbc.driver.DBConversion;
import pool.*;
import template.PstmtQuery;
import template.PstmtQuery2;
import template.QueryTemplate;


public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	
	private MemberDAOImpl() {};


	@Override
	public void intsert(MemberBean member) {
//
		try { 
		DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeUpdate(
							String.format(MemberQuery.ADD.toString(),						           
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
	public MemberBean selectOne(String id) {

		MemberBean m = null;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							String.format(MemberQuery.RETRIEVE.toString(),
						              id));
			while(rs.next()) {
			m= new MemberBean();
           m.setId(rs.getString("ID"));
           m.setName(rs.getString("NAME"));
           m.setRoll(rs.getString("ROLL"));
           m.setPassword(rs.getString("PASSWORD"));
           m.setSsn(rs.getString("SSN"));
           m.setTeamId(rs.getString("TEAMID"));
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
	public int count() {
		int count = 0;
		try {
			ResultSet rs = DatabaseFactory.createDatabase(
					Vendor.ORACLE, 
					DBConstant.USERNAME, 
					DBConstant.PASSWORD)
					.getConnection()
					.createStatement()
					.executeQuery(
							MemberQuery.COUNT.toString());

			while(rs.next()) {
				count = rs.getInt("count");
				
                }
			
		} catch (Exception e) {   
			e.printStackTrace();
		}

		return count;
	}

	@Override
	public void update(Map<?, ?>param) {
		System.out.println("==DAO UPDATE==");
		Map<?, ?> map = new HashMap<>();
		
		try {
			DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.UPDATE.toString()
					
				/*	member.getPassword(),
					member.getRoll(),
					member.getTeamId(),
					member.getId()*/
					));
			System.out.println("==DAO UPDATE SUCCESS==");
		} catch (Exception e) {   
			e.printStackTrace();
		}
	}

	@Override
	public void delete(MemberBean member) {

		MemberBean m =null;
		
		try {
			 DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(MemberQuery.DELETE.toString(),        
		              member.getId(),member.getPassword()));
				
	
                
			
		} catch (Exception e) {   
			e.printStackTrace();
		}

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
                m.setId(rs.getString("ID"));
                m.setName(rs.getString("NAME"));
                m.setTeamId(rs.getString("TEAMID"));                  
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

	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		

			QueryTemplate q = new PstmtQuery();
			List<MemberBean> list = new ArrayList<>();
			HashMap<String, Object> map  = new HashMap<>();
			String beginRow = (String) param.get("beginRow");
			String endRow = (String) param.get("endRow");
			String sql= MemberQuery.SEARCH.toString();     
			map.put("sql", sql);
			q.play(map);

			
			for(Object s : q.getList()) {
				list.add((MemberBean) s);
			}
			
		return list;
		
	}

		
		
		/*MemberBean m = new MemberBean();
		List<MemberBean> selectList = new ArrayList<>();
		String beginRow = (String) param.get("beginRow");
		String endRow = (String) param.get("endRow");
		System.out.println("====시작행====="+beginRow);
		System.out.println("====끝행====="+endRow);
		try {
			ResultSet rs =  DatabaseFactory.createDatabase(
					Vendor.ORACLE, DBConstant.USERNAME, DBConstant.PASSWORD)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(MemberQuery.SEARCH.toString(),        
					beginRow, endRow));

			while(rs.next()) {
				m = new MemberBean();
                m.setId(rs.getString("ID"));
                m.setName(rs.getString("NAME"));
                m.setTeamId(rs.getString("TEAMID"));                  
                m.setRoll(rs.getString("ROLL"));
                m.setPassword(rs.getString("PASSWORD"));
                m.setSsn(rs.getString("SSN"));
                m.setAge(rs.getString("AGE"));
                m.setGender(rs.getString("GENDER"));
                selectList.add(m);
            	System.out.println("dao받은값====="+m);
                }
			
		} catch (Exception e) {   
			e.printStackTrace();
		}

		return selectList;
	}*/



	
	
}