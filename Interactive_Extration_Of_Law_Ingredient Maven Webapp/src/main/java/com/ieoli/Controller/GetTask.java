package com.ieoli.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ieoli.entity.ModelEntity;
import com.ieoli.service.ModelService;

public class GetTask {

	@Resource
	ModelService ms;
	@RequestMapping("/getTasks")
	ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		String code = request.getParameter("code");
			int c = Integer.parseInt(code);
				List<ModelEntity> lists = ms.getModels();
				String jsonString = JSON.toJSONString(lists);
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(jsonString);
				response.getWriter().close();
				ModelAndView mav= new ModelAndView();
				if(c==0)
				{
					mav.setViewName("/WEB-INF/jsp/showModels.jsp");//显示模型页面
				}else {
					mav.setViewName("/WEB-INF/jsp/uploadTexts.jsp");//显示模型页面
				}
				
				return mav;
		
	}
}
