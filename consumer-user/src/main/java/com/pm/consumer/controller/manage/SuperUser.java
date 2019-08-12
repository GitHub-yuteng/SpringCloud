package com.pm.consumer.controller.manage;

import com.pm.consumer.pojo.Ticket;
import com.pm.consumer.service.FeignProviderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.pm.consumer.constant.ConsumerConstant.API_PATH_PREFIX;
import static com.pm.consumer.constant.ConsumerConstant.CONSUMERUSER;
import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Yu
 */
@RestController
@Api(tags = "超级管理员相关请求", description = "消费者 超级管理员模块接口信息")
@RequestMapping(value = API_PATH_PREFIX + CONSUMERUSER + "/superuser", consumes = {ALL_VALUE}, produces = {APPLICATION_JSON_UTF8_VALUE})
public class SuperUser {

    @Autowired
    FeignProviderService feignProviderService;

    /**
     * 使用Feign 调用
     * 通过id修改库存
     *
     * @return
     */
    @ApiOperation(value = "更新车票信息")
    @PutMapping("/info")
    public Ticket updateTicketInfo(@RequestBody Ticket ticket) {
        Ticket updateTicket = feignProviderService.updateTicketInfo(ticket);
        return updateTicket;
    }

    /**
     * 根据tid删除
     *
     * @param tid
     * @return
     */
    @ApiOperation(value = "超级管理员删除车票")
    @DeleteMapping("/{tid}")
    public String deleteTicketById(@PathVariable("tid") String tid) {
        if (tid == null) {
            return "id值为空，删除失败！";
        } else {
            String delTic = feignProviderService.deleteTicketById(tid);
            return delTic;
        }
    }
}
