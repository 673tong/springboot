package com.jinkor.utils.configuration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DatabaseDriver;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.pool.DruidDataSource;
import com.jinkor.utils.datasource.IDynamicDataSource;
import com.jinkor.utils.datasource.handler.IDynamicDataSourceHandler;
import com.jinkor.utils.properties.IDynamicDataSourceProperties;


/**
 * springboot整合数据源
 * @author huangxincheng
 */
@SpringBootConfiguration
public class IDataSourceConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(IDataSourceConfiguration.class);
	
	/**
	 * 整合druid数据源 没有使用阿里提供的自动配置
	 * @author huangxincheng
	 *
	 */
	@ConditionalOnClass(DruidDataSource.class)
	@ConditionalOnProperty(name="spring.datasource.type", havingValue = "com.alibaba.druid.pool.DruidDataSource", matchIfMissing = true)
	static class IDruid extends IDataSourceConfiguration {
		@Bean
		@ConfigurationProperties("spring.datasource.druid")
		public DruidDataSource dataSource(DataSourceProperties properties) {
			DruidDataSource druidDataSource = (DruidDataSource) properties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
			DatabaseDriver databaseDriver = DatabaseDriver.fromJdbcUrl(properties.determineUrl());
			String validationQuery = databaseDriver.getValidationQuery();
			if (null != validationQuery) {
				druidDataSource.setValidationQuery(validationQuery);
			}
			logger.info("IDataSourceConfiguration 初始化 DruidDataSource");
			return druidDataSource;
		}
	}
	
	
	/**
	 * 整合自定义动态数据源
	 * @author huangxincheng
	 *
	 */
	@ConditionalOnClass(value = IDynamicDataSource.class)
	@ConditionalOnProperty(name="spring.datasource.type",  havingValue = "com.jinkor.utils.datasource.IDynamicDataSource", matchIfMissing = true)
	static class IDynamic extends IDataSourceConfiguration {
		
		@Bean
		public IDynamicDataSource dataSource(DataSourceProperties properties, IDynamicDataSourceProperties iDynamicDataSourceProperties) throws SQLException {
			DruidDataSource masterDataSource = (DruidDataSource) properties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
			DruidDataSource slave01DataSource = (DruidDataSource) properties.initializeDataSourceBuilder().type(DruidDataSource.class).build();
			String validationQuery = null;
			
			masterDataSource.setUrl(iDynamicDataSourceProperties.getMasterurl());
			validationQuery = DatabaseDriver.fromJdbcUrl(iDynamicDataSourceProperties.getMasterurl()).getValidationQuery();
			if (null != validationQuery) {
				masterDataSource.setValidationQuery(validationQuery);
			}
			slave01DataSource.setUrl(iDynamicDataSourceProperties.getSlave01url());
			validationQuery = DatabaseDriver.fromJdbcUrl(iDynamicDataSourceProperties.getSlave01url()).getValidationQuery();
			if (null != validationQuery) {
				slave01DataSource.setValidationQuery(validationQuery);
			}
			IDynamicDataSource dataSource = new IDynamicDataSource();
			Map<Object,Object> sourceMap = new HashMap<>();
			
			//增加SQL监控
			masterDataSource.setFilters("stat");
			slave01DataSource.setFilters("stat");
			
			sourceMap.put(IDynamicDataSourceHandler.MASTER, masterDataSource);
			sourceMap.put(IDynamicDataSourceHandler.SLAVE01, slave01DataSource);
			dataSource.setTargetDataSources(sourceMap);
			dataSource.setDefaultTargetDataSource(masterDataSource); 
			logger.info("IDataSourceConfiguration 初始化 IDynamicDataSource");
			logger.info("master_jdbcurl:" + iDynamicDataSourceProperties.getMasterurl() + ",slave01_jdbcurl:" + iDynamicDataSourceProperties.getSlave01url());
			return dataSource;
		}
	}
}
