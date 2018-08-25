package com.levlin.model;

import lombok.Data;

import javax.persistence.Id;

/**
 * @Author: levlin
 * @Date: 2018/8/23
 * @version: 1.0
 * @Description:
 */
@Data
public class Stock {
    @Id
    private Integer id;
    private String name;
    private Integer count;
    private Integer sale;
    private Integer version;
}
