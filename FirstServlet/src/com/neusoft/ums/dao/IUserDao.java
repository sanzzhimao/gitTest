package com.neusoft.ums.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.neusoft.ums.entity.User;

public interface IUserDao {
	public void setConnection(Connection con);
	//增加用户
	void addUser(User user)throws SQLException;
	/*//删除学生,根据学号id删除
	void deleteStudent(long oid)throws SQLException;
	//更新学生班级信息
	void updateStudentClassName(User user)throws SQLException;
	//更新学生
	void updateStudent(User user)throws SQLException;
	//查询单个学生
	User selectStudentByOid(long oid)throws SQLException;
	*/
	//查询所有用户
	List<User> selectAllUser()throws SQLException;
	//根据用户名和密码查询
	public User selectUserByNameAndPassword(String userName,String userPass)throws SQLException;
	
}
