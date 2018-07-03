package cn.yyy.service;

import cn.yyy.pojo.Course;

public interface CourseService {
	/**
	 * 根据课程id获得课程对象
	 * @param courseid
	 * @return 课程对象
	 */
	public Course getCourseByCourseId(Integer courseid);
	
	/**
	 * 根据班级id获得课程对象
	 * @param classid
	 * @return 课程对象
	 */
	public Course getCourseByClassId(Integer classid);
	
	
}
