package com.levlin.controller;

import com.levlin.req.BaseResponse;
import com.levlin.req.StatusEnum;
import com.levlin.util.NULLBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.NativeWebRequest;

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
 * @Date: 0:19 2018/8/14
 * @param: 
 * @Description: 
 */
@ControllerAdvice
public class ErrorController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object processUnauthenticatedException(NativeWebRequest request, Exception e) {
        logger.error("请求出现异常:", e);
        BaseResponse<NULLBody> response = new BaseResponse<NULLBody>();
        response.setCode(StatusEnum.FAIL.getCode());
        if (e instanceof RuntimeException){
            response.setMessage(e.getMessage());
        } else {
            response.setMessage(StatusEnum.FAIL.getMessage());
        }
        return response ;
    }
}