package com.jinkor.utils.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class CommonListener implements ServletContextListener{

	private static final Logger logger = LoggerFactory.getLogger(CommonListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("初始化CommonListener");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("销毁CommonListener");
	}

}
