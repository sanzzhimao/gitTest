package com.neusoft.ums.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.neusoft.ums.entity.User;

public interface IUserDao {
	public void setConnection(Connection con);
	//�����û�
	void addUser(User user)throws SQLException;
	/*//ɾ��ѧ��,����ѧ��idɾ��
	void deleteStudent(long oid)throws SQLException;
	//����ѧ���༶��Ϣ
	void updateStudentClassName(User user)throws SQLException;
	//����ѧ��
	void updateStudent(User user)throws SQLException;
	//��ѯ����ѧ��
	User selectStudentByOid(long oid)throws SQLException;
	*/
	//��ѯ�����û�
	List<User> selectAllUser()throws SQLException;
	//�����û����������ѯ
	public User selectUserByNameAndPassword(String userName,String userPass)throws SQLException;
	
}
