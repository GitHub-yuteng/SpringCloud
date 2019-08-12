package com.pm.providerticket.Impl;

import com.pm.providerticket.mapper.TicketMapper;
import com.pm.providerticket.pojo.Ticket;
import com.pm.providerticket.serivce.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.pm.providerticket.component.enmus.ExceptionEnum.*;

@Service
public class TicketServiceImpl implements TicketService {

    // 日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TicketMapper ticketMapper;

    /**
     * 买票后减1
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public Ticket getTicket(String id) {
        Integer Id = Integer.parseInt(id);
        if (Id == 1) {
            Ticket ticket = ticketMapper.getTicketStock(Id);
            int stock = ticket.getStock();
            String name = ticket.getName();
            if (stock <= 0) {
                throw new RuntimeException("库存不足！");
            }
            stock--;
            System.out.println("===============>" + stock);
            ticket.setStock(stock);

//            Ticket tic = new Ticket();
//            tic.setId(id);
//            tic.setStock(stock);
//            tickerMapper.updateByPrimaryKey(tic);
            ticketMapper.updateTicketById(stock, Id);
            Ticket ticketStock = ticketMapper.getTicketStock(Id);
            return ticketStock;

        } else if (Id == 2) {
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.error("error: '{}' in getTicket '{}'", BUY_TIMEPUT, "车票ID为：" + Id);
            return new Ticket(-1, "id=2 购买超时", -1);
        } else {
            logger.error("error: '{}' in getTicket '{}'", CANNOT_BUY, "车票ID为：" + Id);
            return new Ticket(-1, "id=" + Id + " 不可购买", -1);
        }
    }

    /**
     * 获取当前 id票的库存
     *
     * @param id
     * @return
     */
    @Override
    @Transactional
    public Ticket getTicketStock(String id) {
        //一般传输为 String 转为 Int
        int Id = Integer.parseInt(id);

        if (Id == 1) {
            Ticket ticket = ticketMapper.getTicketStock(Id);
            return ticket;
        } else if (Id == 2) {
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.error("error: '{}' in getTicketStock '{}'", BUY_TIMEPUT, "车票ID为：" + Id);
            return new Ticket(-1, "获取库存超时", -1);
        } else {
            logger.error("error: '{}' in getTicketStock '{}'", CANNOT_GET_STOCK, "车票ID为：" + Id);
            return new Ticket(-1, "不可获取库存", -1);
        }
    }


    /**
     * 根据 id 修改 当前车票信息
     *
     * @param ticket
     * @return
     */
    @Override
    public Ticket updateTicketInfoById(Ticket ticket) {

        if (ticket.getId() != null && ticket.getStock() != null && ticket.getStock() >= 0) {
            if (ticket.getName() == null) {
                Ticket tic = ticketMapper.getTicketStock(ticket.getId());
                ticketMapper.updateTicketInfoById(ticket.getId(), tic.getName(), ticket.getStock());
            } else {
                ticketMapper.updateTicketInfoById(ticket.getId(), ticket.getName(), ticket.getStock());
            }

            Ticket updateTic = ticketMapper.getTicketStock(ticket.getId());
            return updateTic;
        } else {
            throw new RuntimeException("修改失败。");
        }
    }


    /**
     * 根据id删除
     *
     * @param tid
     * @return
     */
    @Override
    public String delTicketById(String tid) {
        Integer id = Integer.parseInt(tid);
        if (id == null) {
            return "id值为空，删除失败！";
        } else {
            int i = ticketMapper.deleteByPrimaryKey(id);
            if (i == 0) {
                throw new RuntimeException("更新条数为0，删除失败。");
            }
        }
        return "删除成功！";
    }

    /**
     * 批量增减 num 个车票
     * @param num
     */
    @Override
    public void createBatchTickets(Integer num) {

        Ticket ticket = null;
        for (int i = 0; i < num; i++) {
            ticket = new Ticket();
            ticket.setName("ticket" + num);
            ticket.setStock(num);
            ticketMapper.insert(ticket);
        }
    }
}