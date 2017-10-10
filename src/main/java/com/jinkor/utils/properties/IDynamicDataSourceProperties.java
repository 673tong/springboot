package com.jinkor.utils.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.jinkor.dynamic.datasource")
public class IDynamicDataSourceProperties {

	private String masterurl;
	
	private String slave01url;

	public String getMasterurl() {
		return masterurl;
	}

	public void setMasterurl(String masterurl) {
		this.masterurl = masterurl;
	}

	public String getSlave01url() {
		return slave01url;
	}

	public void setSlave01url(String slave01url) {
		this.slave01url = slave01url;
	}
}
