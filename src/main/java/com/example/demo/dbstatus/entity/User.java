package com.example.demo.dbstatus.entity;

import com.example.demo.dbstatus.request.RequestUser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * description: User
 * date: 4/23/21 4:54 PM
 * author: fourwood
 */
@Entity
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

    private String userName;
    private String password;

    public boolean checkUser(String userName, String passwd) {
        return getUserName().equals(userName) && getPassword().equals(passwd);
    }

    public boolean checkUser(RequestUser requestUser) {
        return getUserName().equals(requestUser.getUserName()) && getPassword().equals(requestUser.getPassword());
    }
}
