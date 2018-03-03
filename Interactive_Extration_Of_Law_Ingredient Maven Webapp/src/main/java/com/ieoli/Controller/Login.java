package com.ieoli.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ieoli.entity.ModelEntity;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.ModelService;
import com.ieoli.service.UserService;

@Controller
public class Login{
@Resource
UserService userService;
@Resource
ModelService ms;
	@RequestMapping("/weblogin")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView();
		String username= request.getParameter("username");
		String passwdString = request.getParameter("password");
		
		UserEntity user = new UserEntity();
		user.setUsername(username);
		user.setUserpassword(passwdString);
		if(userService.login(user))
		{
			int actortype =userService.getUserByUsername(username).getUsertype();
			List<ModelEntity> lists = ms.getModels();
			mav.addObject("list", lists);
			if(actortype==1)
			{
				
				mav.setViewName("/WEB-INF/jsp/chakanModel.jsp");//上传人员的主页
			}else {
				
				mav.setViewName("/WEB-INF/jsp/selectType.jsp");//打标签人员主页
			}
			session.setAttribute("user", userService.getUserByUsername(username));
			mav.addObject("Result", "success");
			mav.addObject("username", username);
		}else {
			mav.setViewName("/WEB-INF/jsp/index.jsp");//失败
			mav.addObject("Result", "账号或密码错误！");
		}
		return mav;
	}

}
