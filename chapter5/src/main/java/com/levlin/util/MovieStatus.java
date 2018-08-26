package com.levlin.util;

/**
 * @Author: levlin
 * @Date: 2018/8/26
 * @version: 1.0
 * @Description:
 */
public enum MovieStatus {
    UP(1,"上架"),
    AUDIT(0,"审核中"),
    DOWN(-1,"下架or删除"),

    ;

    private Integer code;
    private String message;

    private MovieStatus(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
