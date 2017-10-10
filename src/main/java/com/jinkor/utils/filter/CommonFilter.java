package com.jinkor.utils.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter(filterName = "commonFilter", urlPatterns="/*")
public class CommonFilter implements Filter {

	private static final Logger logger = LoggerFactory.getLogger(CommonFilter.class);
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("{} 初始化", this.getClass().getSimpleName());
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		logger.info("{} 放行", this.getClass().getSimpleName());
		chain.doFilter(req, resp);
	}
	
	@Override
	public void destroy() {
		logger.info("{} 销毁", this.getClass().getSimpleName());
	}


}
