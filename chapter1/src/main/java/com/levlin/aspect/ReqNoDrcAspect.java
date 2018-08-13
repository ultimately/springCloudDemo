package com.levlin.aspect;

import com.levlin.req.BaseRequest;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 *                    _ooOoo_
 *                   o8888888o
 *                   88" . "88
 *                   (| -_- |)
 *                    O\ = /O
 *                ____/`---'\____
 *              .   ' \\| |// `.
 *               / \\||| : |||// \
 *             / _||||| -:- |||||- \
 *               | | \\\ - /// | |
 *             | \_| ''\---/'' | |
 *              \ .-\__ `-` ___/-. /
 *           ___`. .' /--.--\ `. . __
 *        ."" '< `.___\_<|>_/___.' >'"".
 *       | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *         \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 *                    `=---='
 *
 * .............................................
 *          佛祖保佑             永无BUG
 * @Author: lt  
 * @Date: 23:56 2018/8/14
 * @param: 
 * @Description: 
 */
@Aspect
@Component
public class ReqNoDrcAspect {


    private static Logger logger = LoggerFactory.getLogger(ReqNoDrcAspect.class);


	@Value("${redis.prefixReq:reqNo}")
	private String prefixReq ;

	@Value("${redis.day:1}")
	private long day ;

	@Resource
	private RedisTemplate<String, String> redisTemplate;
	
	@PostConstruct
	public void init() throws Exception {
		logger.info("init......");
	}
	
	@Pointcut("@annotation(com.levlin.annotation.CheckReqNo)")
	public void checkRepeat(){
		
	}

	@Before("checkRepeat()")
	public void before(JoinPoint joinPoint) throws Exception {
		BaseRequest request = getBaseRequest(joinPoint);
		System.out.println(request);
		if(request != null){
			final String reqNo = request.getReqNo();
			if(StringUtils.isEmpty(reqNo)){
				throw new RuntimeException("reqNo不能为空");
			}else{
				try {
					String tempReqNo = redisTemplate.opsForValue().get(prefixReq +reqNo);
					logger.debug("tempReqNo="+tempReqNo);

					if((StringUtils.isEmpty(tempReqNo))){
						redisTemplate.opsForValue().set(prefixReq + reqNo, reqNo, day, TimeUnit.DAYS);
					}else{
						throw new RuntimeException("请求号重复,reqNo="+reqNo);
					}

				} catch (RedisConnectionFailureException e){
					logger.error("redis操作异常",e);
					throw new RuntimeException("need redisService") ;
				}
			}
		}
			
	}
	
	
	 
	 public static BaseRequest getBaseRequest(JoinPoint joinPoint) throws Exception {
		 BaseRequest returnRequest = null;
		 Object[] arguments = joinPoint.getArgs();
		 if(arguments != null && arguments.length > 0){
			 returnRequest = (BaseRequest) arguments[0];
		 }
	     return returnRequest;
	 }
}