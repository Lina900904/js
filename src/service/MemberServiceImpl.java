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
		
		return MemberDAOImpl.getInstance().selectOne(id);
	}

	@Override
	public void modify(Map<?, ?>param) {
		MemberDAOImpl.getInstance().update(param);
		
	}

	@Override
	public void remove(MemberBean member) {
			MemberDAOImpl.getInstance().delete(member);
		
	}

	@Override
	public int count() {
		return MemberDAOImpl.getInstance().count();
	}

	@Override
	public boolean login(MemberBean member) {
		
		return MemberDAOImpl.getInstance().login(member)!=null;
	}

	
}
