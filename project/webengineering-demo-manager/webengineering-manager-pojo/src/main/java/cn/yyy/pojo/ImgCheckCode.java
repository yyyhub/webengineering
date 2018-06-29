package cn.yyy.pojo;

import java.awt.Graphics;


public class ImgCheckCode {
	//图片验证码图片
	private Graphics checkCodeImg;
	
	//图片验证码验证码
	private String checkCode;
	
	public Graphics getCheckCodeImg() {
		return checkCodeImg;
	}
	public void setCheckCodeImg(Graphics checkCodeImg) {
		this.checkCodeImg = checkCodeImg;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
}
