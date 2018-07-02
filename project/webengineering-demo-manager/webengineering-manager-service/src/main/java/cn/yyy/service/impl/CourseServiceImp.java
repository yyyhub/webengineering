package cn.yyy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yyy.mapper.CourseMapper;
import cn.yyy.pojo.Course;
import cn.yyy.service.ClassService;
import cn.yyy.service.CourseService;

@Service
public class CourseServiceImp implements CourseService{
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private ClassService classService;
	
	public Course getCourseByCourseId(Integer courseid) {
		Course course = courseMapper.selectByPrimaryKey(courseid);
		if (course == null)
			throw new RuntimeException("无此课程");
		return course;
	}
	
	public Course getCourseByClassId(Integer classid) {
		Course course = getCourseByCourseId(classService.getClassByClassId(classid).getCourseid());
		return course;
	}
}
