package com.example.demo.dbstatus.entity;

import com.example.demo.dbstatus.request.RequestUser;

import javax.persistence.*;

/**
 * description: User
 * date: 4/23/21 4:54 PM
 * author: fourwood
 */
@Entity
@Table(name = "user")
public class User {
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;

    public boolean checkUser(String userName, String passwd) {
        return getUserName().equals(userName) && getPassword().equals(passwd);
    }

    public boolean checkUser(RequestUser requestUser) {
        return getUserName().equals(requestUser.getUserName()) && getPassword().equals(requestUser.getPassword());
    }
}
