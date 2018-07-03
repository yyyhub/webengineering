package cn.yyy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.yyy.pojo.ImgCheckCode;
import cn.yyy.pojo.User;
import cn.yyy.service.LoginService;
import cn.yyy.service.UserService;
import common.utils.JsonUtil;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	private UserService userService;

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
		} 
		catch (IOException e) {
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
		String datacode = "0";
		String msg = "登录成功";
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", datacode);
		result.put("msg", msg);
		String json = null;
		// 判断验证码
		String checkCode = (String) session.getAttribute("loginCheckCodeStr");
		if (!checkCode.equals(code)) {
			datacode=checkcodeError;
			result.replace("code", datacode);
			msg = "验证码错误";
			result.replace("msg", msg);
			try {
				json = JsonUtil.mapToJson(result);
			} 
			catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			System.out.println(json);
			return json;
		} 
		// 判断用户名
		/* User user=userService.getUserByUsername(username); */
		if (!userinp.equals("zhengyuming")/* user!=null */) {
			datacode=usernameError;
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
		/* String userPassword=user.getPassword(); */
		if (!password.equals("a123456")/* userPassword.equals(password) */) {
			datacode=passwordError;
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
		
		/* session.setAttribute("loginUser", user); */
		try {
			json = JsonUtil.mapToJson(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}
}
