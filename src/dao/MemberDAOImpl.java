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
	private HashMap<String, Object> map;

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
		HashMap<String, Object> map = new HashMap<>();
		q= new RetrieveQuery();
		map.put("userid", id);
		q.play(map);
		return q.getMem();
	
	
	}

	@Override
	public int count() {
		q = new CountQuery();
		q.play();
		return q.getNumber();
	}

	@Override
	public void update(Map<?, ?> param) {
		q = new ModifyQuery();
		
		q.play(param);
		
		//
		
	}

	@Override
	public void delete(MemberBean member) {
		q = new RemoveQuery();
		q.play();
		
	}

	@Override
	public MemberBean login(MemberBean member) {
		map = new HashMap<>();
		q = new LoginQuery();
		System.out.println("DAO로그인");
		map.put("member", member);
		q.play(map);
		return (MemberBean) q.getO();
		
		
	}

		

	
	
}