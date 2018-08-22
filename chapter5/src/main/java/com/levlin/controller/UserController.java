package com.levlin.controller;

import com.levlin.mapper.UserDaoMapper;
import com.levlin.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: levlin
 * @Date: 2018/8/21
 * @version: 1.0
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserDaoMapper userMapper;

    @GetMapping(value = "/getUser")
    public void getUsesr(){

        List<Users> list = userMapper.selectAll();
        for (Iterator iterator = list.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}
