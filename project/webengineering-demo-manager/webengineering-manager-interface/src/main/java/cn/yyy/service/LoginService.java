package cn.yyy.service;

import cn.yyy.pojo.ImgCheckCode;

public interface LoginService {
	public ImgCheckCode getImgCheckCode(int width, int height);
}
