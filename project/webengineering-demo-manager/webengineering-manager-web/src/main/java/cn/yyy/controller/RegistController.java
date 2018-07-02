package cn.yyy.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.yyy.pojo.ImgCheckCode;
import cn.yyy.service.impl.RegisterServiceImp;
import common.utils.JsonUtil;

@Controller
public class RegistController {

	@RequestMapping("/getcheckcode")
	@ResponseBody
	public void getcheckcode(HttpSession session,HttpServletResponse response) {
		ImgCheckCode imgCheckCode=new ImgCheckCode();
		final int width=80;
		final int height=35;
		RegisterServiceImp registerservice=new RegisterServiceImp();
		imgCheckCode=registerservice.getImgCheckCode(width, height);
		System.out.println(imgCheckCode.getCheckCode());
		session.setAttribute("checkcodestr",imgCheckCode.getCheckCode());
		try {
			ImageIO.write( imgCheckCode.getCheckCodeImg(), "jpeg", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
	}

	@RequestMapping("/checkusername")
	@ResponseBody
	public String checkUserName(String username,HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> result=new HashMap<String, Object>();
		System.out.println(username);
		RegisterServiceImp registerservice=new RegisterServiceImp();
		boolean sign=registerservice.isExistUsername(username);
		
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
		RegisterServiceImp registerservice=new RegisterServiceImp();
		boolean sign=registerservice.isExistPhoneNumber(phonenumber);
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
		//RegisterServiceImp registerservice=new RegisterServiceImp();
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
}
