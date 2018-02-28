package com.ieoli.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ieoli.Utils.EncoderPlus;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.UserService;

@Controller
public class Signup {
	@Resource
	UserService userService;
@RequestMapping("Signup")
public  void getCode(HttpServletRequest request,
		HttpServletResponse response,HttpSession session) throws Exception {
	int yanzheng = (int)session.getAttribute("code");
	String code = request.getParameter("code");
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	String actor = request.getParameter("actor");
	UserEntity user = new UserEntity();
	user.setUsername(username);
	user.setUserpassword(EncoderPlus.getMD5(password));
	user.setUsertype(Integer.parseInt("1"));//sasfaf
	String failed = "邮箱已存在";
	if(userService.getUserByUsername(username)!=null)
	{
		response.getOutputStream().write(failed.getBytes());

	}
	if(Integer.parseInt(code)==yanzheng)
	{
		userService.Signup(user);
	
		String st="success";
		response.getOutputStream().write(st.getBytes());
		
	}else {
		
		String st="验证码错误！";
		response.getOutputStream().write(st.getBytes());
	}
	
	//yanzheng为发到邮箱的验证码
}
}
