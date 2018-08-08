package service;

import java.util.List;
import java.util.Map;

import domain.ExamBean;
import domain.MemberBean;

public interface MemeberService {
	public void create(MemberBean member);
	public List<MemberBean> search(Map<?, ?>param);
	public MemberBean retrieve(String id);
	public void modify(Map<?, ?>param);
	public void remove(MemberBean member);
	public int count();
	public boolean login(MemberBean member);


}
