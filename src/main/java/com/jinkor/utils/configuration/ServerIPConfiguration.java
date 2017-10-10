package com.jinkor.utils.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;

import com.jinkor.utils.properties.ServerIPProperties;

/**
 * 自定义配置本机地址及端口
 * @author huangxincheng
 *
 */
@SpringBootConfiguration
public class ServerIPConfiguration {

	@Bean
	@ConditionalOnClass(ServerIPProperties.class)
	public ServerIPProperties serverIPProperties() {
		return new ServerIPProperties();
	}
}
