package com.jinkor.utils.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;

import com.jinkor.utils.properties.IDynamicDataSourceProperties;

@SpringBootConfiguration
public class IDynamcDataSourceConfiguration {

	@Bean
	public IDynamicDataSourceProperties iDynamicDataSourceProperties() {
		return new IDynamicDataSourceProperties();
	}
}
