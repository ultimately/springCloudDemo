package com.levlin.model;

import lombok.Data;

import javax.persistence.Table;

@Data
@Table(name = "sys_user")
public class Users {
    private Integer id;
    private String cnname;
    private String username;
    private String password;
    private String email;
    private String telephone;
    private String mobilePhone;
}