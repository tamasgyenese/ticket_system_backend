package com.core.model;

import java.util.Objects;

/**
 * POJO for UserDevice table
 */
public class UserDevice {

    private long userId;
    private String deviceHash;

    public UserDevice() {
    }

    public UserDevice(long userId, String deviceHash) {
        this.userId = userId;
        this.deviceHash = deviceHash;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDeviceHash() {
        return deviceHash;
    }

    public void setDeviceHash(String deviceHash) {
        this.deviceHash = deviceHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDevice that = (UserDevice) o;
        return userId == that.userId &&
                Objects.equals(deviceHash, that.deviceHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, deviceHash);
    }

    @Override
    public String toString() {
        return "UserDevice{" +
                "userId=" + userId +
                ", deviceHash='" + deviceHash + '\'' +
                '}';
    }
}
