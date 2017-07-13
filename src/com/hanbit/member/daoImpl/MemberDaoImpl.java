package com.hanbit.member.daoImpl;

import java.util.ArrayList;
import java.util.List;

import com.hanbit.member.constants.Database;
import com.hanbit.member.dao.MemberDao;
import com.hanbit.member.domain.MemberBean;
import java.sql.*;
public class MemberDaoImpl implements MemberDao{
	
	@Override
	public void insert(MemberBean member) {
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="INSERT INTO MEMBER VALUES ('"+member.getId()+"','"+member.getName()+"','"+member.getPw()+"','"+member.getSsn()+"',SYSDATE)";
			int rs=stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list=new ArrayList<>();
		MemberBean member=null;
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="SELECT * FROM MEMBER";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				member=new MemberBean();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPw(rs.getString("password"));
				member.setRegdate(rs.getString("regdate"));
				member.setSsn(rs.getString("ssn"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int count() {
		int count=0;
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="SELECT COUNT(*) AS COUNT FROM MEMBER";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				count=Integer.parseInt(rs.getString("count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member=new MemberBean();
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="SELECT * FROM Member WHERE id='"+id+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("password"));
				member.setSsn(rs.getString("ssn"));
				member.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> list=new ArrayList<>();
		MemberBean member=new MemberBean();
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="SELECT * FROM MEMBER WHERE NAME='"+name+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPw(rs.getString("password"));
				member.setSsn(rs.getString("ssn"));
				member.setRegdate(rs.getString("regdate"));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void update(MemberBean member) {
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="UPDATE MEMBER SET NAME='"+member.getName()+"',PASSWORD='"+member.getPw()+"',SSN='"+member.getSsn()+"' WHERE ID='"+member.getId()+"'";
			int rs=stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		try {
			Class.forName(Database.DRIVER);
			Connection conn=DriverManager.getConnection(Database.URL,Database.USERID,Database.PASSWORD);
			Statement stmt=conn.createStatement();
			String sql="DELETE MEMBER WHERE ID='"+id+"'";
			int rs=stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
