package com.levlin.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author: levlin
 * @Date: 2018/8/22
 * @version: 1.0
 * @Description:
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
