package com.pm.providerticket.component.enmus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Yu
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ExceptionEnum {

    TICKCT_INVENTORY_SHORTAGE(400, "票库存不足！"),
    SHORTAGE_NOT_FOUND(404, "库存没有查到！"),
    TICKCT_UPDATE_FAILED(500, "票信息更新失败！"),
    BUY_TIMEPUT(500, "购买超时"),
    CANNOT_BUY(500, "不可购买"),
    GET_STOCK_TIMEPUT(500, "获取库存超时"),
    CANNOT_GET_STOCK(500, "不可获取库存"),
    DELETE_TICKET_FAIL(500,"删除车票失败"),


    USER_NOT_EXIST(500,"用户不存在"),

    ;
    private int code;
    private String msg;
}
