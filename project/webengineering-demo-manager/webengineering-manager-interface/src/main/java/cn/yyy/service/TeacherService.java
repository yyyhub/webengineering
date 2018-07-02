package cn.yyy.service;

import cn.yyy.pojo.TeacherInfo;

public interface TeacherService {
	public TeacherInfo getTeacherInfoByTeacherId(Integer teacherid);
	
	public TeacherInfo getCourseTeacherInfoByCourseId(Integer courseid);
	
	public TeacherInfo getTeacherInfoByUid(Integer userid);
	
	public void addNewTeacher(TeacherInfo teacherInfo);
	
	
}
