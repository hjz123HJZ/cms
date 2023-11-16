package com.briup.mp.bean;

import lombok.Data;

/**
 * @Auther: dmc(hjz)
 * @Date: 2023/11/14-11-14-15:09
 * @Description：com.briup.mp.bean
 */
@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;
}
