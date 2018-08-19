package com.levlin.util;

import com.levlin.model.BaseRequest;

import java.util.Date;

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
 * @Date: 13:47 2018/8/19
 * @param:
 * @Description: 加密传输实体类
 */
public class SmsMessageRequest extends BaseRequest {

    private String sendNO;

    private Date sendTime;

    private String SmsBody;

    private String SimFingerprint;

    public String getSendNO() {
        return sendNO;
    }

    public void setSendNO(String sendNO) {
        this.sendNO = sendNO;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getSmsBody() {
        return SmsBody;
    }

    public void setSmsBody(String smsBody) {
        SmsBody = smsBody;
    }

    public String getSimFingerprint() {
        return SimFingerprint;
    }

    public void setSimFingerprint(String simFingerprint) {
        SimFingerprint = simFingerprint;
    }
}
