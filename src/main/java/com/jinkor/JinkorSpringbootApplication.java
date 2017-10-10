package com.jinkor;

import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import com.jinkor.utils.configuration.IDynamcDataSourceConfiguration;


@ServletComponentScan
//TODO 禁用mybatis自动配置  由于使用多数据 要把mybatis自动配置的去掉 
//TODO 由于引用pageHelper的时候会帮我们自动配置 但是我们又做了自定义整合 所以这边把pageHelper的自动注入给去掉
@SpringBootApplication(exclude= {MybatisAutoConfiguration.class, PageHelperAutoConfiguration.class}) 
//TODO 加载druid的spring监控,使用aop对方法进行拦截看到访问时间及次数 
@ImportResource(locations = { "classpath:druid/druid-bean.xml"})
public class JinkorSpringbootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JinkorSpringbootApplication.class, args);
		
	}
}
