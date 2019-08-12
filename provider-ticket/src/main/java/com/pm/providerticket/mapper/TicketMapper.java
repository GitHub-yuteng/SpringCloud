package com.pm.providerticket.mapper;


import com.pm.providerticket.pojo.Ticket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Yu
 */
public interface TicketMapper extends Mapper<Ticket> {

    @Select("SELECT * FROM ticket WHERE id = #{id}")
    Ticket getTicketStock(@Param("id") Integer id);

    @Update("UPDATE ticket SET stock = #{stock} WHERE id = #{id}")
    void updateTicketById(@Param("stock") Integer stock, @Param("id") Integer id);

    @Update("UPDATE ticket SET stock = #{stock},name = #{name} WHERE id = #{id}")
    void updateTicketInfoById(@Param("id") Integer id, @Param("name") String name, @Param("stock") Integer stock);
}
