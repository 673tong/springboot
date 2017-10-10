package com.jinkor.model;

import java.util.Date;

public class Log {

	private Long id;
	
	private String log_name;
	
	private Date log_time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLog_name() {
		return log_name;
	}

	public void setLog_name(String log_name) {
		this.log_name = log_name;
	}

	public Date getLog_time() {
		return log_time;
	}

	public void setLog_time(Date log_time) {
		this.log_time = log_time;
	}

	@Override
	public String toString() {
		return "Log [id=" + id + ", log_name=" + log_name + ", log_time=" + log_time + "]";
	}
	
	
}
