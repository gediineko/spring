package com.exist.model.exception;

/**
 * Created by jvillanueva on 8/29/16.
 */
public class EntityDoesNotExistException extends Exception {

    private static final long serialVersionUID = -4202518367237468224L;

    private String messageCode;
    private Object[] args;

    public EntityDoesNotExistException(String message, String messageCode) {
        super(message);
        this.messageCode = messageCode;
    }

    public EntityDoesNotExistException(String message, String messageCode, Object[] args) {
        super(message);
        this.messageCode = messageCode;
        this.args = args;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public Object[] getArgs() {
        return args;
    }
}
