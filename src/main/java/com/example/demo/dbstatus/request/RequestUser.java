package com.example.demo.dbstatus.request;

/**
 * description: RequestUser
 * date: 4/23/21 5:53 PM
 * author: fourwood
 */
public class RequestUser {
    public RequestUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public RequestUser() {
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

    private String userName;
    private String password;

}
