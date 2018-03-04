package com.ieoli.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ieoli.entity.ModelEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.service.ModelService;
import com.ieoli.service.TextsService;

@Controller
public class HandLedText {
	@Resource
	private TextsService ts;
	@Resource
	ModelService ms;
	@SuppressWarnings("null")
	@RequestMapping("/ShowHandLedText")
	public ModelAndView ShowHandLedText(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		
		
		response.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		String modelid = request.getParameter("modelid");
		List<ModelEntity> lists = ms.getModels();
		mav.addObject("list", lists);
		List<TextEntity> texts=ts.getHandledText(Integer.parseInt(modelid));
	//	ArrayList<String> textNames = new ArrayList<String>();
	/*	for(int i=0;i<texts.size();i++){
			textNames.add(texts.get(i).getTextname());
		}*/
		mav.addObject("texts",texts);
		mav.setViewName("WEB-INF/jsp/download.jsp");
		return mav;
	}
}
