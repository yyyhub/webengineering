package cn.yyy.service;

import cn.yyy.pojo.Course;

public interface CourseService {
	public Course getCourseByCourseId(Integer courseid);
	
	public Course getCourseByClassId(Integer classid);
	
	
}
