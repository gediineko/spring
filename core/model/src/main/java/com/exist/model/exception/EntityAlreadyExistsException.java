package com.exist.model.exception;

/**
 * Created by ggolong on 8/29/16.
 */
public class EntityAlreadyExistsException extends BaseException {

    private static final long serialVersionUID = -4202518367237468224L;

    public EntityAlreadyExistsException(String message, String messageCode, Object[] args) {
        super(message, messageCode, args);
    }
}
