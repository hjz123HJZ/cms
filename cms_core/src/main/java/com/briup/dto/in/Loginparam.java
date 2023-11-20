package com.briup.dto.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/20-11-20-11:18
 * @Description：com.briup.dto.in
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel("用户参数")
public class Loginparam {
    @ApiModelProperty(name = "username",value = "用户名",required = true,example = "admin")
    private String username;
    @ApiModelProperty(name = "password",value = "密码",required = true,example = "admin")
    private String password;
}
