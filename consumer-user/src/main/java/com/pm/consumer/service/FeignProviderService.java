package com.pm.consumer.service;

import com.pm.consumer.pojo.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import static com.pm.consumer.constant.ConsumerConstant.API_PATH_PREFIX;
import static com.pm.consumer.constant.ConsumerConstant.PROVIDERTICKET_TICKET;

/**
 * @author Yu
 */

@FeignClient(value = "PROVIDER-TICKET", fallback = FeignProviderFallBack.class)
public interface FeignProviderService {

    @RequestMapping(value = API_PATH_PREFIX + PROVIDERTICKET_TICKET + "/buy/{id}", method = RequestMethod.POST)
    public Ticket getTicket(@PathVariable("id") String id);

    @RequestMapping(value = API_PATH_PREFIX + PROVIDERTICKET_TICKET + "/stock/{id}", method = RequestMethod.GET)
    public Ticket getTicketStock(@PathVariable("id") String id);

    @RequestMapping(value = API_PATH_PREFIX + PROVIDERTICKET_TICKET + "/info", method = RequestMethod.PUT)
    public Ticket updateTicketInfo(@RequestBody Ticket ticket);

    @RequestMapping(value = API_PATH_PREFIX + PROVIDERTICKET_TICKET + "/{tid}", method = RequestMethod.DELETE)
    public String deleteTicketById(@PathVariable("tid") String tid);
}