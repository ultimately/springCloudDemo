package com.levlin.model;

import lombok.Data;

@Data
public class BaseRequest {

    /***
     * @RequestBody接收参数的对象全部继承baserequest
     */

    protected String echostr; //随机字符串

    protected String timestamp;//时间

    protected String sign;//签名

    protected String encryptstr;//参数加密后的字符串
}