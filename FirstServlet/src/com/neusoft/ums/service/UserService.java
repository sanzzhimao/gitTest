package com.neusoft.ums.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.neusoft.ums.dao.IUserDao;
import com.neusoft.ums.dao.UserDao;
import com.neusoft.ums.entity.User;
import com.neusoft.ums.util.JdbcUtil2;


public class UserService implements IUserService {

	@Override
	public void registerUser(User stu)throws SQLException {
		
		Connection con=null;
		try{
			con=JdbcUtil2.getConnection();
			con.setAutoCommit(false);
			IUserDao userDao=new UserDao();
			userDao.setConnection(con);
			userDao.addUser(stu);
			con.commit();
		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}finally{
			JdbcUtil2.release(con,null,null);
		}
	}
	/*
	@Override
	public void UserChangeClass(User stu)throws SQLException {
		Connection con=null;
		try{
			con=JdbcUtil2.getConnection();
			con.setAutoCommit(false);
			IUserDao userDao=new UserDao();
			userDao.setConnection(con);
			userDao.updateUserClassName(stu);
			con.commit();
		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}finally{
			JdbcUtil2.release(con,null,null);
		}
	}

	@Override
	public void UserExitClass(long oid)throws SQLException {
		Connection con=null;
		try{
			con=JdbcUtil2.getConnection();
			con.setAutoCommit(false);
			IUserDao userDao=new UserDao();
			userDao.setConnection(con);
			userDao.deleteUser(oid);
			con.commit();
		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}finally{
			JdbcUtil2.release(con,null,null);
		}

	}

	@Override
	public void modifyUser(User stu) throws SQLException{
		Connection con=null;
		try{
			con=JdbcUtil2.getConnection();
			con.setAutoCommit(false);
			IUserDao userDao=new UserDao();
			userDao.setConnection(con);
			userDao.updateUser(stu);
			con.commit();
		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}finally{
			JdbcUtil2.release(con,null,null);
		}

	}

	@Override
	public User getUserByOid(long oid)throws SQLException {
		Connection con=null;
		User stu=null;
		try{
			con=JdbcUtil2.getConnection();
			con.setAutoCommit(false);
			IUserDao userDao=new UserDao();
			userDao.setConnection(con);
			stu=userDao.selectUserByOid(oid);
			con.commit();
		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}finally{
			JdbcUtil2.release(con,null,null);
		}
		return stu;
	}
	*/
	@Override
	public List<User> browseAllUsers()throws SQLException {
		List<User> users=null;
		Connection con=null;
		try{
			con=JdbcUtil2.getConnection();
			con.setAutoCommit(false);
			IUserDao userDao=new UserDao();
			userDao.setConnection(con);
			users=userDao.selectAllUser();
			con.commit();
		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}finally{
			JdbcUtil2.release(con,null,null);
		}
		return users;
	}
	@Override
	public User userLogin(String userName, String password) throws SQLException {
		Connection con=null;
		User user=null;
		try{
			con=JdbcUtil2.getConnection();
			con.setAutoCommit(false);
			IUserDao userDao=new UserDao();
			userDao.setConnection(con);
			user=userDao.selectUserByNameAndPassword(userName, password);
			con.commit();
		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}finally{
			JdbcUtil2.release(con,null,null);
		}
		return user;
	}
}
