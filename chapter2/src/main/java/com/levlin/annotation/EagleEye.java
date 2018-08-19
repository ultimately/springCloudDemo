package com.levlin.annotation;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface EagleEye {

    /***
     * 允许访问的次数
     * @return
     */
    int count() default Integer.MAX_VALUE;

    /***
     * 时间段,单位为毫秒，默认值一分钟
     */
     long time() default 60000;

    /***
     * 参数是否加密
     */
    boolean encrypted() default true;
}