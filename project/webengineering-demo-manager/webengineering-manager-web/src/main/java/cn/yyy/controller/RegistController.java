package cn.yyy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.yyy.pojo.ImgCheckCode;
import cn.yyy.pojo.TeacherInfo;
import cn.yyy.service.RegisterService;
import cn.yyy.service.TeacherService;
import common.utils.JsonUtil;
import common.utils.SendPhoneMsg;

@Controller
public class RegistController {
	@Autowired
	private RegisterService registerService;
	@Autowired
	private TeacherService teacherService;

	@RequestMapping("/getcheckcode")
	@ResponseBody
	public void getcheckcode(HttpSession session,HttpServletResponse response) {
		ImgCheckCode imgCheckCode=new ImgCheckCode();
		final int width=80;
		final int height=35;
		imgCheckCode=registerService.getImgCheckCode(width, height);
		System.out.println(imgCheckCode.getCheckCode());
		session.setAttribute("checkcodestr",imgCheckCode.getCheckCode());
		try {
			ImageIO.write( imgCheckCode.getCheckCodeImg(), "jpeg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	@RequestMapping("/sendPhoneCheckCode")
	@ResponseBody
	public String sengPhoneCheckCode(String phone,HttpSession session) {
		String code = "123456";
		boolean isSuccess = false;
		System.out.println(phone);
		if (code != null) {
			session.setAttribute("phoneCode", code);
			isSuccess = true;
		}
		String result = "{\"isSuccess\":"+isSuccess+"}";
		return result;
	}
	
	@RequestMapping("/checkusername")
	@ResponseBody
	public String checkUserName(String username,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result=new HashMap<String, Object>();
		System.out.println(username);
		boolean sign=registerService.isExistUsername(username);
		
		result.put("isnameexist", sign);
		session.setAttribute("isusernameexist", sign);
		String json = null;
		try {
			json = JsonUtil.mapToJson(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}
	
	
	@RequestMapping("/checkphonenumber")
	@ResponseBody
	public String checkPhoneNumber(String phonenumber,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result=new HashMap<String, Object>();
		System.out.println(phonenumber);
		boolean sign=registerService.isExistPhoneNumber(phonenumber);
		result.put("isphoneexist", sign);
		String json = null;
		try {
			json = JsonUtil.mapToJson(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//System.out.println(json);
		return json;
	}
	
	@RequestMapping("/checkccode")
	@ResponseBody
	public String checkCCode(String checkcode,HttpSession session) {
		Map<String, Object> result=new HashMap<String, Object>();
		System.out.println("client:"+checkcode);
		String sessioncheckcode=(String) session.getAttribute("checkcodestr");
		boolean sign=false;
		if(sessioncheckcode.equals(checkcode)) {
			sign=true;
		}
		
		result.put("ischeckcoderight", sign);
		String json = null;
		try {
			json = JsonUtil.mapToJson(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json);
		return json;
	}
	
	@RequestMapping("/checkPhoneCode")
	@ResponseBody
	public String checkPhoneCode(String phoneCode,HttpSession session) {
		Object codeobj = session.getAttribute("phoneCode");
		String code = null;
		boolean isRight = false;
		if (codeobj != null) {
			code = (String) codeobj;
			if (phoneCode.equals(code)) {
				isRight = true;
				System.out.println(code);
			}
		}
		String result = "{\"isRight\":"+isRight+"}";
		return result;
	}
	
	@RequestMapping("/addNewTeacher")
	@ResponseBody
	public String addNewTeacher(String username,String password,String phone,String name,String staffid,String mail,String schoolName,String collegeName) {
		TeacherInfo teacherInfo = new TeacherInfo();
		teacherInfo.setCollegeName(collegeName);
		teacherInfo.setHeadicon("");
		teacherInfo.setIdno("");
		teacherInfo.setMail(mail);
		teacherInfo.setName(name);
		teacherInfo.setPassword(password);
		teacherInfo.setPhone(phone);
		teacherInfo.setSchoolName("\""+schoolName+"\"");
		teacherInfo.setStaffid(Integer.parseInt(staffid));
		teacherInfo.setTeacherid(null);
		teacherInfo.setUserid(null);
		teacherInfo.setUsername(username);
		System.out.println("collegeName:"+ collegeName);
		System.out.println("mail:"+ mail);
		System.out.println("name:"+ name);
		System.out.println("password:"+ password);
		System.out.println("phone:"+ phone);
		System.out.println("schoolName:"+ schoolName);
		System.out.println("staffid:"+ staffid);
		System.out.println("username:"+ username);
		teacherService.addNewTeacher(teacherInfo);
		return "";
	}
}
