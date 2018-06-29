package cn.yyy.service;

import cn.yyy.pojo.ImgCheckCode;
import cn.yyy.pojo.StudentInfo;
import cn.yyy.pojo.TeacherInfo;
import cn.yyy.pojo.User;

public interface ILoginService {
	public User getUserByUsername(String username);
	
	public User getUserByPhoneNumber(String phone);
	
	public String getIdentity(User user);
	
	public TeacherInfo getTeacherInfoByUser(User user);
	
	public StudentInfo getStudentInfoByUser(User user);
	
	/**
	 * 获得图片验证码
	 * @param width
	 * @param height
	 * @return 图片验证码及验证码
	 */
	public ImgCheckCode getImgCheckCode(int width,int height);
}
