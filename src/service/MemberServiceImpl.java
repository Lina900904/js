package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.*;
import domain.*;
import service.*;

public class MemberServiceImpl implements MemeberService {
	private static MemeberService intstance = new MemberServiceImpl();

	public static MemeberService getInstance() {
		return intstance;
	}

	private MemberServiceImpl() {
	}

	@Override
	public void add(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberBean> search(Map<?, ?> param) {
		return MemberDAOImpl.getInstance().selectSome(param);
	}

	@Override
	public MemberBean retrieve(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(Map<?, ?>param) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean login(MemberBean member) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
