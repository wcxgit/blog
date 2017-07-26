package com.walter.Utils;

import org.springframework.util.DigestUtils;

/**
 * Created by walter on 2017/7/23.
 * md5加密工具包
 */
public class MD5Util {
    public static String getMd5(String str) {
        //加颜值
        String text = "=-_(+_):*&^%$#@dKe@3raW" + str;
        return DigestUtils.md5DigestAsHex(text.getBytes());
    }
}
