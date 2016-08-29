package com.exist.model.exception;

/**
 * Created by jvillanueva on 8/29/16.
 */
public abstract class BaseException extends Exception {

    private String messageCode;
    private Object[] args;

    public BaseException(String message, String messageCode, Object[] args) {
        super(message);
        this.messageCode = messageCode;
        this.args = args;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
