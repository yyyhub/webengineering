package cn.yyy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yyy.mapper.CourseMapper;
import cn.yyy.pojo.Course;

public class CourseServiceImp {
	@Autowired
	private CourseMapper courseMapper;
	
	public Course getCourseByCourseId(Integer courseid) {
		Course course = courseMapper.selectByPrimaryKey(courseid);
		if (course == null)
			throw new RuntimeException("无此课程");
		return course;
	}
	
	public Course getCourseByClassId(Integer classid) {
		ClassServiceImp classServiceImp = new ClassServiceImp();
		Course course = getCourseByCourseId(classServiceImp.getClassByClassId(classid).getCourseid());
		return course;
	}
}
