package com.zhang.springboot.annotation;

import java.lang.annotation.*;

/**
 * @Author zhangxinrun(OS - > zhang)
 * @Date 2021/4/25 23:11
 * @Version 1.0
 * @Description 自定义权限注解
 */

/**
 * @Target注解的作用时用来说明“注解的作用目标”
 *      1、@Target(ElementType.TYPE)——接口、类、枚举、注解
 *      2、@Target(ElementType.FIELD)——字段、枚举的常量
 *      3、@Target(ElementType.METHOD)——方法
 *      4、@Target(ElementType.PARAMETER)——方法参数
 *      5、@Target(ElementType.CONSTRUCTOR) ——构造函数
 *      6、@Target(ElementType.LOCAL_VARIABLE)——局部变量
 *      7、@Target(ElementType.ANNOTATION_TYPE)——注解
 *      8、@Target(ElementType.PACKAGE)——包
 */
@Target({ElementType.TYPE, ElementType.METHOD}) // 标注该注解可以声明的位置
/**
 * @Retention可以用来修饰注解，是注解的注解，称为元注解
 * 这个枚举决定了Retention注解应该如何去保持
 *      1、RetentionPolicy.SOURCE：注解只保留在源文件，当Java文件编译成class文件的时候，注解被遗弃；
 *      2、RetentionPolicy.CLASS：注解被保留到class文件，但jvm加载class文件时候被遗弃，这是默认的生命周期；
 *      3、RetentionPolicy.RUNTIME：注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在；
 */
@Retention(RetentionPolicy.RUNTIME)
/**
 * @Documented 注解表明这个注解应该被 javadoc工具记录.
 *      默认情况下,javadoc是不包括注解的. 但如果声明注解时指定了 @Documented,则它会被 javadoc 之类的工具处理,
 *      所以注解类型信息也会被包括在生成的文档中，是一个标记注解，没有成员
 */
@Documented
public @interface PermissionInfo {

    /**
     * 权限值
     * @return
     */
    String permissionValue() default "";

    /**
     * 权限名称（permissionName的别名）
     * @return
     */
    String value() default "";
}
