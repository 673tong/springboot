package com.jinkor.utils.content;

public enum IErrorEnum {
	
	FILE_NAME_ISNULL(-1, "文件名为空"),
	UPLOAD_FAILD(-2, "上传失败");
	
	
	private Integer status;
	
	private String msg;

	private IErrorEnum(Integer status, String msg) {
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
