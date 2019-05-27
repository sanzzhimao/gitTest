/**
 * @program: javaweb_study
 * * @description:
 * * @author:cro
 * * @create: 2019-05-15 15:42
 **/

package ums.service;

import ums.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    /**学生注册*/
    void registerUser(User user)throws SQLException;

    List<User> broseAllUsers() throws SQLException;

    /**分页查询所有用户
     * @return
     * @throws SQLException
     */
    List<User> brosepageUsers(int page,int pagesize) throws SQLException;

    User userLogin(String userName,String password) throws SQLException;
    User checkUserName(String userName) throws SQLException;

    /** 组合查询用户
     * @param user
     * @return
     */
    List<User> findProperUser(User user) throws SQLException;

    /** 获取查询所有用户时的总页数
     * @param pagesize
     * @return
     * @throws SQLException
     */
    int getPageNum(int pagesize) throws SQLException;

    /** 删除用户
     * @param userNames
     * @throws SQLException
     */
    void delUsers(String[] userNames) throws SQLException;

    /** 分页查询组合条件查询用户
     * @param page
     * @param pagesize
     * @return
     * @throws SQLException
     */
    List<User> broseProperUsers(User user,int page,int pagesize) throws SQLException;

    /** 组合查询分页总页数
     * @param user
     * @param pagesize
     * @return
     */
    int getSelectPageNum(User user,int pagesize) throws SQLException;

}
