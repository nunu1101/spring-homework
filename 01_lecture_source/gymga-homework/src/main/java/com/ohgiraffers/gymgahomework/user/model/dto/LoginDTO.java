package com.ohgiraffers.gymgahomework.user.model.dto;

import com.ohgiraffers.gymgahomework.common.UserRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginDTO {

    private Integer userCode;
    private String userId;
    private String userPwd;
    private String userName;
    private UserRole userRole;

    public LoginDTO() {
    }
    public LoginDTO(Integer userCode, String userId, String userPwd, String userName, UserRole userRole) {
        this.userCode = userCode;
        this.userId = userId;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userRole = userRole;
    }

    public List<String> getRole() {
        if (this.userRole.getRole().length() > 0) {
            return Arrays.asList(this.userRole.getRole().split(","));
        }
        return new ArrayList<>();
    }


    public Integer getUserCode() {
        return userCode;
    }

    public void setUserCode(Integer userCode) {
        this.userCode = userCode;
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "userCode=" + userCode +
                ", userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
