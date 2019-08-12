package com.pm.consumer.controller;

import com.pm.consumer.pojo.Ticket;
import com.pm.consumer.service.FeignProviderService;
import com.pm.consumer.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.pm.consumer.constant.ConsumerConstant.*;
import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Yu
 */
@RestController
@Api(tags = "车票相关请求", description = "消费者 车票接口信息")
@RequestMapping(value = API_PATH_PREFIX + CONSUMERUSER + "/ticket", consumes = {ALL_VALUE}, produces = {APPLICATION_JSON_UTF8_VALUE})
public class TicketController {

    // 日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private FeignProviderService feignProviderService;


    /**
     * 使用Feign 调用 买票
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "用户买票")
    @PostMapping("/buy/{id}")
    public Ticket buyTicket(@PathVariable("id") String id) {
        Ticket ticket = feignProviderService.getTicket(id);
        return ticket;
    }

    /**
     * 使用Feign 调用
     * 获取 此 id 票 库存
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "用户获取车票库存")
    @GetMapping("/stock/{id}")
    public Ticket getTicketStock(@PathVariable("id") String id) {
        Ticket ticket = feignProviderService.getTicketStock(id);
        return ticket;
    }
}
