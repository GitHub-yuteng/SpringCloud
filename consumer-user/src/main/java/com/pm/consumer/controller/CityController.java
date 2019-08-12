package com.pm.consumer.controller;

import com.pm.consumer.service.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.pm.consumer.constant.ConsumerConstant.API_PATH_PREFIX;
import static com.pm.consumer.constant.ConsumerConstant.CONSUMERUSER;
import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Yu
 */

@RestController
@Api(tags = "城市相关请求", description = "消费者 城市接口信息")
@RequestMapping(value = API_PATH_PREFIX + CONSUMERUSER + "/city", consumes = {ALL_VALUE}, produces = {APPLICATION_JSON_UTF8_VALUE})
public class CityController {

    // 日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CityService cityService;

    @GetMapping("/ticketId/{tid}")
    @ApiOperation(value = "根据车票ID，查询能到达的城市")
    public List<String> listCityNameByTicId(@PathVariable("tid") Integer tid) {
        List<String> names = cityService.queryCitysByTicketId(tid);
        return names;
    }
}
