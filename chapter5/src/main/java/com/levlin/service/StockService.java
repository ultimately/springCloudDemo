package com.levlin.service;

import com.levlin.model.Stock;

/**
 * @Author: levlin
 * @Date: 2018/8/23
 * @version: 1.0
 * @Description:
 */
public interface StockService {

    /**
     * @Author: levlin
     * @Date: 2018/8/23
     * @param:
     * @Description: 效验库存
     */
    public Stock checkStock(int sid);

    /**
     * @Author: levlin
     * @Date: 2018/8/23
     * @param:
     * @Description: 扣库存
     */
    public int saleStock(Stock stock);
}
