package com.levlin.service.Impl;

import com.levlin.mapper.StockDaoMapper;
import com.levlin.model.Stock;
import com.levlin.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author: levlin
 * @Date: 2018/8/23
 * @version: 1.0
 * @Description:
 */

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockDaoMapper stockDaoMapper;

    @Override
    public Stock checkStock(int sid) {
        Stock stock = stockDaoMapper.selectByPrimaryKey(sid);
        if (stock.getCount().equals(stock.getSale())){
            throw new RuntimeException("库存不足");
        }
        return stock;
    }

    @Override
    @Transactional
    public int saleStock(Stock stock) {
        int version = stock.getVersion();
        stock.setSale(stock.getSale() + 1);
        stock.setVersion(stock.getVersion() + 1);
        Example example = new Example(Stock.class,true);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",stock.getId());
        criteria.andEqualTo("version",version);
        return stockDaoMapper.updateByExampleSelective(stock,example);
    }
}
