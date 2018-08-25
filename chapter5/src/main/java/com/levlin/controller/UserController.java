package com.levlin.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.levlin.mapper.UserDaoMapper;
import com.levlin.model.Stock;
import com.levlin.model.Users;
import com.levlin.service.StockOrderService;
import com.levlin.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "/api")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    //guava 限流 令牌每秒5个令牌
    RateLimiter rateLimiter = RateLimiter.create(5.0);


    @Autowired
    private UserDaoMapper userMapper;

    @Autowired
    private StockService stockService;

    @Autowired
    private StockOrderService stockOrderService;


    /**
     * @Author: levlin
     * @Date: 2018/8/25
     * @param:
     * @Description: springboot 集成tkmybatis 输出
     */
    @GetMapping(value = "/getUser")
    public void getUsesr(){

        List<Users> list = userMapper.selectAll();
        for (Iterator iterator = list.iterator();iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }

    /**
     * @Author: levlin
     * @Date: 2018/8/25
     * @param:
     * @Description: 数据库乐观锁更新数据库
     */
    @RequestMapping(value = "/createOptimisticOrder")
    public int createOptimisticOrder(Integer sid){
        logger.info("=======sid=[{}]====",sid);
        logger.info("====尝试获取令牌====");
        if (rateLimiter.tryAcquire()){
            Stock stock = stockService.checkStock(sid);
            saleStockOptimistic(stock);
            return stockOrderService.createOrder(stock);
        }
        return 0;
    }

    private void saleStockOptimistic(Stock stock){
        int count = stockService.saleStock(stock);
        if (count == 0){
            throw new RuntimeException("error!!!");
        }
    }
}
