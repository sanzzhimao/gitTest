/**
 * @program: javaweb_study
 * * @description: user dao
 * * @author:cro
 * * @create: 2019-05-15 15:36
 **/

package ums.dao;

import ums.entity.User;
import ums.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements IUserDao{
    Connection con=null;
    @Override
    public void setConnection(Connection con) {
        this.con=con;
    }

    @Override
    public void addUser(User user)throws SQLException {
        String sql="insert into web_user(username,userpass,birthday,hobbies,pic) values(?,?,?,?,?)";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,user.getUserName());
        pstmt.setString(2, user.getUserPass());
        long times=user.getBirthday().getTime();
        Date date1=new Date(times);
        pstmt.setDate(3, date1);
        pstmt.setString(4, user.getHobbies());
        pstmt.setString(5,user.getPic());
        int i=pstmt.executeUpdate();
        JdbcUtil.release(null, pstmt, null);
    }

    @Override
    public List<User> selectAllUser() throws SQLException {
        String sql="select * from web_user";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        List<User> users=new ArrayList<>();
        User user=null;
        while (rs.next()){
            user=new User();
            user.setId(rs.getLong(1));
            user.setUserName(rs.getString(2));
            user.setUserPass(rs.getString(3));
            user.setBirthday(rs.getDate(4));
            user.setHobbies(rs.getString(5));
            user.setPic(rs.getString(6));
            users.add(user);
        }
        JdbcUtil.release(null, pstmt, null);
        return users;
    }

    @Override
    public User selectUser(String userName, String userpass) throws SQLException {
        String sql="select * from web_user where username=? and userpass=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,userName);
        pstmt.setString(2,userpass);
        ResultSet rs=pstmt.executeQuery();
        User user=null;
        while (rs.next()){
            user=new User();
            user.setId(rs.getLong(1));
            user.setUserName(rs.getString(2));
            user.setUserPass(rs.getString(3));
            user.setBirthday(rs.getDate(4));
            user.setHobbies(rs.getString(5));

        }
        JdbcUtil.release(null, pstmt, null);
        return user;
    }

    @Override
    public User selectUserByName(String userName) throws SQLException {
        String sql="select * from web_user where username=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,userName);
        ResultSet rs=pstmt.executeQuery();
        User user=null;
        while (rs.next()){
            user=new User();
            user.setId(rs.getLong(1));
            user.setUserName(rs.getString(2));
            user.setUserPass(rs.getString(3));
            user.setBirthday(rs.getDate(4));
            user.setHobbies(rs.getString(5));
        }
        JdbcUtil.release(null, pstmt, null);
        return user;
    }

    @Override
    public List<User> selectUsers(User user) throws SQLException {
        String sql="select * from web_user where 1=1";
        if (user.getUserName()!=null && user.getUserName().length()!=0){
            sql+=" and username='"+user.getUserName()+"'";
        }
        if (user.getBirthday()!=null){
            sql+=" and birthday="+user.getBirthday();
        }
        if (user.getHobbies()!=null && user.getHobbies().length()!=0){
            sql+=" and hobbies like '%"+user.getHobbies()+"%'";
        }
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        user=null;
        List<User> users=new ArrayList<>();
        while (rs.next()){
            user=new User();
            user.setId(rs.getLong(1));
            user.setUserName(rs.getString(2));
            user.setUserPass(rs.getString(3));
            user.setBirthday(rs.getDate(4));
            user.setHobbies(rs.getString(5));
            users.add(user);
        }
        JdbcUtil.release(null, pstmt, null);
        return users;

    }

    /** 查询分页数据
     * @param page
     * @param pagesize
     * @return
     * @throws SQLException
     */
    @Override
    public List<User> selectPageUsers(int page,int pagesize) throws SQLException {
        int start=(page-1)*pagesize;
        String sql="select * from web_user limit ?,?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,start);
        pstmt.setInt(2,pagesize);
        ResultSet rs=pstmt.executeQuery();
        List<User> users=new ArrayList<>();
        User user=null;
        while (rs.next()){
            user=new User();
            user.setId(rs.getLong(1));
            user.setUserName(rs.getString(2));
            user.setUserPass(rs.getString(3));
            user.setBirthday(rs.getDate(4));
            user.setHobbies(rs.getString(5));
            user.setPic(rs.getString(6));
            users.add(user);
        }
        JdbcUtil.release(null, pstmt, null);
        return users;
    }

    @Override
    public int getTotalPage(int pagesize) throws SQLException {
        String sql="select count(*) from web_user";
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        int rows=0;
        int pagenum=0;
        while (rs.next()){
            rows=rs.getInt(1);
        }
        if (rows%pagesize==0){
            pagenum=rows/pagesize;
        }else{
            pagenum=rows/pagesize+1;
        }

        JdbcUtil.release(null, pstmt, null);
        return pagenum;
    }

    @Override
    public void delUsers(String[] userNames) throws SQLException {
        String sql="delete form web_user where username=?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        for (int i=0;i<userNames.length;i++){
            pstmt.setString(1,userNames[i]);
            pstmt.addBatch();
            if (i%10==0){
                pstmt.executeBatch();
            }

        }
        pstmt.executeBatch();
        JdbcUtil.release(null, pstmt, null);
    }

    /** 分页组合查询结果
     * @param user
     * @param page
     * @param pagesize
     * @return
     * @throws SQLException
     */
    @Override
    public List<User> pageSelectUsers(User user,int page,int pagesize) throws SQLException {
        String sql="select * from web_user where 1=1";
        if (user.getUserName()!=null && user.getUserName().length()!=0){
            sql+=" and username='"+user.getUserName()+"'";
        }
        if (user.getBirthday()!=null){
            sql+=" and birthday="+user.getBirthday();
        }
        if (user.getHobbies()!=null && user.getHobbies().length()!=0){
            sql+=" and hobbies like '%"+user.getHobbies()+"%'";
        }
        sql+=" limit "+page+","+pagesize;
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        user=null;
        List<User> users=new ArrayList<>();
        while (rs.next()){
            user=new User();
            user.setId(rs.getLong(1));
            user.setUserName(rs.getString(2));
            user.setUserPass(rs.getString(3));
            user.setBirthday(rs.getDate(4));
            user.setHobbies(rs.getString(5));
            users.add(user);
        }
        JdbcUtil.release(null, pstmt, null);
        return users;
    }

    /** 分页查询总页数
     * @param user
     * @param pagesize
     * @return
     */
    @Override
    public int getTotalSelectPage(User user, int pagesize) throws SQLException {
        String sql="select count(*) from web_user where 1=1";
        if (user.getUserName()!=null && user.getUserName().length()!=0){
            sql+=" and username='"+user.getUserName()+"'";
        }
        if (user.getBirthday()!=null){
            sql+=" and birthday="+user.getBirthday();
        }
        if (user.getHobbies()!=null && user.getHobbies().length()!=0){
            sql+=" and hobbies like '%"+user.getHobbies()+"%'";
        }
        PreparedStatement pstmt=con.prepareStatement(sql);
        ResultSet rs=pstmt.executeQuery();
        int rows=0;
        int pagenum=0;
        while (rs.next()){
            rows=rs.getInt(1);
        }
        if (rows%pagesize==0){
            pagenum=rows/pagesize;
        }else{
            pagenum=rows/pagesize+1;
        }
        JdbcUtil.release(null, pstmt, null);
        return pagenum;
    }
}
