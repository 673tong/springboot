package com.jinkor.utils.content;

public enum ISuccessEnum {
	
	UOLOAD_SUCCESS(0, "上传成功");
	
	private Integer status;
	
	private String msg;

	private ISuccessEnum(Integer status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
