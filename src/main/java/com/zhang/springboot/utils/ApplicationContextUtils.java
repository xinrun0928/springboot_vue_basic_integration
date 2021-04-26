package com.zhang.springboot.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author zhangxinrun(OS - > zhang)
 * @Date 2021/4/26 7:43
 * @Version 1.0
 * @Description 获取容器内的对象工具类
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    /**
     * 根据bean的名字获取工厂中指定的bean对象
     * @param beanName  工厂中bean对象的名字
     * @return
     */
    public static Object getContainerBean(String beanName){
        return context.getBean(beanName);
    };
}
