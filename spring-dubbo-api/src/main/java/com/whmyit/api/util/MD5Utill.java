package com.whmyit.api.util;

import org.springframework.util.DigestUtils;

/**
 * @Author: whmyit@163.com
 * @Description: MD5 相关工具类
 * @Date: Created in 10:18  2018/11/12
 */
public class MD5Utill {

    private static final String MD5_URL_KEY = "1265SADF4";

    /**
     * 暴露秒杀接口加密
     * @param seckillId
     * @return
     */
    public static String getUrlMD5(long seckillId) {
        String base=seckillId+MD5_URL_KEY;
        String md5=DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

}
