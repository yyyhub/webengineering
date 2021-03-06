package cn.yyy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yyy.mapper.StudentMapper;
import cn.yyy.pojo.Class;
import cn.yyy.pojo.College;
import cn.yyy.pojo.SchoolExample;
import cn.yyy.pojo.SelectKey;
import cn.yyy.pojo.Student;
import cn.yyy.pojo.StudentExample;
import cn.yyy.pojo.StudentExample.Criteria;
import cn.yyy.pojo.StudentInfo;
import cn.yyy.pojo.User;
import cn.yyy.service.ClassService;
import cn.yyy.service.CollegeService;
import cn.yyy.service.SchoolService;
import cn.yyy.service.SelectService;
import cn.yyy.service.StudentService;
import cn.yyy.service.UserService;

@Service
public class StudentServiceImp implements StudentService{
	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private UserService userService;
	@Autowired
	private CollegeService collegeService;
	@Autowired
	private SchoolService schoolService;
	@Autowired
	private SelectService selectService;
	@Autowired
	private ClassService classService;
	
	public StudentInfo getStudentInfoByStudentId(Integer studentid) {
		Student student = studentMapper.selectByPrimaryKey(studentid);
		if (student == null)
			return null;
		User user = userService.getUserInfoByUid(student.getUserid());
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setCollegename(collegeService.getCollegeNameByCollegeId(student.getCollegeid()));
		studentInfo.setHeadicon(user.getHeadicon());
		studentInfo.setIdno(user.getIdno());
		studentInfo.setMail(user.getMail());
		studentInfo.setName(user.getName());
		studentInfo.setPassword(user.getPassword());
		studentInfo.setPhone(user.getPhone());
		studentInfo.setSchoolname(schoolService.getSchoolNameBySchoolId(student.getSchoolid()));
		studentInfo.setSid(student.getSid());
		studentInfo.setStudentid(student.getStudentid());
		studentInfo.setUserid(user.getUserid());
		studentInfo.setUsername(user.getUsername());
		return studentInfo;
	}
	
	public StudentInfo getStudentInfoByUid(Integer userid) {
		StudentExample studentExample = new StudentExample();
		Criteria criteria = studentExample.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Student> students = studentMapper.selectByExample(studentExample);
		if (students == null || students.size() <= 0)
			return null;
		StudentInfo studentInfo = getStudentInfoByStudentId(students.get(0).getStudentid());
		return studentInfo;
	}
	
	public List<Class> getAllClassByStudentid(Integer studentid){
		List<SelectKey> selectKeys = selectService.getSelectsIdByStudentid(studentid);
		List<Class> classes = new ArrayList<>();
		for (SelectKey selectKey:selectKeys) {
			Class clazz = classService.getClassByClassId(selectKey.getClassid());
			if (!classes.contains(clazz))
				classes.add(clazz);
		}
		return classes;
	}
	
	public List<StudentInfo> getCourseStudentsInfoByCourseId(Integer courseid){
		List<Class> classes = classService.getAllClassByCourseid(courseid);
		List<SelectKey> studentselects = new ArrayList<>();
		for (Class clazz:classes) {
			List<SelectKey> selectKeys = selectService.getSelectsByClassId(clazz.getClassid());
			for (SelectKey selectKey:selectKeys) {
				if (!studentselects.contains(selectKey))
					studentselects.add(selectKey);
			}
		}
		List<StudentInfo> studentInfos = new ArrayList<>();
		for (SelectKey selectKey:studentselects) {
			StudentInfo studentInfo = getStudentInfoByStudentId(selectKey.getStudentid());
			studentInfos.add(studentInfo);
		}
		return studentInfos;
	}
	
	public void addNewStudent(StudentInfo studentInfo) {
		User user = new User();
		user.setIdno(studentInfo.getIdno());
		user.setMail(studentInfo.getMail());
		user.setName(studentInfo.getName());
		user.setPassword(studentInfo.getPassword());
		user.setPhone(studentInfo.getPhone());
		user.setUserid(null);
		user.setUsername(studentInfo.getUsername());
		user.setHeadicon(studentInfo.getHeadicon());
		user.setJointime(new Date());
		userService.addUser(user);
		User user2 = userService.getUserByUsername(studentInfo.getUsername());
		Student student = new Student();
		student.setUserid(user2.getUserid());
		student.setStudentid(null);
		SchoolExample schoolExample = new SchoolExample();
		cn.yyy.pojo.SchoolExample.Criteria criteria2 = schoolExample.createCriteria();
		criteria2.andSchoolnameEqualTo(studentInfo.getSchoolname());
		Integer schoolid = schoolService.getSchoolIdBySchoolName(studentInfo.getSchoolname());
		if (schoolid == null)
			throw new RuntimeException("无此学校");
		student.setSchoolid(schoolid);
		College college = collegeService.getCollegeByCollegeName(studentInfo.getCollegename());
		if (college == null) {
			college = new College();
			college.setCollegeid(null);
			college.setCollegename(studentInfo.getCollegename());
			collegeService.addCollege(college);
			college = collegeService.getCollegeByCollegeName(studentInfo.getCollegename());
		}
		
		student.setCollegeid(college.getCollegeid());
		student.setSid(studentInfo.getSid());
		studentMapper.insert(student);
	}
}
