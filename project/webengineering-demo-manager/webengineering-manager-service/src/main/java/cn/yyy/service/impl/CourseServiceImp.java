package cn.yyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yyy.mapper.CourseMapper;
import cn.yyy.pojo.College;
import cn.yyy.pojo.Course;
import cn.yyy.pojo.CourseExample;
import cn.yyy.pojo.CourseExample.Criteria;
import cn.yyy.service.ClassService;
import cn.yyy.service.CourseService;
import cn.yyy.service.MessageService;
import cn.yyy.service.MessageSubject;
import cn.yyy.service.TeacherService;
import cn.yyy.service.UserService;
import common.utils.FileUtil;

@Service
public class CourseServiceImp implements CourseService{
	@Autowired
	private CourseMapper courseMapper;
	@Autowired
	private ClassService classService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	@Autowired
	private TeacherService teacherService;
	
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

	@Override
	public Integer addNewCourse(String coursename, Integer teacherid, Integer collegeid) {
		CourseExample courseExample = new CourseExample();
		Criteria criteria = courseExample.createCriteria();
		criteria.andCoursenameEqualTo(coursename);
		criteria.andTeacheridEqualTo(teacherid);
		criteria.andCollegeidEqualTo(collegeid);
		List<Course> courses = courseMapper.selectByExample(courseExample);
		if (courses!=null)
			if (courses.size()>0)
				return null;
		Course course = new Course();
		course.setCourseid(null);
		course.setCollegeid(collegeid);
		course.setCoursename(coursename);
		course.setTeacherid(teacherid);
		courseMapper.insert(course);
		courses = courseMapper.selectByExample(courseExample);
		if (courses==null||courses.size()<=0)
			return -1;
		
		messageService.addMessage("[恭喜您创建成功课程"+coursename+"，课程号为："+courses.get(0).getCourseid()+"]", -1, teacherService.getTeacherInfoByTeacherId(teacherid).getUserid(), "创建课程成功", MessageSubject.CREATE);
		return courses.get(0).getCourseid();
	}
}
