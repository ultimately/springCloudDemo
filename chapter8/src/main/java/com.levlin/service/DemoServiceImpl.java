package com.levlin.service;

import com.github.pagehelper.PageHelper;
import com.levlin.annotation.ProductMaster;
import com.levlin.annotation.ProductSlave;
import com.levlin.annotation.StudyMaster;
import com.levlin.annotation.StudySlave;
import com.levlin.config.DbContextHolder;
import com.levlin.mapper.CityMapper;
import com.levlin.mapper.ProductMapper;
import com.levlin.model.City;
import com.levlin.model.Product;
import com.levlin.vo.CityVO;
import com.levlin.vo.ProductParam;
import com.levlin.vo.ProductVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CityMapper cityMapper;


    @Autowired
    private ProductMapper productMapper;

    public String hello(String nickName) {
        logger.info(nickName + " call me!");
        return String.format("hi , %s!", nickName);
    }

    @Override
    @StudySlave
    public List<CityVO> getCityList1(int pageIndex, int pageSize) {
        return getCityList(pageIndex, pageSize);
    }

    @Override
    @StudyMaster
    public List<CityVO> getCityList2(int pageIndex, int pageSize) {
        return getCityList(pageIndex, pageSize);
    }

    @Override
    @ProductMaster
    public ProductVO getProduct1() {
        return getFirst();
    }

    @Override
    @ProductSlave
    public ProductVO getProduct2() {
        return getFirst();
    }

    @Override
    public List<ProductVO> getProduct3() {
        ProductParam param = new ProductParam();
        param.setUpdateTimeStart(new Date(System.currentTimeMillis() - 24 * 3600 * 1000));
        param.setUpdateTimeEnd(new Date());
        List<Product> list = productMapper.selectByParam(param);
        List<ProductVO> result = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            for (Product p : list) {
                ProductVO vo = new ProductVO();
                vo.setPrice(p.getPrice());
                vo.setName(p.getName());
                result.add(vo);
            }
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean insertProduct() throws Exception {
        Product p1 = new Product();
        p1.setName("AAAA");
        p1.setPrice(new BigDecimal(10.0));
        productMapper.insertSelective(p1);
        logger.info("p1.id=>" + p1.getId());
        productMapper.insertSelective(p1);
        return false;
    }

    private ProductVO getFirst() {
        Product p = productMapper.getFirst();
        ProductVO vo = new ProductVO();
        vo.setName(p.getName());
        vo.setPrice(p.getPrice());
        return vo;
    }

    private List<CityVO> getCityList(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);//设置分页参数
        List<City> list = cityMapper.selectAll();
        com.github.pagehelper.PageInfo page = new com.github.pagehelper.PageInfo<>(list);//取页面信息
        List<CityVO> result = new ArrayList<>();
        if (!CollectionUtils.isEmpty(list)) {
            for (City c : list) {
                CityVO v = new CityVO();
                v.setCityName(c.getName());
                v.setProvinceName(c.getState());
                result.add(v);
            }
        }
        logger.info("pageInfo=> page:" + page.getPageNum() + "/" + page.getPages() + "，dbType:" + DbContextHolder.getDbType());
        return result;
    }


}