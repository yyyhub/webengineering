package cn.yyy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.field.DecoratedDurationField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.GenericMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.yyy.pojo.ImgCheckCode;
import cn.yyy.pojo.StudentInfo;
import cn.yyy.pojo.TeacherInfo;
import cn.yyy.pojo.User;
import cn.yyy.service.Identity;
import cn.yyy.service.LoginService;
import cn.yyy.service.StudentService;
import cn.yyy.service.TeacherService;
import cn.yyy.service.UserService;
import common.utils.JsonUtil;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StudentService studentService;

	@RequestMapping("/getLoginCheckCode")
	@ResponseBody
	public void getLoginCheckCode(HttpSession session, HttpServletResponse response) {
		ImgCheckCode imgCheckCode = new ImgCheckCode();
		final int width = 80;
		final int height = 35;
		imgCheckCode = loginService.getImgCheckCode(width, height);
		System.out.println(imgCheckCode.getCheckCode());
		session.setAttribute("loginCheckCodeStr", imgCheckCode.getCheckCode());
		try {
			ImageIO.write(imgCheckCode.getCheckCodeImg(), "jpeg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	@RequestMapping("/checkUserNameLoginInfo")
	@ResponseBody
	public String checkUserNameLogininfo(String userinp, String password, String code, HttpSession session,
			HttpServletResponse response) {
		System.out.println(userinp);
		System.out.println(password);
		System.out.println(code);
		String logintrue = "0";
		String usernameError = "1";
		String passwordError = "2";
		String checkcodeError = "3";
		String datacode = logintrue;
		String msg = "登录成功";
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", datacode);
		result.put("msg", msg);
		String json = null;
		// 判断验证码
		String checkCode = (String) session.getAttribute("loginCheckCodeStr");
		if (!checkCode.equals(code)) {
			datacode = checkcodeError;
			result.replace("code", datacode);
			msg = "验证码错误";
			result.replace("msg", msg);
			try {
				json = JsonUtil.mapToJson(result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			System.out.println(json);
			return json;
		}
		// 判断用户名
		User user = userService.getUserByUsername(userinp);
		if (user == null) {
			datacode = usernameError;
			result.replace("code", datacode);
			msg = "用户名不存在";
			result.replace("msg", msg);
			try {
				json = JsonUtil.mapToJson(result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			System.out.println(json);
			return json;
		}

		// 判断密码
		String userPassword = user.getPassword();
		if (!userPassword.equals(password)) {
			datacode = passwordError;
			result.replace("code", datacode);
			msg = "密码错误";
			result.replace("msg", msg);
			try {
				json = JsonUtil.mapToJson(result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			System.out.println(json);
			return json;
		}

		// 记录成功登录状态，并将User存入session
		String identity = userService.getIdentity(user);
		if (identity== null) {
			System.out.println("无此用户");
		}else {
			if (identity.equals(Identity.TEACHER)) {
				TeacherInfo teacherInfo = teacherService.getTeacherInfoByUid(user.getUserid());
				session.setAttribute("user", teacherInfo);
				session.setAttribute("identity", "teacher");
			}
			if (identity.equals(Identity.STUDENT)) {
				StudentInfo studentInfo = studentService.getStudentInfoByUid(user.getUserid());
				session.setAttribute("user", studentInfo);
				session.setAttribute("identity", "student");
			}
		}
		/* session.setAttribute("loginUser", user); */
		try {
			json = JsonUtil.mapToJson(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}

	@RequestMapping("/sendLoginPhoneCheckCode")
	@ResponseBody
	public String sendLoginPhoneCheckCode(String phone, HttpSession session) {
		String code = "123456";
		boolean isSuccess = false;
		System.out.println(phone);
		if (code != null) {
			session.setAttribute("phoneCode", code);
			isSuccess = true;
		}

		User user = userService.getUserByPhoneNumber(phone);
		if (user == null) {
			isSuccess = false;
		}

		String result = "{\"isSuccess\":" + isSuccess + "}";
		return result;
	}

	@RequestMapping("/checkPhoneLoginInfo")
	@ResponseBody
	public String checkPhoneLogininfo(String phone, String code, HttpSession session, HttpServletResponse response) {
		System.out.println(phone);
		System.out.println(code);
		String logintrue = "0";
		String phoneError = "1";
		String checkcodeError = "2";
		String datacode = logintrue;
		String msg = "登录成功";
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", datacode);
		result.put("msg", msg);
		String json = null;

		// 判断验证码是否发送
		Object checkobj = session.getAttribute("phoneCode");
		if (checkobj==null) {
			datacode = checkcodeError;
			result.replace("code", datacode);
			msg = "验证码未发送";
			result.replace("msg", msg);
			try {
				json = JsonUtil.mapToJson(result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			System.out.println(json);
			return json;
		}

		// 判断验证码
		String checkCode = (String) session.getAttribute("phoneCode");
		if (!checkCode.equals(code)) {
			datacode = checkcodeError;
			result.replace("code", datacode);
			msg = "验证码错误";
			result.replace("msg", msg);
			try {
				json = JsonUtil.mapToJson(result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			System.out.println(json);
			session.removeAttribute("phoneCode");
			return json;
		}

		// 判断电话号
		User user = userService.getUserByPhoneNumber(phone);
		if (user == null) {
			datacode = phoneError;
			result.replace("code", datacode);
			msg = "电话号码未注册";
			result.replace("msg", msg);
			try {
				json = JsonUtil.mapToJson(result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			System.out.println(json);
			session.removeAttribute("phoneCode");
			return json;
		}

		// 记录成功登录状态，并将User存入session
		// 对页面进行重定向
		/* session.setAttribute("loginUser", user); */
		String identity = userService.getIdentity(user);
		if (identity== null) {
			System.out.println("无此用户");
		}else {
			System.out.println("判断身份");
			if (identity.equals(Identity.TEACHER)) {
				System.out.println("教师");
				TeacherInfo teacherInfo = teacherService.getTeacherInfoByUid(user.getUserid());
				session.setAttribute("user", teacherInfo);
				session.setAttribute("identity", "teacher");
			}
			if (identity.equals(Identity.STUDENT)) {
				System.out.println("学生");
				StudentInfo studentInfo = studentService.getStudentInfoByUid(user.getUserid());
				session.setAttribute("user", studentInfo);
				session.setAttribute("identity", "student");
			}
		}
		try {
			json = JsonUtil.mapToJson(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json);
		session.removeAttribute("phoneCode");
		return json;
	}
	
	@RequestMapping("/teacherreg")
	public String teacherReg(HttpSession session) {
		System.out.println("您点击了教师注册");
		return "regist";
	}
	@RequestMapping("/studentreg")
	public String studnetReg(HttpSession session) {
		System.out.println("您点击了学生注册");
		return "studentregist";
	}
}
