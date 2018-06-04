package com.ieoli.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class WebLoginController extends AbstractController{
	
	@RequestMapping("/login.action")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//获取请求的参数
		

		ModelAndView mav= new ModelAndView();
		
		Thread.currentThread();
		Thread.sleep(10000);
		mav.setViewName("/WEB-INF/jsp/MyJsp.jsp");
		return mav;
	}

}
