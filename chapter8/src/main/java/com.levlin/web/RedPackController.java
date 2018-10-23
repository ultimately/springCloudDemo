package com.levlin.web;

import com.levlin.model.RedPacket;
import com.levlin.service.RedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: levlin
 * @Date: 2018/10/23
 * @version: 1.0
 * @Description:
 */
@RestController
@RequestMapping(value = "/redPacket")
public class RedPackController {

    @Autowired
    private RedPacketService redPacketService;


    @GetMapping(value = "/getRedPacketList")
    public List<RedPacket> getRedPacketList(){
        return redPacketService.getRedPacketList();
    }
}
