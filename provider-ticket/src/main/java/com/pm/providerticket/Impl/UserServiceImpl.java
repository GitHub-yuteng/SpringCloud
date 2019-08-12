package com.pm.providerticket.Impl;

import com.pm.providerticket.exception.UserNotExistException;
import com.pm.providerticket.mapper.UserMapper;
import com.pm.providerticket.pojo.User;
import com.pm.providerticket.serivce.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.pm.providerticket.component.enmus.ExceptionEnum.USER_NOT_EXIST;

@Service
public class UserServiceImpl implements UserService {

    // 日志
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {

        User user = new User();
        user.setName(username);
        user.setPassword(password);

        User one = userMapper.selectOne(user);

        if (one != null) {
            one.setLoginTime(new Date());
            int i = userMapper.updateByPrimaryKey(one);
            try {
                if (i == 0) {
                    throw new RuntimeException("更新登录时间失败！");
                }
            } catch (RuntimeException e) {
                //记录日志
                logger.error("Error login UserId in '{}', error info '{}'", one.getId(), e.getMessage(), e);
            }
            logger.info("Info Success info '{}'", one);
            return one;
        } else {
            logger.error("Error login UserId in '{}', error info '{}'", username, USER_NOT_EXIST);
            return null;
        }
    }
}