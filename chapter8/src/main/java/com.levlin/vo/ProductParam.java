package com.levlin.vo;

import com.levlin.model.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * Created by yangjunming on 06/08/2017.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductParam extends Product {

    private Date updateTimeStart;

    private Date updateTimeEnd;
}
