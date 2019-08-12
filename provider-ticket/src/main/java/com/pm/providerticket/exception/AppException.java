package com.pm.providerticket.exception;

import com.pm.providerticket.component.enmus.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Yu
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AppException extends RuntimeException{

    private ExceptionEnum exceptionEnum;
}
