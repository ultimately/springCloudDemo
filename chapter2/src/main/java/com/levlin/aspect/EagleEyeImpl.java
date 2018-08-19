package com.levlin.aspect;

import com.alibaba.fastjson.JSON;
import com.levlin.annotation.EagleEye;
import com.levlin.exception.SignValidException;
import com.levlin.model.BaseRequest;
import com.levlin.util.CryptUtil;
import com.levlin.util.Result;
import com.levlin.util.SignUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class EagleEyeImpl {

    private static String API_KEY = "3a5e5c01f5ff4d05a26edf7ad4f067bc"; //app 客户端密匙
    private static long EXPIRE_TIME = 10 * 1000;            //过期时间
    private final int FORBIDDEN = 0 ;

    @Autowired
    CacheManager cacheManager;

    private ConcurrentHashMap<String, String> cacheMaanager;

    @Pointcut("@annotation(com.levlin.annotation.EagleEye)")
    public void signValid(){

    }
    @Around("signValid()")
    public Object around(ProceedingJoinPoint pjp)throws Throwable{
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        EagleEye eagleEye = method.getAnnotation(EagleEye.class);
        //eagleEye.count();

        BaseRequest request  = (BaseRequest) pjp.getArgs()[0];
        SortedMap<String, String > params = convertToMap(request);
        try {
            //效验时间是否在合理范围内
            //validTimestamp(params);
            //效验随机数，5分钟随机数相同的请求非法
//            validEchostr(params);
            //效验签名
            //validSign(params);
            String encrypt = request.getEncryptstr();
            Class clazz = pjp.getArgs()[0].getClass();

            String decrypt = CryptUtil.decrypt(encrypt);
            Object o = JSON.parseObject(decrypt,clazz);
            return pjp.proceed(new Object[]{o});
        }catch (Exception ex){
            System.out.println("12345");
            return new Result(FORBIDDEN,ex.getMessage());
        }
    }

    /***
     * 效验时间
     * @param params
     * @throws Exception
     */
    private void  validTimestamp(SortedMap<String, String> params) throws Exception{
        String timestampstr = params.get("timestamp");
        if (StringUtils.isBlank(timestampstr)){
            throw new SignValidException("illegal request");
        }
        long difference = Math.abs(System.currentTimeMillis() - Long.valueOf(timestampstr));
        if (difference > EXPIRE_TIME){
            throw new SignValidException("illegal request");
        }
    }

    /***
     * 效验随机数
     * @param params
     * @throws Exception
     */
    private void validEchostr(SortedMap<String, String> params) throws Exception{
        String echostr = params.get("echostr");
        if (StringUtils.isBlank(echostr)){
            throw new SignValidException("illegal request");
        }

        //5分钟之内随机数相同的请求，认为请求非法重放攻击
        validEchostr(echostr);
    }
    private static final String ECHOSTR = "echostr";

    private void validEchostr(String echostr) throws Exception{
        Cache.ValueWrapper wrapper = cacheManager.getCache(ECHOSTR).get(ECHOSTR+":"+echostr);
        if ((wrapper == null)){
            cacheManager.getCache(ECHOSTR).put(ECHOSTR + ":" + echostr,"1");
        }else{
            Object value = wrapper.get();
            if (value != null){
                throw new SignValidException("illegal request");
            }else{
                cacheManager.getCache(ECHOSTR).put(ECHOSTR + ":" + echostr ,"1");
            }
        }
    }

    /***
     * 效验签名
     * @param params
     * @throws Exception
     */
    private void validSign(SortedMap<String, String> params) throws Exception{
        String passSign = params.get("sign");
        String sign = SignUtil.createSign(params,API_KEY);
        if (StringUtils.isBlank(sign)){
            throw new SignValidException("illegal request");
        }else{
            throw new SignValidException("illegal request");
        }

    }
    private SortedMap<String,String> convertToMap(BaseRequest request) {
        SortedMap<String, String> params = new TreeMap<>();
        params.putAll(JSON.parseObject(JSON.toJSONString(request),Map.class));
        return params;
    }

}