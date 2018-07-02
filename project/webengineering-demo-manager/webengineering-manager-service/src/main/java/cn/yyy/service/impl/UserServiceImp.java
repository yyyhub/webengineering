package cn.yyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yyy.mapper.UserMapper;
import cn.yyy.pojo.StudentInfo;
import cn.yyy.pojo.TeacherInfo;
import cn.yyy.pojo.User;
import cn.yyy.pojo.UserExample;
import cn.yyy.pojo.UserExample.Criteria;
import cn.yyy.service.Identity;
import cn.yyy.service.StudentService;
import cn.yyy.service.TeacherService;
import cn.yyy.service.UserService;

@Service
public class UserServiceImp implements UserService{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	
	public User getUserInfoByUid(Integer userid) {
		User user = userMapper.selectByPrimaryKey(userid);
		if (user == null)
			throw new RuntimeException("无此用户");
		return user;
	}
	
	public User getUserByUsername(String username) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> users = userMapper.selectByExample(userExample);
		if (users == null || users.size() <= 0)
			return null;
		return users.get(0);
	}
	
	public User getUserByPhoneNumber(String phone) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<User> users = userMapper.selectByExample(userExample);
		if (users == null || users.size() <= 0)
			return null;
		return users.get(0);
	}
	
	public String getIdentity(User user) {
		if (user == null)
			return null;
		String identity = null;
		StudentInfo studentInfo = studentService.getStudentInfoByUid(user.getUserid());
		if (studentInfo != null)
			identity = Identity.STUDENT;
		TeacherInfo teacherInfo = teacherService.getTeacherInfoByUid(user.getUserid());
		if (teacherInfo != null)
			identity = Identity.TEACHER;
		return identity;
	}
	
	public void addUser(User user) {
		userMapper.insert(user);
	}
}
