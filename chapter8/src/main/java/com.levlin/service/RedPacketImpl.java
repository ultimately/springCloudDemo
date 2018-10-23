package com.levlin.service;

import com.levlin.annotation.ProductSlave;
import com.levlin.mapper.RedPacketMapper;
import com.levlin.model.RedPacket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: levlin
 * @Date: 2018/10/23
 * @version: 1.0
 * @Description:
 */
@Service
public class RedPacketImpl implements RedPacketService {

    @Autowired
    private RedPacketMapper redPacketDao;

    @ProductSlave
    @Override
    public List<RedPacket> getRedPacketList() {
        return redPacketDao.selectAll();
    }
}
