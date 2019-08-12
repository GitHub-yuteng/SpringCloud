package com.pm.providerticket.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.util.Date;

/**
 * @author Yu
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户实体")
public class User {

    @Id
    @ApiModelProperty(value = "用户id")
    private Integer id;
    @ApiModelProperty(value = "用户name")
    private String name;
    @ApiModelProperty(value = "用户password")
    private String password;
    @ApiModelProperty(value = "用户手机号")
    private String phone;
    @ApiModelProperty(value = "用户登录时间")
    private Date loginTime;
}
