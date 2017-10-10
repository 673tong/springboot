package com.jinkor.utils.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.jinkor.utils.properties.ServerIPProperties;

/**
 *  全局设置跨域请求  
	整合Cors 跨域请求	
 * @author huangxincheng
 *
 */
@SpringBootConfiguration
public class CorsConfiguration {

	@Bean
	@ConditionalOnClass(WebMvcConfigurer.class)
	public WebMvcConfigurer corsConfiguraer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				/**　指定只能有http://localhost:8081 这个域名通过cors跨域请求  如果想任何域名都行请把他去掉**/
				registry.addMapping("/api/**").allowedOrigins("http://localhost:8081");
			}
		};
	}
}
