package com.zhang.springboot.vo;

import java.util.HashMap;

/**
 * @Author zhangxinrun(OS - > zhang)
 * @Date 2021/4/25 22:24
 * @Version 1.0
 * @Description 强悍的返回json字符串的工具
 */
public class Json extends HashMap<String, Object> {

    // 默认的键
    public static final String KEY_OPERATOR = "operator";
    public static final String KEY_SUCCESS = "success";
    public static final String KEY_CODE = "code";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_DATA = "data";

    // 默认的值
    public static final String DEFAULT_OPERATOR_VALUE = "default";
    public static final int DEFAULT_SUCCESS_CODE = 1;
    public static final int DEFAULT_FAIL_CODE = -1;
    public static final String DEFAULT_SUCCESS_MESSAGE = "ok";
    public static final String DEFAULT_FAIL_MESSAGE = "fail";

    // 最通用的两个构造函数

    /**
     * 无参构造：操作成功返回的响应信息
     */
    public Json(){
        this.put(KEY_OPERATOR, DEFAULT_OPERATOR_VALUE);
        this.put(KEY_SUCCESS, true);
        this.put(KEY_CODE, DEFAULT_SUCCESS_CODE);
        this.put(KEY_MESSAGE, DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 操作成功返回的响应信息
     * @param operator  自定义返回成功时的操作信息
     */
    public Json(String operator){
        this.put(KEY_OPERATOR, operator);
        this.put(KEY_SUCCESS, true);
        this.put(KEY_CODE, DEFAULT_SUCCESS_CODE);
        this.put(KEY_MESSAGE, DEFAULT_SUCCESS_MESSAGE);
    }

    /**
     * 全参构造
     * @param operator  操作信息
     * @param success   成功信息
     * @param code  返回状态码
     * @param message
     * @param data  传递的数据
     */
    public Json(String operator, boolean success, int code, String message, Object data){
        this.put(KEY_OPERATOR, operator);
        this.put(KEY_SUCCESS, success);
        this.put(KEY_CODE, code);
        this.put(KEY_MESSAGE, message);
        if(data != null){
            this.put(KEY_DATA, data);
        }
    }

    // 各种简便的静态工厂工具类

    // 操作成功的

    public static Json success(){
        return new Json();
    }

    public static Json success(String operator){
        return new Json(operator, true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, null);
    }

    public static Json success(String operator, String message){
        return new Json(operator,true, DEFAULT_SUCCESS_CODE, message, null);
    }

    public static Json success(String operator, Object data){
        return new Json(operator, true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, data);
    }

    public static Json success(String operator, String dataKey, Object dataValue){
        return new Json(operator, true, DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, null)
                .data(dataKey, dataValue);
    }

    // 操作失败的

    public static Json fail() {
        return new Json(DEFAULT_OPERATOR_VALUE, false, DEFAULT_FAIL_CODE, DEFAULT_FAIL_MESSAGE,null);
    }

    public static Json fail(String operator) {
        return new Json(operator,false, DEFAULT_FAIL_CODE, DEFAULT_FAIL_MESSAGE,null);
    }

    public static Json fail(String operator, String message) {
        return new Json(operator,false, DEFAULT_FAIL_CODE, message,null);
    }

    public static Json fail(String operator, Object data) {
        return new Json(operator,false, DEFAULT_FAIL_CODE, DEFAULT_FAIL_MESSAGE, data);
    }

    public static Json fail(String operator, String dataKey, Object dataVal) {
        return new Json(operator,false, DEFAULT_FAIL_CODE, DEFAULT_FAIL_MESSAGE,null)
                .data(dataKey, dataVal);
    }

    // 操作动态判定成功或者失败

    public static Json result(String operator, boolean success){
        return new Json(
                operator,
                success,
                (success ? DEFAULT_SUCCESS_CODE : DEFAULT_FAIL_CODE),
                (success ? DEFAULT_SUCCESS_MESSAGE : DEFAULT_FAIL_MESSAGE),
                null
        );
    }

    public static Json result(String operator, boolean success, Object data){
        return new Json(
                operator,
                success,
                (success ? DEFAULT_SUCCESS_CODE : DEFAULT_FAIL_CODE),
                (success ? DEFAULT_SUCCESS_MESSAGE : DEFAULT_FAIL_MESSAGE),
                data
        );
    }

    public static Json result(String operator, boolean success, String dataKey, Object dataValue){
        return new Json(
                operator,
                success,
                (success ? DEFAULT_SUCCESS_CODE : DEFAULT_FAIL_CODE),
                (success ? DEFAULT_SUCCESS_MESSAGE : DEFAULT_FAIL_MESSAGE),
                null
        ).data(dataKey, dataValue);
    }

    // 各种链式调用方法

    /**
     * 设置操作名称
     * @param operator  操作名称
     * @return
     */
    public Json operator(String operator){
        this.put(KEY_OPERATOR, operator);
        return this;
    }

    /**
     * 设置操作结果是否成功的标记
     * @param success   操作成功的标记
     * @return
     */
    public Json success(boolean success){
        this.put(KEY_MESSAGE, success);
        return this;
    }

    /**
     * 设置操作结果的代码
     * @param code  操作结果的代码
     * @return
     */
    public Json code(int code){
        this.put(KEY_CODE, code);
        return this;
    }

    /**
     * 设置操作结果的信息
     * @param message   操作结果的信息
     * @return
     */
    public Json message(String message){
        this.put(KEY_MESSAGE, message);
        return this;
    }

    /**
     * 设置操作返回的数据（默认键为data），且只能返回单个对象的数据
     * @param dataValue     返回的数据
     * @return
     */
    public Json data(Object dataValue){
        this.put(KEY_DATA, dataValue);
        return this;
    }

    /**
     * 设置操作返回的数据，数据使用自定义的 key 存储
     * @param dataKey   自定义的key（返回的键）
     * @param dataValue     自定义的value（返回的数据）
     * @return
     */
    public Json data(String dataKey, Object dataValue){
        this.put(dataKey, dataValue);
        return this;
    }

}
