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
public class City {

    @Id
    private Integer cid;
    private String city;
}
