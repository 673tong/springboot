package com.jinkor.utils.handler;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理类
 * @author Administrator
 */
public class ExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	/**
	 * 统一异常处理
	 * @param e
	 * @return
	 */
	public ModelAndView handlerException(RuntimeException e) {
		logger.info("{}", ExceptionUtils.getStackTrace(e));
		ModelAndView view = new ModelAndView();
		view.setViewName("error/500");
		return view;
	}
	
	public ModelAndView handlerException(Exception e) {
		logger.info("{}", ExceptionUtils.getStackTrace(e));
		ModelAndView view = new ModelAndView();
		view.setViewName("error/500");
		return view;
	}
	

}
