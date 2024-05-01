package com.ohgiraffers.gymgahomework.common;

public enum UserId {

    USER_ID("USER_ID");

    private String userId;

    UserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "UserId{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
