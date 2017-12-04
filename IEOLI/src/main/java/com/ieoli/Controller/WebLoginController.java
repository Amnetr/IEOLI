package com.ieoli.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class WebLoginController extends AbstractController{
	
	@RequestMapping("/weblogin")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//获取请求的参数
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		ModelAndView mav = new ModelAndView();
		
		String result;
		if(username.equals("root"))
		{			
			result = "ok";
				mav.setViewName("/index.jsp");
				mav.addObject("result", result);
			
		}else
		{
			result="密码或用户名错误";
			mav.setViewName("/index.jsp");
			mav.addObject("result", result);
		}

		
		
		
		return mav;
	}

}
