package com.core.model;

import java.util.Objects;

/**
 * POJO for Users table
 */
public class User {

    private long userId;
    private String name;
    private String email;

    public User() {
    }

    public User(long userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email);
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
