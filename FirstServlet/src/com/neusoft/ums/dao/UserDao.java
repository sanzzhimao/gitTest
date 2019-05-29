package com.neusoft.ums.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.neusoft.ums.entity.User;
import com.neusoft.ums.util.JdbcUtil2;

public class UserDao implements IUserDao {
	Connection con=null;
	public void setConnection(Connection con){
		this.con=con;
	}
	@Override
	public void addUser(User user)throws SQLException {
//		Connection con=null;
//		con=JdbcUtil2.getConnection();
		String sql="insert into t_user(username,userpass,birthday,hobbies) values(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,user.getUserName());
		pstmt.setString(2, user.getUserPass());
		long times=user.getBirthday().getTime();
		Date date1=new Date(times);
		pstmt.setDate(3, date1);
		pstmt.setString(4, user.getHobbies());
		int i=pstmt.executeUpdate();
		JdbcUtil2.release(null, pstmt, null);
	}
	/*
	@Override
	public void deleteStudent(long oid) throws SQLException{
		String sql="delete from \"wj_student\" where \"oid\"=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setLong(1,oid);
		int i=pstmt.executeUpdate();
		JdbcUtil2.release(null, pstmt, null);
	}

	@Override
	public void updateStudentClassName(Student stu)throws SQLException {
		String sql="update \"wj_student\" set \"className\"=? where \"oid\"=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,stu.getClassName());
		pstmt.setLong(2,stu.getOid());
		int i=pstmt.executeUpdate();
		JdbcUtil2.release(null, pstmt, null);
	}

	@Override
	public void updateStudent(Student stu)throws SQLException {
		String sql="update \"wj_student\" set \"name\"=?,set \"birthday\"=?,set \"className\"=? where \"oid\"=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1,stu.getName());
		Date date1=new Date(stu.getBirthday().getTime());
		pstmt.setDate(2,date1);
		pstmt.setString(3,stu.getClassName());
		pstmt.setLong(4,stu.getOid());
		int i=pstmt.executeUpdate();
		JdbcUtil2.release(null, pstmt, null);
	}

	@Override
	public Student selectStudentByOid(long oid) throws SQLException{
		String sql="select * from \"wj_student\" where \"oid\"=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setLong(1,oid);
		ResultSet rs=pstmt.executeQuery();
		Student stu=null;
		while(rs.next()){
			stu=new Student();
			stu.setOid(rs.getInt(1));
			stu.setName(rs.getString(2));
			stu.setBirthday(rs.getDate(3));
			stu.setClassName(rs.getString(4));
		}
		JdbcUtil2.release(null, pstmt,rs);
		return stu;
	}
*/
	@Override
	public List<User> selectAllUser()throws SQLException {
		String sql="select * from t_user";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		List<User> users=new ArrayList<>();
		User user=null;
		while(rs.next()){
			user=new User();
			user.setId(rs.getLong(1));
			user.setUserName(rs.getString(2));
			user.setUserPass(rs.getString(3));
			user.setBirthday(rs.getDate(4));
			user.setHobbies(rs.getString(5));
			users.add(user);
		}
		JdbcUtil2.release(null, pstmt,rs);
		return users;
	}
	@Override
	public User selectUserByNameAndPassword(String userName, String userPass) throws SQLException {
		String sql="select * from t_user where username=? and userpass=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, userName);
		pstmt.setString(2, userPass);
		ResultSet rs=pstmt.executeQuery();
		User user=null;
		while(rs.next()){
			user=new User();
			user.setId(rs.getLong(1));
			user.setUserName(rs.getString(2));
			user.setUserPass(rs.getString(3));
			user.setBirthday(rs.getDate(4));
			user.setHobbies(rs.getString(5));
		}
		JdbcUtil2.release(null, pstmt,rs);
		return user;
	}
}
