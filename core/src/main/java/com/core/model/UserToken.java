package com.core.model;

import java.util.Objects;

/**
 * POJO for UserToken table
 */
public class UserToken {

    private long userId;
    private String token;

    public UserToken() {
    }

    public UserToken(long userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserToken userToken = (UserToken) o;
        return userId == userToken.userId &&
                Objects.equals(token, userToken.token);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, token);
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                '}';
    }
}
