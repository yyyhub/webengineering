package cn.yyy.service;

import cn.yyy.pojo.ImgCheckCode;

public interface LoginService {
	
	
	/**
	 * 获取登录的验证码对象（bimg,code）
	 * @param width
	 * @param height
	 * @return 验证码对象（bimg,code）
	 */
	public ImgCheckCode getImgCheckCode(int width, int height);
}
