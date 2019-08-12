package com.pm.consumer.controller;

import com.pm.consumer.pojo.User;
import com.pm.consumer.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.pm.consumer.constant.ConsumerConstant.API_PATH_PREFIX;
import static com.pm.consumer.constant.ConsumerConstant.CONSUMERUSER;
import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Yu
 */
@RestController
@Api(tags = "用户相关请求", description = "消费者 用户模块接口信息")
@RequestMapping(value = API_PATH_PREFIX + CONSUMERUSER + "/user", consumes = {ALL_VALUE}, produces = {APPLICATION_JSON_UTF8_VALUE})
public class UserController {

    // 日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    @ApiOperation(value = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "password", value = "用户密码")
    })
    @PostMapping("/login")
    public User login(@RequestParam(name = "username") String username
            , @RequestParam(name = "password") String password) {
        User user = userService.login(username, password);
        return user;
    }

    @PostMapping("/register")
    @ApiOperation(value = "注册")
    public User login(@RequestBody String username) {
        User user = new User(1, "zhangsan", "23", "123", new Date());
        return user;
    }
}
