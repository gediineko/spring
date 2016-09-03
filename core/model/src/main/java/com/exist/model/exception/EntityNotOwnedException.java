package com.exist.model.exception;


public class EntityNotOwnedException extends BaseException {


    private static final long serialVersionUID = -3076132489711713238L;

    public EntityNotOwnedException(String message, String messageCode, Object[] args) {
        super(message, messageCode, args);
    }
}
