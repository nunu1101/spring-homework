package com.willingtogohome.gymga.login.user.model.dto;

import lombok.*;



public class RegistDTO {

    private String userId;
    private String userPwd;
    private String userName;
    private String userPhone;
    private String role;

    public RegistDTO(){}

    public RegistDTO(String userId, String userPwd, String userName, String userPhone, String role) {
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userPhone = userPhone;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "RegistDTO{" +
                "userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

