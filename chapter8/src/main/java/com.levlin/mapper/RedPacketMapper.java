package com.levlin.mapper;

import com.levlin.model.RedPacket;
import com.levlin.util.MyMapper;

/**
 * @Author: levlin
 * @Date: 2018/10/23
 * @version: 1.0
 * @Description:
 */
public interface RedPacketMapper extends MyMapper<RedPacket> {

    RedPacketMapper getRedPacket(Long id);

    Integer decreaseRedPacket(Long id);
}
