package com.neusoft.ums.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private long id;
	private String userName;
	private String userPass;
	private Date birthday;
	private String Hobbies;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String userPass, Date birthday,String hobbies) {
		super();
		this.userName = userName;
		this.userPass = userPass;
		this.birthday = birthday;
		this.Hobbies=hobbies;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getHobbies() {
		return Hobbies;
	}
	public void setHobbies(String hobbies) {
		Hobbies = hobbies;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPass=" + userPass + ", birthday=" + birthday + "]";
	}
}
