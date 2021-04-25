package com.zhang.springboot.utils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * @Author zhangxinrun(OS - > zhang)
 * @Date 2021/4/24 7:48
 * @Version 1.0
 * @Description 分页相关的工具类
 */
public class PageUtils {

    /**
     * 获取分页参数
     * @param json  fastjson对象
     * @return
     */
    public static Page getPageParam(JSONObject json){
        // 获取当前页
        int current = json.getIntValue("current");
        // 获取当前总页数
        int size = json.getIntValue("size");
        // 默认显示第一页
        if(current == 0) current = 1;
        // 默认每页显示50条记录
        if(size == 0) size = 50;
        return new Page(current, size);
    }
}
