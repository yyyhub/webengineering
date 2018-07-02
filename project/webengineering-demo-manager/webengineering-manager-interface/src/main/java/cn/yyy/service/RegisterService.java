package cn.yyy.service;

import cn.yyy.pojo.ImgCheckCode;

public interface RegisterService {
	public boolean isExistUsername(String username);
	
	public boolean isExistPhoneNumber(String phone);
	
	public ImgCheckCode getImgCheckCode(int width,int height);
}
