package com.jinkor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinkor.mapper.LogMapper;
import com.jinkor.model.Log;
import com.jinkor.utils.datasource.annotation.IDynamicDataSourceAnnotation;
import com.jinkor.utils.datasource.handler.IDynamicDataSourceHandler;

@Service
public class LogService {

	@Autowired
	LogMapper logMapper;
	
	@IDynamicDataSourceAnnotation(value = IDynamicDataSourceHandler.MASTER)
	public List<Log> queryForList_M() {
		PageHelper.startPage(1, 2);
		List<Log> logs = logMapper.queryForList();
		PageInfo<Log> pageInfo = new PageInfo<>(logs);
		System.out.println("totalRecords:" + pageInfo.getTotal());
		System.out.println("totalPages:" + pageInfo.getPages());
		System.out.println("pageSize:" + pageInfo.getSize());
		System.out.println("pageNum:" + pageInfo.getPageNum());
		return logs;
	}
	
	@IDynamicDataSourceAnnotation(value = IDynamicDataSourceHandler.SLAVE01)
	public List<Log> queryForList_S() {
		 return logMapper.queryForList();
	}
	
}
