package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanbit.member.dao.MemberDao;
import com.hanbit.member.daoImpl.MemberDaoImpl;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberBean member;
	Map<String,MemberBean> members;
	Map<String,MemberBean> memberByName;
	List<MemberBean> list;
	MemberDao dao;
	public MemberServiceImpl() {
		member=new MemberBean();
		members=new HashMap<>();
		memberByName=new HashMap<>();
		list=new ArrayList<>();
		dao=new MemberDaoImpl();
	}
	@Override
	public void addMember(MemberBean member) {
		dao.insert(member);
	}
	@Override
	public List<MemberBean> getMembers() {
		list=new ArrayList<>();
		list=dao.selectAll();
		return list;
	}
	@Override
	public int countMembers() {
		MemberDao dao=new MemberDaoImpl();
		int count=0;
		count=dao.count();
		return count;
	}
	@Override
	public MemberBean memberById(String id) {
		MemberDao dao=new MemberDaoImpl();
		MemberBean member=dao.selectById(id);
		return member;
	}
	@Override
	public List<MemberBean> getMemberByName(String name) {
		list=new ArrayList<>();
		list=dao.selectByName(name);
		return list;
	}
	@Override
	public void modify(MemberBean param) {
		member=new MemberBean();
		member=members.get(param.getId());
		if(param.getName().equals("")){
			param.setName(member.getName());
		}
		if(param.getPw().equals("")){
			param.setPw(member.getPw());
		}
		if(param.getSsn().equals("")){
			param.setSsn(member.getSsn());
		}
		dao.update(param);
	}
	@Override
	public void remove(String id) {
		dao.delete(id);
	}
	
	
}
