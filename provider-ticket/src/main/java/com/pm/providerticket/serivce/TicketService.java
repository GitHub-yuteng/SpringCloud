package com.pm.providerticket.serivce;

import com.pm.providerticket.mapper.TicketMapper;
import com.pm.providerticket.pojo.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yu
 */
public interface TicketService {

    /**
     * 买票后减1
     *
     * @param id
     * @return
     */
    Ticket getTicket(String id);

    /**
     * 获取当前 id票的库存
     *
     * @param id
     * @return
     */
    Ticket getTicketStock(String id);


    /**
     * 根据 id 修改 当前车票信息
     * @param ticket
     * @return
     */
    Ticket updateTicketInfoById(Ticket ticket);


    /**
     * 根据id删除
     *
     * @param tid
     * @return
     */
    String delTicketById(String tid);


    /**
     * 批量增加 num 个 车票
     * @param num
     */
    void createBatchTickets(Integer num);
}
