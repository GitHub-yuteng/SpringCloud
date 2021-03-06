package com.pm.providerticket.component.vo;

import com.pm.providerticket.component.enmus.ExceptionEnum;
import lombok.Data;

/**
 * @author Yu
 */

@Data
public class ExceptionResult {

    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum em) {
        this.status = em.getCode();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
