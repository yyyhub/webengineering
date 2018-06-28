package cn.yyy.service;

import cn.yyy.pojo.ImgCheckCode;
import cn.yyy.pojo.StudentInfo;
import cn.yyy.pojo.TeacherInfo;

public interface IRegisterService {
	/**
	 * 该用户名用户是否已存在
	 * @param username
	 * @return 存在与否
	 */
	public boolean isExistUsername(String username);
	
	/**
	 * 该手机号用户是否已存在
	 * @param phone
	 * @return
	 */
	public boolean isExistPhoneNumber(String phone);
	
	/**
	 * 获得图片验证码
	 * @param width
	 * @param height
	 * @return 图片验证码及验证码
	 */
	public ImgCheckCode getImgCheckCode(int width,int height);
	
	public void addNewStudent(StudentInfo studentInfo);
	
	public void addNewTeacher(TeacherInfo teacherInfo);
}
