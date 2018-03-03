package com.ieoli.Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.ieoli.entity.ModelEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.service.ModelService;
import com.ieoli.service.TextsService;

@Controller
public class PageController extends AbstractController{
@Resource
ModelService ms;
	@RequestMapping(value="/page")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String a = request.getParameter("path");
		String pages = "/WEB-INF/jsp/"+a+".jsp";
		ModelAndView mav = new ModelAndView();
		mav.setViewName(pages);
		switch(a)
		{
		case "upload-text":
		case "chakanModel":
		case "download":
			List<ModelEntity> lists = ms.getModels();
			mav.addObject("list", lists);
			break;
		}
		return mav;
	}
}
