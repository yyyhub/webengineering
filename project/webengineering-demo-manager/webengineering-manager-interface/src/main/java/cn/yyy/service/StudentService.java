package cn.yyy.service;

import java.util.List;

import cn.yyy.pojo.Class;
import cn.yyy.pojo.StudentInfo;

public interface StudentService {
	public StudentInfo getStudentInfoByStudentId(Integer studentid);
	
	public StudentInfo getStudentInfoByUid(Integer userid);
	
	public List<Class> getAllClassByStudentid(Integer studentid);
	
	public List<StudentInfo> getCourseStudentsInfoByCourseId(Integer courseid);
	
	public void addNewStudent(StudentInfo studentInfo);
}
