package cn.yyy.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yyy.mapper.StudentMapper;
import cn.yyy.mapper.TeacherMapper;
import cn.yyy.mapper.UserMapper;
import cn.yyy.pojo.ImgCheckCode;
import cn.yyy.pojo.Student;
import cn.yyy.pojo.StudentExample;
import cn.yyy.pojo.StudentInfo;
import cn.yyy.pojo.Teacher;
import cn.yyy.pojo.TeacherExample;
import cn.yyy.pojo.TeacherInfo;
import cn.yyy.pojo.User;
import cn.yyy.pojo.UserExample;
import cn.yyy.pojo.UserExample.Criteria;
import cn.yyy.service.ILoginService;

public class LoginServiceImp implements ILoginService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private TeacherMapper teacherMapper;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Override
	public User getUserByUsername(String username) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<User> users = userMapper.selectByExample(userExample);
		if (users == null)
			return null;
		return users.get(0);
	}

	@Override
	public User getUserByPhoneNumber(String phone) {
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andPhoneEqualTo(phone);
		List<User> users = userMapper.selectByExample(userExample);
		if (users == null)
			return null;
		return users.get(0);
	}

	@Override
	public String getIdentity(User user) {
		if (user == null)
			return null;
		String identity = null;
		StudentExample studentExample = new StudentExample();
		cn.yyy.pojo.StudentExample.Criteria criteria = studentExample.createCriteria();
		criteria.andUseridEqualTo(user.getUserid());
		List<Student> students = studentMapper.selectByExample(studentExample);
		if (students != null)
			identity = Identity.STUDENT;
		TeacherExample teacherExample = new TeacherExample();
		cn.yyy.pojo.TeacherExample.Criteria criteria2 = teacherExample.createCriteria();
		criteria2.andUseridEqualTo(user.getUserid());
		List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
		if (teachers != null)
			identity = Identity.TEACHER;
		return identity;
	}

	@Override
	public TeacherInfo getTeacherInfoByUser(User user) {
		if (user == null)
			return null;
		TeacherInfo teacherInfo = new TeacherInfo();
		TeacherExample teacherExample = new TeacherExample();
		cn.yyy.pojo.TeacherExample.Criteria criteria = teacherExample.createCriteria();
		criteria.andUseridEqualTo(user.getUserid());
		List<Teacher> teachers = teacherMapper.selectByExample(teacherExample);
		if (teachers != null) {
			Teacher teacher = teachers.get(0);
			teacherInfo.setHeadicon(user.getHeadicon());
			teacherInfo.setCollegeName(CollegeService.getCollegeNameByCollegeId(teacher.getCollegeid()));
			teacherInfo.setIdno(user.getIdno());
			teacherInfo.setMail(user.getMail());
			teacherInfo.setName(user.getName());
			teacherInfo.setPassword(user.getPassword());
			teacherInfo.setPhone(user.getPhone());
			teacherInfo.setSchoolName(SchoolService.getSchoolNameBySchoolId(teacher.getSchoolid()));
			teacherInfo.setStaffid(teacher.getStaffid());
			teacherInfo.setTeacherid(teacher.getTeacherid());
			teacherInfo.setUserid(user.getUserid());
			teacherInfo.setUsername(user.getUsername());
			return teacherInfo;
		}
		return null;
	}

	@Override
	public StudentInfo getStudentInfoByUser(User user) {
		if (user == null)
			return null;
		StudentInfo studentInfo = new StudentInfo();
		StudentExample studentExample = new StudentExample();
		cn.yyy.pojo.StudentExample.Criteria criteria = studentExample.createCriteria();
		criteria.andUseridEqualTo(user.getUserid());
		List<Student> students = studentMapper.selectByExample(studentExample);
		if (students != null) {
			Student student = students.get(0);
			studentInfo.setCollegename(CollegeService.getCollegeNameByCollegeId(student.getCollegeid()));
			studentInfo.setHeadicon(user.getHeadicon());
			studentInfo.setIdno(user.getIdno());
			studentInfo.setMail(user.getMail());
			studentInfo.setName(user.getName());
			studentInfo.setPassword(user.getPassword());
			studentInfo.setPhone(user.getPhone());
			studentInfo.setSchoolname(SchoolService.getSchoolNameBySchoolId(student.getSchoolid()));
			studentInfo.setSid(student.getSid());
			studentInfo.setStudentid(student.getStudentid());
			studentInfo.setUserid(user.getUserid());
			studentInfo.setUsername(user.getUsername());
			return studentInfo;
		}
		return null;
	}

	@Override
	public ImgCheckCode getImgCheckCode(int width, int height) {
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics graphics = bufferedImage.getGraphics();
		
		graphics.setColor(getRandColor(200, 255));
		graphics.fillRect(0, 0, width, height);
		
		graphics.setColor(Color.WHITE);
		graphics.drawRect(0, 0, width-1, height-1);
		
		Graphics2D graphics2d = (Graphics2D) graphics;
		
		graphics2d.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		Random random = new Random();
		
		String word = "";
		for (int i = 0; i < 4;i++) {
			int type = random.nextInt(3);
			int offset = random.nextInt(1000);;
			if (type == 0) {	
				word += Integer.toString(offset%10);
			}else if (type == 1) {
				word += Character.toString((char) ('a' + offset%26));
			}else if (type == 2) {
				word += Character.toString((char) ('A'+offset%26));
			}
		}
		
		int x = 5;
		for (int i = 0;i < word.length();i++) {
			graphics2d.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110), 20 + random.nextInt(110)));
			int jiaodu = random.nextInt(60) - 30;
			double theta = jiaodu * Math.PI/180;
			
			char c = word.charAt(i);
			
			graphics2d.rotate(theta,x,25);
			graphics2d.drawString(String.valueOf(c), x, 25);
			graphics2d.rotate(-theta, x, 25);
			x += 15;
		}
		ImgCheckCode imgCheckCode = new ImgCheckCode();
		imgCheckCode.setCheckCode(word);
		
		graphics.setColor(getRandColor(160, 200));
		
		int x1;
		int x2;
		int y1;
		int y2;
		for (int i = 0;i < 30;i++) {
			x1 = random.nextInt(width);
			x2 = random.nextInt(12);
			y1 = random.nextInt(height);
			y2 = random.nextInt(12);
			graphics.drawLine(x1, y1, x1 + x2, y1 + y2);
		}
		imgCheckCode.setCheckCodeImg(bufferedImage);
		return imgCheckCode;
	}
	
	/**
	 * 获得随机颜色
	 * @param fc
	 * @param bc
	 * @return
	 */
	private Color getRandColor(int fc,int bc) {
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
