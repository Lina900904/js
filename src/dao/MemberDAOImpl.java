package dao;

import java.sql.*;

import java.util.*;


import domain.*;
import enums.*;
import factory.*;

import oracle.jdbc.driver.DBConversion;
import pool.*;
import templates.*;


public class MemberDAOImpl implements MemberDAO {
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {};
	private QueryTemplate q;


	@Override
	public List<MemberBean> selectSome(Map<?, ?> param) {
		
		q = new SearchQuery();
		List<MemberBean> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		String beginRow = (String) param.get("beginRow");
		String endRow = (String) param.get("endRow");
		map.put("beginRow", beginRow);
		map.put("endRow", endRow);
		q.play(map);
		System.out.println("======시작행====: "+beginRow);
		System.out.println("======마지막행====: "+endRow);
		for(Object o : q.getList()){
			list.add((MemberBean)o);
		}
		System.out.println("리스트=======" + list);
		return list;
		
	}

	@Override
	public void insert(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberBean selectOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		q = new CountQuery();
		q.play();
		return q.getNumber();
	}

	@Override
	public void update(Map<?, ?> param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberBean login(MemberBean member) {
		q = new LoginQuery();
		q.play(member);
		
		return  ;
	}

		

	
	
}