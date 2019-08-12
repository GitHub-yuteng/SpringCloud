package com.pm.providerticket.serivce;

import com.pm.providerticket.mapper.CityMapper;
import com.pm.providerticket.pojo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yu
 */
public interface CityService {

    List<String> queryCitysByTicketId(Integer tid);
}
