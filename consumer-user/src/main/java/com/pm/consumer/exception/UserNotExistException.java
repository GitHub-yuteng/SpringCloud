package com.pm.consumer.exception;

import com.pm.consumer.component.enmus.ExceptionEnum;

public class UserNotExistException extends RuntimeException {

    public UserNotExistException(ExceptionEnum exceptionEnum) {
        super("用户不存在");
    }
}
