package com.zhang.data.save_data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan //配置druid必须加的注解，如果不加，访问页面打不开，filter和servlet、listener之类的需要单独进行注册才能使用，spring boot里面提供了该注解起到注册作用
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@MapperScan({"com.zhang.data.save_data.moudles.base.mapper.PeopleMapper"})  //扫描的是mapper.xml中namespace指向值的包位置
public class SaveDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaveDataApplication.class, args);
    }

}
