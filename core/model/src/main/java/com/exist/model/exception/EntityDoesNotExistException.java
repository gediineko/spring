package com.exist.model.exception;

/**
 * Created by jvillanueva on 8/29/16.
 */
public class EntityDoesNotExistException extends BaseException {

    private static final long serialVersionUID = -4202518367237468224L;

    public EntityDoesNotExistException(String message, String messageCode, Object[] args) {
        super(message, messageCode, args);
    }
}
