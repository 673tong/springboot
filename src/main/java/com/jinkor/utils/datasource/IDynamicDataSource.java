package com.jinkor.utils.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.jinkor.utils.datasource.handler.IDynamicDataSourceHandler;

public class IDynamicDataSource extends AbstractRoutingDataSource{

	private DruidDataSource master;
	
	private DruidDataSource slave01;
	
	@Override
	protected Object determineCurrentLookupKey() {
		//使用DynamicDataSourceHolder保证线程安全，并且得到当前线程中的数据源key
        return IDynamicDataSourceHandler.getDataSourceKey();
	}

	public DruidDataSource getMaster() {
		return master;
	}

	public void setMaster(DruidDataSource master) {
		this.master = master;
	}

	public DruidDataSource getSlave01() {
		return slave01;
	}

	public void setSlave01(DruidDataSource slave01) {
		this.slave01 = slave01;
	}
}
