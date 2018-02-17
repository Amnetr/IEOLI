package com.ieoli.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ieoli.service.ModelService;

public class UploadModels {
	@Resource
	ModelService ms;
	@RequestMapping("/UploadModels")
	ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		String description  = request.getParameter("description");
		ms.insertModel(description);
		ModelAndView mav = new ModelAndView();
		mav.addObject("Result","true");
		return mav;
	}
}
