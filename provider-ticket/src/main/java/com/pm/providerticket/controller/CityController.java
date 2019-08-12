package com.pm.providerticket.controller;

import com.pm.providerticket.serivce.CityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.pm.providerticket.constant.ProviderTicketConstant.API_PATH_PREFIX;
import static com.pm.providerticket.constant.ProviderTicketConstant.PROVIDERTICKET;
import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Yu
 */
@RestController
@Api(tags = "城市相关请求",description = "服务提供者 城市接口信息")
@RequestMapping(value = API_PATH_PREFIX + PROVIDERTICKET + "/city", consumes = {ALL_VALUE}, produces = {APPLICATION_JSON_UTF8_VALUE})
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/ticketId/{tid}")
    @ApiOperation(value = "根据车票ID，查询能到达的城市")
    public List<String> queryTicketToCitys(@PathVariable("tid") Integer tid) {
        List<String> cities = cityService.queryCitysByTicketId(tid);
        return cities;
    }
}
