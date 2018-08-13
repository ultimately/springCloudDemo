package com.levlin.controller;

import com.levlin.annotation.CheckReqNo;
import com.levlin.req.BaseResponse;
import com.levlin.req.StatusEnum;
import com.levlin.util.NULLBody;
import com.levlin.util.RedisContentReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/chapter1")
@RestController
public class Chapter1Controller {

    private static final Logger log = LoggerFactory.getLogger(Chapter1Controller.class);


    @Value("${my1.name}")
    private String my1Name;


    @CheckReqNo
    @RequestMapping(value = "/createRedisContent",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<NULLBody> createRedisContent(@RequestBody RedisContentReq redisContentReq){
        BaseResponse<NULLBody> response = new BaseResponse<NULLBody>() ;
        try {
            response.setReqNo(redisContentReq.getReqNo());
            response.setCode(StatusEnum.SUCCESS.getCode());
            response.setMessage(StatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            log.error("system error",e);
            response.setReqNo(response.getReqNo());
            response.setCode(StatusEnum.FAIL.getCode());
            response.setMessage(StatusEnum.FAIL.getMessage());
        }
        return response ;
    }

}