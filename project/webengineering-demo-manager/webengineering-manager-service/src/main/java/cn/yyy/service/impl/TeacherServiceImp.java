package cn.yyy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yyy.mapper.TeacherMapper;
import cn.yyy.pojo.College;
import cn.yyy.pojo.Teacher;
import cn.yyy.pojo.TeacherExample;
import cn.yyy.pojo.TeacherExample.Criteria;
import cn.yyy.pojo.TeacherInfo;
import cn.yyy.pojo.User;
import cn.yyy.service.CollegeService;
import cn.yyy.service.CourseService;
import cn.yyy.service.SchoolService;
import cn.yyy.service.TeacherService;
import cn.yyy.service.UserService;

@Service
public class TeacherServiceImp implements TeacherService{
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private CollegeService collegeService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private CourseService courseService;
	
	public TeacherInfo getTeacherInfoByTeacherId(Integer teacherid) {
		Teacher teacher = teacherMapper.selectByPrimaryKey(teacherid);
		if (teacher == null)
			return null;
		User user = userService.getUserInfoByUid(teacher.getUserid());
		TeacherInfo teacherInfo = new TeacherInfo();
		teacherInfo.setCollegeName(collegeService.getCollegeNameByCollegeId(teacher.getCollegeid()));
		teacherInfo.setHeadicon(user.getHeadicon());
		teacherInfo.setIdno(user.getIdno());
		teacherInfo.setMail(user.getMail());
		teacherInfo.setName(user.getName());
		teacherInfo.setPassword(user.getPassword());
		teacherInfo.setPhone(user.getPhone());
		teacherInfo.setSchoolName(schoolService.getSchoolNameBySchoolId(teacher.getSchoolid()));
		teacherInfo.setStaffid(teacher.getStaffid());
		teacherInfo.setTeacherid(teacher.getTeacherid());
		teacherInfo.setUserid(user.getUserid());
		teacherInfo.setUsername(user.getUsername());
		return teacherInfo;
		
	}
	
	public TeacherInfo getCourseTeacherInfoByCourseId(Integer courseid) {
		TeacherInfo teacherInfo = getTeacherInfoByTeacherId(courseService.getCourseByCourseId(courseid).getTeacherid());
		return teacherInfo;
	}
	
	public TeacherInfo getTeacherInfoByUid(Integer userid) {
		TeacherExample teacherExample = new TeacherExample();
		Criteria criteria = teacherExample.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
		if (teachers == null || teachers.size()<=0)
			return null;
		TeacherInfo teacherInfo = getTeacherInfoByTeacherId(teachers.get(0).getTeacherid());
		return teacherInfo;
	}
	
	public void addNewTeacher(TeacherInfo teacherInfo) {
		User user = new User();
		user.setIdno(teacherInfo.getIdno());
		user.setMail(teacherInfo.getMail());
		user.setName(teacherInfo.getName());
		user.setPassword(teacherInfo.getPassword());
		user.setPhone(teacherInfo.getPhone());
		user.setUserid(null);
		user.setUsername(teacherInfo.getUsername());
		user.setHeadicon(teacherInfo.getHeadicon());
		user.setJointime(new Date());
		userService.addUser(user);
		user = userService.getUserByUsername(teacherInfo.getUsername());
	
		Teacher teacher = new Teacher();
		teacher.setUserid(user.getUserid());
		teacher.setTeacherid(null);
		Integer schoolid = schoolService.getSchoolIdBySchoolName(teacherInfo.getSchoolName());
		if (schoolid == null)
			throw new RuntimeException("无此学校");
		
		teacher.setSchoolid(schoolid);
		College college = collegeService.getCollegeByCollegeName(teacherInfo.getCollegeName());
		if (college == null) {
			college = new College();
			college.setCollegeid(null);
			college.setCollegename(teacherInfo.getCollegeName());
			collegeService.addCollege(college);
			college = collegeService.getCollegeByCollegeName(college.getCollegename());
		}
		
		teacher.setCollegeid(college.getCollegeid());
		teacher.setStaffid(teacherInfo.getStaffid());
		teacherMapper.insert(teacher);
		
	}
}
