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
	public void membercreateJoin(MemberBean member) {

		MemberDAOImpl.getInstance().insertMember(member);

	}

	@Override
	public List<MemberBean> memberList() {
		return MemberDAOImpl.getInstance().selectMemberList();
	}

	@Override
	public List<MemberBean> memberfindByName(String name) {
		return MemberDAOImpl.getInstance().selectMemberSome(name);
	}

	@Override
	public MemberBean memberfindById(String id) {

		return MemberDAOImpl.getInstance().selectMemberOne(id);
	}

	@Override
	public void memberUpdate(MemberBean member) {
		MemberDAOImpl.getInstance().updateMember(member);

	}

	@Override
	public void memberDelete(MemberBean member) {
		MemberDAOImpl.getInstance().deleteMember(member);
		
	}

	@Override
	public int memberCount() {
		// TODO Auto-generated method stub
		return (MemberDAOImpl.getInstance().countMember());
	}

	@Override
	public boolean login(MemberBean member) {
		return (MemberDAOImpl.getInstance().login(member)!=null);
		
	}

	@Override
	public List<MemberBean> getList(Map<?, ?> param) {
		return MemberDAOImpl.getInstance().selectList(param);
	}


}
