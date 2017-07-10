package com.hanbit.member.service;
import java.util.List;
import java.util.Map;

import com.hanbit.member.domain.MemberBean;

public interface MemberService {
	public void addMember(MemberBean member);
	public List<MemberBean> getMembers();
	public int countMembers();
	public MemberBean memberById(String id);
	public List<MemberBean> getMemberByName(String name);
	public void update(MemberBean member);
	public void delete(String id);
}
