package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberBean member;
	Map<String,MemberBean> members;
	Map<String,MemberBean> memberByName;
	List<MemberBean> list;

	public MemberServiceImpl() {
		member=new MemberBean();
		members=new HashMap<>();
		memberByName=new HashMap<>();
		list=new ArrayList<>();
	}
	@Override
	public void addMember(MemberBean member) {
		members.put(member.getId(), member);
	}
	@Override
	public List<MemberBean> getMembers() {
		list=new ArrayList<>();
		Set<String> keys=members.keySet();
		for(String s:keys){
			list.add(members.get(s));
		}
		return list;
	}
	@Override
	public int countMembers() {
		return members.size();
	}
	@Override
	public MemberBean memberById(String id) {
		member=new MemberBean();
		member=members.get(id);
		return member;
	}
	@Override
	public List<MemberBean> getMemberByName(String name) {
		list=new ArrayList<>();
		List<MemberBean> temp=new ArrayList<>();
		Set<String> keys=members.keySet();
		for(String s:keys){
			temp.add(members.get(s));
		}
		for(MemberBean m:temp){
			if(name.equals(m.getName())){
				list.add(m);
			}
		}
		return list;
	}
	@Override
	public void update(MemberBean param) {
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
		members.remove(member);
		members.put(param.getId(), param);
	}
	@Override
	public void delete(String id) {
		members.remove(id);
	}
	
	
}
