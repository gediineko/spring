package com.exist.web.advice;

import com.exist.model.exception.EntityDoesNotExistException;
import com.exist.model.exception.InvalidFileTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(annotations = Controller.class)
public class ExceptionAdvice {

    private static final String DEFAULT_ERROR_PAGE = "error";

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String accessDeniedException(AccessDeniedException e, Model model) {
        model.addAttribute("message", messageSource.getMessage("error.accessDenied", null, LocaleContextHolder.getLocale()));
        return DEFAULT_ERROR_PAGE;
    }

    @ExceptionHandler(EntityDoesNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String entityDoesNotExist(EntityDoesNotExistException e, Model model) {
        model.addAttribute("message", messageSource.getMessage(e.getMessageCode(), e.getArgs(), LocaleContextHolder.getLocale()));
        return DEFAULT_ERROR_PAGE;
    }

    @ExceptionHandler(InvalidFileTypeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String invalidFileType(InvalidFileTypeException e, Model model) {
        model.addAttribute("message", messageSource.getMessage(e.getMessageCode(), e.getArgs(), LocaleContextHolder.getLocale()));
        return DEFAULT_ERROR_PAGE;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String catchAllException(Exception e, Model model) {
        model.addAttribute("message", e.getMessage());
        e.printStackTrace();
        return DEFAULT_ERROR_PAGE;
    }
}
