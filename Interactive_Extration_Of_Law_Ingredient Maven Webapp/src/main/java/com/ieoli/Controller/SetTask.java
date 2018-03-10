package com.ieoli.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.flow.builder.ReturnBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.ieoli.Utils.MailConfig;
import com.ieoli.entity.ResultEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.ResultsService;
import com.ieoli.service.TextsService;
@Controller
public class SetTask {
	@Resource
	TextsService ts;
	@Resource
	ResultsService rs;
	@RequestMapping(value= "/setTask",produces="text/html;charset=UTF-8")
	ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		int id = Integer.parseInt(request.getParameter("models"));
		UserEntity user=(UserEntity)session.getAttribute("user");
		int userid=user.getUserid();
		List<TextEntity> te = ts.getTextByModel(id);
		List<ResultEntity> results=rs.getResultByModelID(id);
		session.setAttribute("results", results);
		session.setAttribute("modelid", id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("results",results);
		if(te==null)
		{
			
			mav.addObject("result", "该要素尚未上传文本");
			mav.setViewName("/WEB-INF/jsp/selectType.jsp");//打标签页面
			return mav;
		}else {

			session.setAttribute("text", te);
			List<TextEntity> wordList = new ArrayList<TextEntity>();
			if(te.size()<2)
			{
				wordList.addAll(te);
				session.setAttribute("index", 0);
			}else {
				wordList.add(te.get(0));
				wordList.add(te.get(1));
				session.setAttribute("index", 0);
			}
			mav.addObject("list", wordList);
			mav.setViewName("/WEB-INF/jsp/dabiaoqian.jsp");//打标签页面
			return mav;
		}
		
	}
}
