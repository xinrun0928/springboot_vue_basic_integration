package com.zhang.springboot.constant;

/**
 * @Author zhangxinrun(OS - > zhang)
 * @Date 2021/4/26 7:36
 * @Version 1.0
 * @Description 代码常量，响应的code
 */
public class Codes {

    /**
     * 未登录的
     */
    int UNAUTHEN = 4401;

    /**
     * 未授权，拒绝访问
     */
    int INAUTHZ = 4403;

    /**
     * session超时退出登录
     */
    int SESSION_TIMEOUT = 4433;

    /**
     * shiro相关的错误
     */
    int SHIRO_ERROR = 4444;

    /**
     * 服务端异常
     */
    int SERVER_ERROR = 5500;
}
