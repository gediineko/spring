package com.exist.model.exception;

/**
 * Created by jvillanueva on 8/29/16.
 */
public class InvalidFileTypeException extends BaseException {

    private static final long serialVersionUID = -5889396907316870353L;

    public InvalidFileTypeException(String message, String messageCode, Object[] args) {
        super(message, messageCode, args);
    }
}
