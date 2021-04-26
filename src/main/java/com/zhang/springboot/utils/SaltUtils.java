package com.zhang.springboot.utils;

import java.util.Random;

/**
 * @Author zhangxinrun(OS - > zhang)
 * @Date 2021/4/26 7:49
 * @Version 1.0
 * @Description 随机盐工具类
 */
public class SaltUtils {

    /**
     * 生成salt的静态方法
     * @param number    生成盐的长度
     * @return
     */
    public static String getSalt(int number){

        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~!@#$%^&*()_+".toCharArray();

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < number; i++) {
            // 从字符数组中随机取出一个字符
            char aChar = chars[new Random().nextInt(chars.length)];
            stringBuffer.append(aChar);
        }

        return stringBuffer.toString();
    }

}
