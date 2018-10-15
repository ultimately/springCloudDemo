package com.levlin.service;

import com.levlin.vo.CityVO;
import com.levlin.vo.ProductVO;

import java.util.List;

public interface DemoService {
    String hello(String nickName);

    List<CityVO> getCityList1(int pageIndex, int pageSize);


    List<CityVO> getCityList2(int pageIndex, int pageSize);


    ProductVO getProduct1();

    ProductVO getProduct2();

    List<ProductVO> getProduct3();

    boolean insertProduct() throws Exception;
}