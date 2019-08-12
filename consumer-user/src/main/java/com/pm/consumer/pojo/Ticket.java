package com.pm.consumer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Yu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private Integer id;
    private String name;
    private Integer stock;
}
