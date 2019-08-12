package com.pm.consumer.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yu
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "城市实体")
public class City {

    @ApiModelProperty(value = "城市id")
    private Integer cid;
    @ApiModelProperty(value = "城市name")
    private String city;
}
