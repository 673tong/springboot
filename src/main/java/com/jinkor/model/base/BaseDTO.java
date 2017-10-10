package com.jinkor.model.base;

public class BaseDTO {
	
	private Integer state;
	
	private String msg;

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public BaseDTO() {}
	
	public BaseDTO(Integer state, String msg) {
		this.state = state;
		this.msg = msg;
	}
	
}
