package com.hanbit.member.dao;

import java.util.List;

import com.hanbit.member.domain.MemberBean;

public interface MemberDao {
	public void insert(MemberBean member);
	public List<MemberBean> selectAll();
	public int count();
	public MemberBean selectById(String id);
	public List<MemberBean> selectByName(String name);
	public void update(MemberBean member);
	public void delete(String id);
}
