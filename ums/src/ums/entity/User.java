/**
 * @program: javaweb_study
 * * @description: user实体
 * * @author:cro
 * * @create: 2019-05-15 15:33
 **/

package ums.entity;

import java.util.Date;

public class User {
    private long id;
    private String userName;
    private String userPass;
    private Date birthday;
    private String hobbies;
    private String pic;


    public User() {
    }

    public User(String userName, String userPass, Date birthday, String hobbies) {
        this.userName = userName;
        this.userPass = userPass;
        this.birthday = birthday;
        this.hobbies = hobbies;
    }
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
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
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", birthday=" + birthday +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }
}
