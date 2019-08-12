package com.pm.consumer.Impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pm.consumer.exception.UserNotExistException;
import com.pm.consumer.pojo.User;
import com.pm.consumer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

import static com.pm.consumer.component.enmus.ExceptionEnum.USER_NOT_EXIST;
import static com.pm.consumer.constant.ConsumerConstant.API_PATH_PREFIX;
import static com.pm.consumer.constant.ConsumerConstant.PROVIDERTICKET;

@Service
public class UserServiceImpl implements UserService {

    // 日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    /**
     * 登录
     */
    @Override
    @HystrixCommand(fallbackMethod = "loginfallback")
    public User login(String username, String password) {
        User userInfo = restTemplate.getForObject("http://PROVIDER-TICKET" + API_PATH_PREFIX + PROVIDERTICKET +
                "/user/login?username=" + username + "&password=" + password, User.class);
        if (userInfo == null) {
            logger.error("error: '{}' in login '{}'", USER_NOT_EXIST, "用户名称为：" + username);
            throw new UserNotExistException(USER_NOT_EXIST);
        }
        return userInfo;
    }

    public User loginfallback(String username, String password) {
        return new User(-1, "登录失败", "null", "null", new Date());
    }
}