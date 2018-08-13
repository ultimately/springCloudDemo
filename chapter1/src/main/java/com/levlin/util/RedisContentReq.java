package com.levlin.util;

import com.levlin.req.BaseRequest;

public class RedisContentReq extends BaseRequest {
    private Integer id ;
    private String content ;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RedisContentReq{" +
                "id=" + id +
                ", content='" + content + '\'' +
                "} " + super.toString();
    }
}