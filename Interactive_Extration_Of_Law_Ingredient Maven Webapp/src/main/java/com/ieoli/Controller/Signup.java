package com.ieoli.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Signup {
@RequestMapping("/Signup")
public  ModelAndView getCode(HttpServletRequest request,
		HttpServletResponse response,HttpSession session) throws Exception {
	int yanzheng = (int)session.getAttribute(session.getId());
	String code = request.getParameter("code");
	ModelAndView mavAndView = new ModelAndView();
	mavAndView.setViewName("/WEB-INF/jsp/index.jsp");
	
	if(Integer.parseInt(code)==yanzheng)
	{
		mavAndView.addObject("Result", "True");
	}else {
		mavAndView.addObject("Result", "False");
	}
	return mavAndView;
	//yanzheng为发到邮箱的验证码
}
}
