/**
 * @program: javaweb_study
 * * @description:
 * * @author:cro
 * * @create: 2019-05-15 15:42
 **/

package ums.service;

import ums.dao.IUserDao;
import ums.dao.UserDao;
import ums.entity.User;
import ums.util.JdbcUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService {
    @Override
    public void registerUser(User user)throws SQLException {

        Connection con=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserDao userDao=new UserDao();
            userDao.setConnection(con);
            userDao.addUser(user);
            con.commit();
        }catch(SQLException e){
            con.rollback();
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }finally{
            JdbcUtil.release(con,null,null);
        }
    }

    @Override
    public List<User> broseAllUsers() throws SQLException {
        List<User> users=null;
        Connection con=null;
        try{
            con= JdbcUtil.getConnection();
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
            JdbcUtil.release(con,null,null);
        }
        return users;
    }

    @Override
    public List<User> brosepageUsers(int page,int pagesize) throws SQLException {
        List<User> users=null;
        Connection con=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserDao userDao=new UserDao();
            userDao.setConnection(con);
            users=userDao.selectPageUsers(page,pagesize);
            con.commit();
        }catch(SQLException e){
            con.rollback();
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }finally{
            JdbcUtil.release(con,null,null);
        }
        return users;

    }

    @Override
    public User userLogin(String userName, String password) throws SQLException {
        User user=null;
        Connection con=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserDao userDao=new UserDao();
            userDao.setConnection(con);
            user=userDao.selectUser(userName,password);
            con.commit();
        }catch(SQLException e){
            con.rollback();
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }finally{
            JdbcUtil.release(con,null,null);
        }
        return user;
    }

    @Override
    public User checkUserName(String userName) throws SQLException {
        User user=null;
        Connection con=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserDao userDao=new UserDao();
            userDao.setConnection(con);
            user=userDao.selectUserByName(userName);
            con.commit();
        }catch(SQLException e){
            con.rollback();
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }finally{
            JdbcUtil.release(con,null,null);
        }
        return user;
    }

    @Override
    public List<User> findProperUser(User user) throws SQLException {
        List<User> users=null;
        Connection con=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserDao userDao=new UserDao();
            userDao.setConnection(con);
            users=userDao.selectUsers(user);
            con.commit();
        }catch(SQLException e){
            con.rollback();
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }finally{
            JdbcUtil.release(con,null,null);
        }
        return users;
    }

    @Override
    public int getPageNum(int pagesize) throws SQLException {
        int pageNum=0;
        Connection con=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserDao userDao=new UserDao();
            userDao.setConnection(con);
            pageNum=userDao.getTotalPage(pagesize);
            con.commit();
        }catch(SQLException e){
            con.rollback();
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }finally{
            JdbcUtil.release(con,null,null);
        }
        return pageNum;
    }

    @Override
    public void delUsers(String[] userNames) throws SQLException {
        Connection con=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserDao userDao=new UserDao();
            userDao.setConnection(con);
            userDao.delUsers(userNames);
            con.commit();
        }catch(SQLException e){
            con.rollback();
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }finally{
            JdbcUtil.release(con,null,null);
        }
    }

    /** 分页查询组合查询用户
     * @param user
     * @param page
     * @param pagesize
     * @return
     * @throws SQLException
     */
    @Override
    public List<User> broseProperUsers(User user,int page, int pagesize) throws SQLException {
        List<User> users=null;
        Connection con=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserDao userDao=new UserDao();
            userDao.setConnection(con);
            users=userDao.pageSelectUsers(user,page,pagesize);
            con.commit();
        }catch(SQLException e){
            con.rollback();
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }finally{
            JdbcUtil.release(con,null,null);
        }
        return users;
    }

    /** 组合查询分页总页数
     * @param user
     * @param pagesize
     * @return
     */
    @Override
    public int getSelectPageNum(User user, int pagesize) throws SQLException {
        int pageNum=0;
        Connection con=null;
        try{
            con= JdbcUtil.getConnection();
            con.setAutoCommit(false);
            IUserDao userDao=new UserDao();
            userDao.setConnection(con);
            pageNum=userDao.getTotalSelectPage(user,pagesize);
            con.commit();
        }catch(SQLException e){
            con.rollback();
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }finally{
            JdbcUtil.release(con,null,null);
        }
        return pageNum;
    }
}
