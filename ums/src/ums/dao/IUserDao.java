/**
 * @program: javaweb_study
 * * @description: 用户 dao层
 * * @author:cro
 * * @create: 2019-05-15 15:23
 **/

package ums.dao;

import ums.entity.User;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    /** 与数据库建立连接
     * @param con 连接
     */
    void setConnection(Connection con);

    /** 添加用户
     * @param user user对象
     * @throws SQLException 数据库异常
     */
    void addUser(User user)throws SQLException;

    /**
     * 查询所有用户
     */
    List<User> selectAllUser() throws SQLException;

    /** 根据用户名、密码查询一个用户
     * @param userName 姓名
     * @param userpass 密码
     * @return User 用户
     */
    User selectUser(String userName,String userpass) throws SQLException;

    /** 根据用户名查询一个用户
     * @param userName 用户名
     * @return user对象
     * @throws SQLException
     */
    User selectUserByName(String userName) throws SQLException;

    /** 组合查询信息
     * @return
     */
    List<User> selectUsers(User user) throws SQLException;

    /** 分页查询所有用户
     * @return
     */
    List<User> selectPageUsers(int page,int pagesize) throws SQLException;

    /** 获取所有页数
     * @param pagesize
     * @return
     * @throws SQLException
     */
    int getTotalPage(int pagesize) throws SQLException;

    /** 删除用户
     * @param userNames
     * @throws SQLException
     */
    void delUsers(String[] userNames) throws SQLException;

    /** 组合查询分页
     * @param user
     * @return
     * @throws SQLException
     */
    List<User> pageSelectUsers(User user,int page,int pagesize) throws SQLException;

    /** 获取
     * @return
     */
    int getTotalSelectPage(User user,int pagesize) throws SQLException;
}
