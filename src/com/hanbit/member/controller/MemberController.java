package com.hanbit.member.controller;

import javax.swing.JOptionPane;
import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;
import com.hanbit.member.serviceImpl.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args) {
		MemberBean member=null;
		MemberService service=new MemberServiceImpl();
		while(true){
			
			switch (JOptionPane.showInputDialog("0.종료 1.회원추가 2.회원수보기 3.회원목록보기 4.검색 by ID 5.검색 by NAME 6.비밀번호변경 7.회원탈퇴")) {
			case "0" :
				return;
			case "1":
				member=new MemberBean();
				String[] foo=JOptionPane.showInputDialog("ID/PW/SSN/NAME").split("/");
				member.setId(foo[0]);
				member.setPw(foo[1]);
				member.setSsn(foo[2]);
				member.setName(foo[3]);
				service.addMember(member);
				JOptionPane.showMessageDialog(null, "회원가입 성공");
				break;
			case "2":
				JOptionPane.showMessageDialog(null, service.countMembers()+"명");
				break;
			case "3":
				JOptionPane.showMessageDialog(null, service.getMembers());
				break;
			case "4":
				JOptionPane.showMessageDialog(null, service.memberById(JOptionPane.showInputDialog("검색하고자 하는 id를 입력해주세요")));
				break;
			case "5":
				JOptionPane.showMessageDialog(null, service.getMemberByName(JOptionPane.showInputDialog("검색하고자 하는 이름을 입력해주세요")));
				break;
			case "6":
				member=new MemberBean();
				member.setId(JOptionPane.showInputDialog("비번 바꾸려는 아이디를 입력해주세요"));
				member.setPw(JOptionPane.showInputDialog("새로운 비밀번호를 입력해주세요"));
				service.updataPw(member);
				JOptionPane.showMessageDialog(null, "업데이트완료");
				break;
			case "7":
				service.delete(JOptionPane.showInputDialog("탈퇴하고자 하는 아이디를 입력해주세요"));
				JOptionPane.showMessageDialog(null, "탈퇴완료");
				break;
			}
		}
	}
}
