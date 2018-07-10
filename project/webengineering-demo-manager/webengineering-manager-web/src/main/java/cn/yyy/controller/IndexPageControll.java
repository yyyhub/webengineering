package cn.yyy.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.yyy.pojo.TeacherInfo;
import cn.yyy.service.CollegeService;
import cn.yyy.service.CourseService;
import common.utils.FileUtil;

@Controller
public class IndexPageControll {
	@Autowired
	private CourseService courseService;
	@Autowired
	private CollegeService collegeService;
	
	@RequestMapping("/logoutUser.action")
	public String logoutUser(HttpSession session) {
		session.removeAttribute("user");
		return "logout";
	}
	@RequestMapping("/unlogin.action")
	public String unLoginUser(HttpSession session) {
		return "unlogin";
	}
	
	@RequestMapping("/createCourse")
	@ResponseBody
	public String createCourse(MultipartFile coursepicture,String coursename,HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		System.out.println(coursepicture.getOriginalFilename());
		boolean flag = false;
		String url=null;
		if (coursepicture!=null &&!coursepicture.isEmpty()) {
			if (coursepicture.getSize()/1024/1024>5) {
				System.out.println("文件太大");
				flag = false;
			}else {
				String path = request.getSession().getServletContext().getRealPath("/classpic");
				System.out.println(path);
				String fileName = coursepicture.getOriginalFilename();
				try {
					InputStream is = coursepicture.getInputStream();
					String newFileName = FileUtil.uploadFile(is, fileName, path);
					url = newFileName;
				}catch (IOException e1) {
					flag = false; e1.printStackTrace();	
					}
				
				
			}
		}
		Integer teacherid = ((TeacherInfo)(session.getAttribute("user"))).getTeacherid();
		Integer collegeid = collegeService.getCollegeIdByCollegeName(((TeacherInfo)(session.getAttribute("user"))).getCollegeName());
		Integer courseid = -1;
		String msg = "";
		if (teacherid!=null &&collegeid!=null) {
			System.out.println("创建课程");
			courseid = courseService.addNewCourse(coursename, teacherid, collegeid);
			System.out.println(courseid);
		}
			
		if (courseid == null)
			msg = "创建失败，已创建该课程";
		else if (courseid == -1)
			msg = "创建课程失败";
		//String result = "{\"msg\":"+msg+"}";
		return "";
	}
}
