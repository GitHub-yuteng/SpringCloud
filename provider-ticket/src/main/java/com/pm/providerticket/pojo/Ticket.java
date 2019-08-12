package com.pm.providerticket.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;


/**
 * @author Yu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    private Integer id;
    private String name;
    private Integer stock;
}
