package com.levlin.model;

import lombok.Data;

/**
 * @Author: levlin
 * @Date: 2018/8/21
 * @version: 1.0
 * @Description:
 */
@Data
public class User {

    private Integer id;

    private String cnname;

    private String username;

    private String password;

    private String email;

    private String telephone;

    private String mobilePhone;
}
