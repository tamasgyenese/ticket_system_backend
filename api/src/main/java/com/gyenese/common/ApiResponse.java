package com.gyenese.common;


import java.io.Serializable;
import java.util.Objects;

public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 324234234234211L;

    private T data;
    private boolean success;

    public ApiResponse() {
    }

    public ApiResponse(T data, boolean success) {
        this.data = data;
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiResponse<?> that = (ApiResponse<?>) o;
        return success == that.success &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, success);
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "data=" + data +
                ", success=" + success +
                '}';
    }
}
