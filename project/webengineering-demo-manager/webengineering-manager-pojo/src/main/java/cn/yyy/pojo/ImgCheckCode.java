package cn.yyy.pojo;

import java.awt.image.BufferedImage;


public class ImgCheckCode {
	//图片验证码图片
	private BufferedImage checkCodeImg;
	
	//图片验证码验证码
	private String checkCode;
	
	public BufferedImage getCheckCodeImg() {
		return checkCodeImg;
	}
	public void setCheckCodeImg(BufferedImage checkCodeImg) {
		this.checkCodeImg = checkCodeImg;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
}
