package com.pm.providerticket.exception;

import com.pm.providerticket.component.enmus.ExceptionEnum;

public class UserNotExistException extends RuntimeException {

    public UserNotExistException(ExceptionEnum userNotExist) {
    }
}
