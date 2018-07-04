package cn.yyy.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageControll {
	
	@RequestMapping("/logoutUser.action")
	public String logoutUser(HttpSession session) {
		session.removeAttribute("user");
		return "logout";
	}
	@RequestMapping("/unlogin.action")
	public String unLoginUser(HttpSession session) {
		return "unlogin";
	}
}
