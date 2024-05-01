package com.ohgiraffers.gymgahomework.common;

public enum UserRole {

    USER("직원"),
    ADMIN("대표");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole(){
        return role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "role='" + role + '\'' +
                '}';
    }
}
