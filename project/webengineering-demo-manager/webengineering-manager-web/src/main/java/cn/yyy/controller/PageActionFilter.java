package cn.yyy.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class PageActionFilter
 */
public class PageActionFilter implements Filter {

    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	String uri = ((HttpServletRequest) request).getRequestURI();
    	System.out.println(uri);
    	String[] acceptURI = {"/","/studentreg.action","/teacherreg.action","/getLoginCheckCode.action","/getcheckcode.action",
    			"/checkUserNameLoginInfo.action","/sendLoginPhoneCheckCode.action","/checkPhoneLoginInfo.action",
    			"/getcheckcode.action","/sendPhoneCheckCode.action","/checkusername.action","/checkphonenumber.action",
    			"/checkccode.action","/checkPhoneCode.action","/addNewTeacher.action","/jumpToTeacherIndex.action",
    			"/unlogin.action","/logoutUser.action","addNewStudent.action"};
    	boolean isAccept = false;
    	for (String accpt: acceptURI) {
    		if (accpt.equals(uri))
    			isAccept = true;
    	}
    	if (!isAccept) {
    		Object userobj = ((HttpServletRequest) request).getSession().getAttribute("user");
    		if(userobj==null) {
    			((HttpServletResponse)response).sendRedirect("/unlogin.action");
    		}
    	}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
