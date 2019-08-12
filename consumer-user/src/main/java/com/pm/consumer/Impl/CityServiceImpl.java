package com.pm.consumer.Impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pm.consumer.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.pm.consumer.component.enmus.ExceptionEnum.GET_CITYS_FAIL;
import static com.pm.consumer.constant.ConsumerConstant.*;

/**
 * @author Yu
 */
@Service
public class CityServiceImpl implements CityService {

    // 日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getCitysByTicketId")
    public List<String> queryCitysByTicketId(Integer tId) {
        List names = restTemplate.getForObject("http://PROVIDER-TICKET" +
                API_PATH_PREFIX + PROVIDERTICKET + "/city/ticketId/" + tId, List.class);
        return names;
    }

    public List<String> getCitysByTicketId(Integer tId) {
        ArrayList<String> list = new ArrayList<>();
        list.add("获取失败");
        logger.error("Error: '{}' in getCitysByTicketId '{}'", GET_CITYS_FAIL, "车票ID为：" + tId);
        return list;
    }
}
