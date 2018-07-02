package cn.yyy.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yyy.mapper.TeacherMapper;
import cn.yyy.pojo.College;
import cn.yyy.pojo.Teacher;
import cn.yyy.pojo.TeacherExample;
import cn.yyy.pojo.TeacherExample.Criteria;
import cn.yyy.pojo.TeacherInfo;
import cn.yyy.pojo.User;

public class TeacherServiceImp {
	@Autowired
	private TeacherMapper teacherMapper;
	
	public TeacherInfo getTeacherInfoByTeacherId(Integer teacherid) {
		Teacher teacher = teacherMapper.selectByPrimaryKey(teacherid);
		if (teacher == null)
			return null;
		UserServiceImp userServiceImp = new UserServiceImp();
		User user = userServiceImp.getUserInfoByUid(teacher.getUserid());
		TeacherInfo teacherInfo = new TeacherInfo();
		CollegeService collegeService = new CollegeService();
		teacherInfo.setCollegeName(collegeService.getCollegeNameByCollegeId(teacher.getCollegeid()));
		teacherInfo.setHeadicon(user.getHeadicon());
		teacherInfo.setIdno(user.getIdno());
		teacherInfo.setMail(user.getMail());
		teacherInfo.setName(user.getName());
		teacherInfo.setPassword(user.getPassword());
		teacherInfo.setPhone(user.getPhone());
		SchoolService schoolService = new SchoolService();
		teacherInfo.setSchoolName(schoolService.getSchoolNameBySchoolId(teacher.getSchoolid()));
		teacherInfo.setStaffid(teacher.getStaffid());
		teacherInfo.setTeacherid(teacher.getTeacherid());
		teacherInfo.setUserid(user.getUserid());
		teacherInfo.setUsername(user.getUsername());
		return teacherInfo;
		
	}
	
	public TeacherInfo getCourseTeacherInfoByCourseId(Integer courseid) {
		CourseServiceImp courseServiceImp = new CourseServiceImp();
		TeacherInfo teacherInfo = getTeacherInfoByTeacherId(courseServiceImp.getCourseByCourseId(courseid).getTeacherid());
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
		UserServiceImp userServiceImp = new UserServiceImp();
		userServiceImp.addUser(user);
		user = userServiceImp.getUserByUsername(teacherInfo.getUsername());
	
		Teacher teacher = new Teacher();
		teacher.setUserid(user.getUserid());
		teacher.setTeacherid(null);
		SchoolService schoolService = new SchoolService();
		Integer schoolid = schoolService.getSchoolIdBySchoolName(teacherInfo.getSchoolName());
		if (schoolid == null)
			throw new RuntimeException("无此学校");
		
		teacher.setSchoolid(schoolid);
		
		CollegeService collegeService = new CollegeService();
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
