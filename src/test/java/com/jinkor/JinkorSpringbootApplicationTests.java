package com.jinkor;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jinkor.mapper.CustomerMapper;
import com.jinkor.mapper.LogMapper;
import com.jinkor.model.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JinkorSpringbootApplicationTests {

	@Autowired
	LogMapper logMapper;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Test
	public void queryForList() {
		List<Log> queryForList = logMapper.queryForList();
		System.out.println(queryForList);
	}
	
	@Test
	public void queryForBean() {
		Log queryForBean = logMapper.queryForBean(1L);
		System.out.println(queryForBean);
	}
	
	@Test
	public void insert() {
		Log log = new Log();
		log.setLog_name("log_1");
		log.setLog_time(new Date());
		logMapper.insert(log );
	}
	
	@Test
	public void update() {
		Log log = new Log();
		log.setLog_name("log_5");
		log.setLog_time(new Date());
		log.setId(5L);
		logMapper.update(log);
	}
	
	@Test
	public void delete() {
		logMapper.delete(5L);
	}
	
	@Test
	public void customerMapper_queryForList() {
		System.out.println(customerMapper.queryFotList());
	}

}
