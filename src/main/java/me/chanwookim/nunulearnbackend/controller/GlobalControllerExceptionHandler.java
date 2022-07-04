package me.chanwookim.nunulearnbackend.controller;

import me.chanwookim.nunulearnbackend.exception.TagNameDuplicateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class GlobalControllerExceptionHandler {
    @ExceptionHandler(TagNameDuplicateException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Tag name Duplicate, try again")  // 409
    @ResponseBody
    public void handleConflict() {

    }
}
