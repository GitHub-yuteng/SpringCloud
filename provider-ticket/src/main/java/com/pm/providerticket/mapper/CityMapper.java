package com.pm.providerticket.mapper;

import com.pm.providerticket.pojo.City;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author Yu
 */
public interface CityMapper extends Mapper<City> {


    @Select("SELECT c.`city` FROM city c  WHERE c.`id` IN (SELECT tc.cid FROM tid_cid tc WHERE tc.tid = #{tid})")
    List<City> queryCitysByTicketId(@Param("tid") Integer tid);
}
