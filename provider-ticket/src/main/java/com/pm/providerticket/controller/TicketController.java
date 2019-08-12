package com.pm.providerticket.controller;

import com.pm.providerticket.pojo.Ticket;
import com.pm.providerticket.serivce.TicketService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.pm.providerticket.component.enmus.ExceptionEnum.DELETE_TICKET_FAIL;
import static com.pm.providerticket.constant.ProviderTicketConstant.API_PATH_PREFIX;
import static com.pm.providerticket.constant.ProviderTicketConstant.PROVIDERTICKET;
import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Yu
 */
@RestController
@Api(tags = "车票相关请求", description = "服务提供者 车票接口信息")
@RequestMapping(value = API_PATH_PREFIX + PROVIDERTICKET + "/ticket", consumes = {ALL_VALUE}, produces = {APPLICATION_JSON_UTF8_VALUE})
public class TicketController {

    // 日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    TicketService ticketService;

    /**
     * 购买票 映射
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "购买票")
    @RequestMapping(value = "/buy/{id}", method = RequestMethod.POST)
    public Ticket getTicket(@PathVariable("id") String id) {
        Ticket ticket = ticketService.getTicket(id);
        return ticket;
    }

    /**
     * 获取票的库存
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取车票库存")
    @RequestMapping(value = "/stock/{id}", method = RequestMethod.GET)
    public Ticket getTicketStock(@PathVariable("id") String id) {
        Ticket ticket = ticketService.getTicketStock(id);
        return ticket;
    }

    /**
     * 修改车票信息
     *
     * @return
     */
    @ApiOperation(value = "根据车票 Id 修改车票信息")
    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    public Ticket updateTicketInfo(@RequestBody Ticket ticket) {
        Ticket tic = ticketService.updateTicketInfoById(ticket);
        return tic;
    }

    /**
     * 根据id删除 此票
     *
     * @param tid
     * @return
     */
    @ApiOperation(value = "根据车票 Id 删除车票信息")
    @RequestMapping(value = "/{tid}", method = RequestMethod.DELETE)
    public String deleteTicketById(@PathVariable("tid") String tid) {
        String delTic = null;
        try {
            delTic = ticketService.delTicketById(tid);
        } catch (Exception e) {
            logger.error("Error deleteTicketById in  '{}', error info '{}'", DELETE_TICKET_FAIL, e.getMessage(), e);
        }
        return delTic;
    }
}
