package com.jinkor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jinkor.mapper.CustomerMapper;
import com.jinkor.mapper.LogMapper;
import com.jinkor.service.LogService;
import com.jinkor.utils.SpringUtil;
import com.jinkor.utils.datasource.handler.IDynamicDataSourceHandler;
import com.jinkor.utils.properties.IDynamicDataSourceProperties;
import com.jinkor.utils.properties.ServerIPProperties;

@RestController
@RequestMapping("/index")
public class IndexController {

	@Autowired
	ServerIPProperties serverIPProperties;
	
	@Autowired
	LogService logService;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	IDynamicDataSourceProperties iDynamicDataSourceProperties;
	
	@RequestMapping
	public String index() {
		System.out.println(iDynamicDataSourceProperties.getMasterurl());
		System.out.println(SpringUtil.getBean(IDynamicDataSourceProperties.class).getMasterurl());
		return "hello world";
	}
	
	@RequestMapping("/master")
	public String index_m() {
		System.out.println("before:" + IDynamicDataSourceHandler.getDataSourceKey());
		System.out.println("logService_M:" + logService.queryForList_M());
		System.out.println("after:" + IDynamicDataSourceHandler.getDataSourceKey());
		return "hello world_master";
	}
	
	@RequestMapping("/slave")
	public String index_s() {
		System.out.println("before:" + IDynamicDataSourceHandler.getDataSourceKey());
		System.out.println("logService_S:" + logService.queryForList_S());
		System.out.println("after:" + IDynamicDataSourceHandler.getDataSourceKey());
		return "hello world_slave";
	}
	
	@RequestMapping("/serverIp")
	public ServerIPProperties serverIp() {
		int i = 1/0;
		return serverIPProperties;
	}
	
	
}
