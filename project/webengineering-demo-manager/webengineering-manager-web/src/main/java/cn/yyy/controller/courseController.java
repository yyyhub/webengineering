/**
 * 
 */
package cn.yyy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.yyy.pojo.Course;
import cn.yyy.pojo.Class;
import cn.yyy.pojo.SelectKey;
import cn.yyy.pojo.StudentInfo;
import cn.yyy.pojo.TeacherInfo;
import cn.yyy.pojo.User;
import cn.yyy.service.ClassService;
import cn.yyy.service.CourseService;
import cn.yyy.service.SelectService;
import common.utils.JsonUtil;


@Controller
public class courseController {
	@Autowired
	private SelectService selectService;
	@Autowired
	private ClassService classService;
	@Autowired
	private CourseService courseService;

	@RequestMapping("/getCourseInfo")
	@ResponseBody
	public String getCourseInfo(HttpSession session, HttpServletResponse response) {
		String identityStr = (String) session.getAttribute("identity");
		if (identityStr.equals("student")) {
			StudentInfo studentInfo = (StudentInfo) session.getAttribute("user");
			Integer stuId = studentInfo.getStudentid();
			System.out.println("stuId:"+stuId);
			List<SelectKey> selectList = selectService.getSelectsIdByStudentid(stuId);
			if(!selectList.isEmpty()) {
				System.out.println("selectclassid:"+selectList.get(0).getClassid());
			}
			List<Class> classList = new ArrayList<Class>();
			List<Course> courseList = new ArrayList<Course>();
			for(int i = 0; i < selectList.size(); i++) {
				classList.add(classService.getClassByClassId(selectList.get(i).getClassid()));
				courseList.add(courseService.getCourseByClassId(selectList.get(i).getClassid()));
			}
			if(!classList.isEmpty()) {
				System.out.println("class:"+classList.get(0).getClassname());
			}
			if(!courseList.isEmpty()) {
				System.out.println("course:"+courseList.get(0).getCoursename());
			}
			session.setAttribute("classes", classList);
			session.setAttribute("courses", courseList);
			return "{\"sign\":"+true+"}";
		} else {	
			return "{\"sign\":"+false+"}";
		}
	}
	
	@RequestMapping("/jumpToMyCourse")
	public String jumpToMyCourse(HttpSession session) {
		System.out.println("跳转至课程页面");
		return "stucoursepage";
	}
	
	@RequestMapping("/jumpToCourseNotice")
	public String jumpToCourseNotice(HttpSession session) {
		System.out.println("跳转至课程公告");
		return "stucoursenoticepage";
	}
}
