package com.pm.consumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pm.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static com.pm.consumer.constant.ConsumerConstant.API_PATH_PREFIX;
import static com.pm.consumer.constant.ConsumerConstant.PROVIDERTICKET;

/**
 * @author Yu
 */

public interface UserService {

    User login(String username, String password);
}