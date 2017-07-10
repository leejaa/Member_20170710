package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberBean member;
	List<MemberBean> members;
	List<MemberBean> memberByName;

	public MemberServiceImpl() {
		member=new MemberBean();
		members=new ArrayList<>();
		memberByName=new ArrayList<>();
	} 
	@Override
	public void addMember(MemberBean member) {
		members.add(member);
	}
	@Override
	public List<MemberBean> getMembers() {
		return members;
	}
	@Override
	public int countMembers() {
		return members.size();
	}
	
	
	@Override
	public MemberBean memberById(String id) {
		member=new MemberBean();
		for(int i=0;i<members.size();i++){
			if(id.equals(members.get(i).getId())){
				member=members.get(i);
				break;
			}
		}
		return member;

	}
	@Override
	public List<MemberBean> getMemberByName(String name) {
		memberByName=new ArrayList<>();
		for(int i=0;i<members.size();i++){
			if(name.equals(members.get(i).getName())){
				memberByName.add(members.get(i));
			}
		}
		return memberByName;
	}
	@Override
	public void updataPw(MemberBean member) {
		for(int i=0;i<members.size();i++){
			if(member.getId().equals(members.get(i).getId())){
				members.get(i).setPw(member.getPw());
				break;
			}
		}	
	}
	@Override
	public void delete(String id) {
		for(int i=0;i<members.size();i++){
			if(id.equals(members.get(i).getId())){
				members.remove(i);
				break;
			}
		}
	}
	
	
}
