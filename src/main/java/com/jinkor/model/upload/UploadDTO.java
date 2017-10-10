package com.jinkor.model.upload;

import com.jinkor.model.base.BaseDTO;
import com.jinkor.utils.content.IErrorEnum;
import com.jinkor.utils.content.ISuccessEnum;

public class UploadDTO extends BaseDTO{

	public UploadDTO(Integer state, String msg) {
		super(state, msg);
	}
	
	public static UploadDTO uploadSuccess() {
		return new UploadDTO(ISuccessEnum.UOLOAD_SUCCESS.getStatus(),  ISuccessEnum.UOLOAD_SUCCESS.getMsg());
	}
	
	public static UploadDTO uploadFaild() {
		return new UploadDTO(IErrorEnum.UPLOAD_FAILD.getStatus(),  IErrorEnum.UPLOAD_FAILD.getMsg());
	}
	
	public static UploadDTO uploadfileNameIsNull() {
		return new UploadDTO(IErrorEnum.FILE_NAME_ISNULL.getStatus(),  IErrorEnum.FILE_NAME_ISNULL.getMsg());
	}
}
