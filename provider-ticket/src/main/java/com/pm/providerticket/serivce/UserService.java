package com.pm.providerticket.serivce;

import com.pm.providerticket.mapper.UserMapper;
import com.pm.providerticket.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author Yu
 */

public interface UserService {

    User login(String username, String password);
}
