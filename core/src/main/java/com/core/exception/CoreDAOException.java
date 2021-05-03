package com.core.exception;

/**
 * Exception for DAO layer
 */
public class CoreDAOException extends Exception {

    private long errorCode;

    public CoreDAOException(String msg, Throwable t) {
        super(msg, t);
    }

    public CoreDAOException(String message) {
        super(message);
    }

    public CoreDAOException(Throwable cause) {
        super(cause);
    }

    public CoreDAOException(String msg, long errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public long getErrorCode() {
        return errorCode;
    }
}
