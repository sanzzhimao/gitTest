package com.neusoft.ums.service;

import java.sql.SQLException;
import java.util.List;
import com.neusoft.ums.entity.User;

public interface IUserService {
	//�û����
	public void registerUser(User user)throws SQLException;
	/*//ѧ��ת��
	public void studentChangeClass(Student stu)throws SQLException;
	//ѧ����ѧ,����ѧ����ѧ
	public void studentExitClass(long oid)throws SQLException;
	//ѧ������
	public void modifyStudent(Student stu)throws SQLException;
	//����ѧ�Ų�ѯĳ��ѧ��
	public Student getStudentByOid(long oid)throws SQLException;
	
	*/
	//��ѯ�����û�
	public List<User> browseAllUsers()throws SQLException;
	//�û���¼
	public User userLogin(String userName,String password)throws SQLException;
	
}
