package com.levlin.service.Impl;

import com.levlin.mapper.StockOrderDaoMapper;
import com.levlin.model.Stock;
import com.levlin.model.StockOrder;
import com.levlin.service.StockOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: levlin
 * @Date: 2018/8/23
 * @version: 1.0
 * @Description:
 */

@Service
public class StockOrderServiceImpl implements StockOrderService {

    @Autowired
    private StockOrderDaoMapper stockOrderDaoMapper;

    @Override
    @Transactional
    public int createOrder(Stock stock) {
        StockOrder stockOrder = new StockOrder();
        stockOrder.setSid(stock.getId());
        stockOrder.setName(stock.getName());
        return stockOrderDaoMapper.insertSelective(stockOrder);
    }
}
