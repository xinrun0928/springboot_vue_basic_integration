package com.zhang.springboot.utils;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @Author zhangxinrun(OS - > zhang)
 * @Date 2021/4/24 7:23
 * @Version 1.0
 * @Description mybatisPlus代码生成器
 */
public class MybatisPlusAutoGenerator {

    public static void main(String[] args) {
        // 获取当前项目路径
        String projectPath = System.getProperty("user.dir");

        //1、全局配置
        GlobalConfig globalConfig= new GlobalConfig();
        globalConfig.setActiveRecord(true)//是否支持AR模式
                .setAuthor("ZhangXinRun")//作者
                .setOutputDir(projectPath + "/src/main/java/")//生成路径
                .setFileOverride(true)//第二次生成会把第一次生成的覆盖掉
                .setIdType(IdType.AUTO)//主键策略
                .setServiceName("%sService")//设置生成的service接口的名字的首字母是否为I，这样设置就没有
                .setBaseColumnList(true)
                .setBaseResultMap(true);//生成对应的resultMap

        //2、数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)//设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/ccccperform?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8")
                .setUsername("root")
                .setPassword("123456");

        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setDbColumnUnderline(true)//全局大写命名
                .setCapitalMode(true)//指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体类的命名策略
                .setTablePrefix("zt_")// 表名前缀
                .setEntityLombokModel(false)// 取消使用lombok设置
                .setInclude("zt_depart_dim","zt_kpi_dim","zt_kpi_type_dim");// 逆向工程使用的表   如果要生成多个,这里可以传入String[]

        //4、包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.zhang.springboot")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("entity")
                .setXml("mapper");

        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setStrategy(strategyConfig);

        //6、执行
        // autoGenerator.execute();
    }
}
