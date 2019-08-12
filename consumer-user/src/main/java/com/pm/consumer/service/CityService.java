package com.pm.consumer.service;

import java.util.List;

public interface CityService {

    List<String> queryCitysByTicketId(Integer tid);
}