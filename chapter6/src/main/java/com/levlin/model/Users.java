package com.levlin.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Users implements Serializable {

    private Integer id;

    private String cnname;

    private String username;

    private String password;

    private String email;

    private String telephone;

    private String mobilePhone;
}