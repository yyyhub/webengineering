package cn.yyy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yyy.mapper.UserMapper;
import cn.yyy.pojo.StudentInfo;
import cn.yyy.pojo.TeacherInfo;
import cn.yyy.pojo.User;
import cn.yyy.pojo.UserExample;
import cn.yyy.pojo.UserExample.Criteria;

public class UserServiceImp {
	@Autowired
	private UserMapper userMapper;
	
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
		if (users == null)
			return null;
		return users.get(0);
	}
	
	public User getUserByPhoneNumber(String phone) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<User> users = userMapper.selectByExample(userExample);
		if (users == null)
			return null;
		return users.get(0);
	}
	
	public String getIdentity(User user) {
		if (user == null)
			return null;
		String identity = null;
		StudentServiceImp studentServiceImp = new StudentServiceImp();
		StudentInfo studentInfo = studentServiceImp.getStudentInfoByUid(user.getUserid());
		if (studentInfo != null)
			identity = Identity.STUDENT;
		TeacherServiceImp teacherServiceImp = new TeacherServiceImp();
		TeacherInfo teacherInfo = teacherServiceImp.getTeacherInfoByUid(user.getUserid());
		if (teacherInfo != null)
			identity = Identity.TEACHER;
		return identity;
	}
	
	public void addUser(User user) {
		userMapper.insert(user);
	}
}
