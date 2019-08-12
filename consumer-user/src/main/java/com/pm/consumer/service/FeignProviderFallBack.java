package com.pm.consumer.service;

import com.pm.consumer.pojo.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Yu
 */
@Component("fallback")
public class FeignProviderFallBack implements FeignProviderService {

    // 日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Ticket getTicket(String id) {
        System.out.println("->FeignProviderFallBack");
        return new Ticket(-1,"买票失败",-1);
    }

    @Override
    public Ticket getTicketStock(String id) {
        return new Ticket(-1,"获取库存失败",-1);
    }

    @Override
    public Ticket updateTicketInfo(Ticket ticket) {
        return new Ticket(-1,"更新车票信息失败",-1);
    }


    @Override
    public String deleteTicketById(String id) {
        return "FeignProviderFallBack->删除失败！";
    }
}
