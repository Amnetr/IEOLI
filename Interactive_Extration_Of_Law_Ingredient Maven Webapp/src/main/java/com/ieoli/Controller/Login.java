package com.ieoli.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ieoli.entity.UserEntity;
import com.ieoli.service.UserService;

@Controller
public class Login{
@Resource
UserService userService;
	@RequestMapping("/weblogin")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		String username= request.getParameter("username");
		String passwdString = request.getParameter("password");
		String actorString =request.getParameter("actor");
		UserEntity user = new UserEntity();
		user.setUsername(username);
		user.setUserpassword(passwdString);
		if(userService.login(user))
		{
			if(actorString.equals("1"))
			{
				mav.setViewName("/WEB-INF/jsp/uploadhome.jsp");//上传人员的主页
			}else {
				mav.setViewName("/WEB-INF/jsp/labelhome.jsp");//打标签人员主页
			}
			session.setAttribute("user", userService.getUserByUsername(username));
			mav.addObject("Result", "success");
			mav.addObject("username", username);
		}else {
			mav.addObject("Result", "failed");
		}
		return null;
	}

}
