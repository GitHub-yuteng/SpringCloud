package com.pm.providerticket.controller;

import com.pm.providerticket.pojo.User;
import com.pm.providerticket.serivce.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.pm.providerticket.constant.ProviderTicketConstant.API_PATH_PREFIX;
import static com.pm.providerticket.constant.ProviderTicketConstant.PROVIDERTICKET;
import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author Yu
 */
@RestController
@Api(tags = "用户相关请求", description = "服务提供者 用户接口信息")
@RequestMapping(value = API_PATH_PREFIX + PROVIDERTICKET + "/user", consumes = {ALL_VALUE}, produces = {APPLICATION_JSON_UTF8_VALUE})
public class UserController {

    // 日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名"),
            @ApiImplicitParam(name = "password", value = "用户密码")
    })
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public User login(@RequestParam(value = "username", required = true) String username,
                      @RequestParam(value = "password", required = true) String password) {
        User login = userService.login(username, password);
        return login;
    }
}
