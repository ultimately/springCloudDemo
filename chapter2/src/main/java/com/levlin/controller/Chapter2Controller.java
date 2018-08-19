package com.levlin.controller;

import com.levlin.annotation.EagleEye;
import com.levlin.util.SmsMessageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LT
 * @Date: 2018/8/19
 * @version: 1.0
 * @Description:
 */
@RequestMapping(value = "/api")
@RestController
public class Chapter2Controller {


    @EagleEye(count = 1,encrypted = true,time = 60000)
    @RequestMapping(value = "/userPermission" , method = RequestMethod.POST)
    public String userPermission(@RequestBody(required = true) SmsMessageRequest smsMessageRequest){
        System.out.println("---------------------------------------------");
        return null;
    }
}
