package com.pm.providerticket.Impl;

import com.pm.providerticket.mapper.CityMapper;
import com.pm.providerticket.pojo.City;
import com.pm.providerticket.serivce.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    /**
     * @param tid
     * @return
     */
    @Override
    public List<String> queryCitysByTicketId(Integer tid) {

        List<City> cities = cityMapper.queryCitysByTicketId(tid);

        List<String> cityName = new ArrayList<>();

        for (City city : cities) {
            cityName.add(city.getCity());
        }
        return cityName;
    }
}