package cn.yyy.service;

import cn.yyy.pojo.ImgCheckCode;

public interface RegisterService {
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 */
	public boolean isExistUsername(String username);
	
	/**
	 * 判断手机号是否存在
	 * @param phone
	 * @return
	 */
	public boolean isExistPhoneNumber(String phone);
	
	/**
	 * 获取注册的验证码对象（bimg,code）
	 * @param width
	 * @param height
	 * @return 验证码对象（bimg,code）
	 */
	public ImgCheckCode getImgCheckCode(int width,int height);
}
