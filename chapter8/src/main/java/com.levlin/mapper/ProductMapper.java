package com.levlin.mapper;


import com.levlin.model.Product;
import com.levlin.util.MyMapper;
import com.levlin.vo.ProductParam;

import java.util.List;

public interface ProductMapper extends MyMapper<Product> {
    Product getFirst();

    List<Product> selectByParam(ProductParam param);
}