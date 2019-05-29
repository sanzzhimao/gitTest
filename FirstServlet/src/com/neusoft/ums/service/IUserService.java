package com.neusoft.ums.service;

import java.sql.SQLException;
import java.util.List;
import com.neusoft.ums.entity.User;

public interface IUserService {
	//用户添加
	public void registerUser(User user)throws SQLException;
	/*//学生转班
	public void studentChangeClass(Student stu)throws SQLException;
	//学生退学,根据学号退学
	public void studentExitClass(long oid)throws SQLException;
	//学生更新
	public void modifyStudent(Student stu)throws SQLException;
	//根据学号查询某个学生
	public Student getStudentByOid(long oid)throws SQLException;
	
	*/
	//查询所有用户
	public List<User> browseAllUsers()throws SQLException;
	//用户登录
	public User userLogin(String userName,String password)throws SQLException;
	
}
