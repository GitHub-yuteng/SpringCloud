package com.pm.consumer.component.enmus;

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
    GET_CITYS_FAIL(500,"获取城市失败"),
    USER_NOT_EXIST(500,"用户不存在"),
    ;
    private int code;
    private String msg;
}
