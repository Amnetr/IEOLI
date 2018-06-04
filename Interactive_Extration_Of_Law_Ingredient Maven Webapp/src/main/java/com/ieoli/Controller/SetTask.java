package com.ieoli.Controller;

import java.util.ArrayList;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ieoli.entity.TextEntity;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.TextsService;
@Controller
public class SetTask {
	@Resource
	TextsService ts;
	@RequestMapping(value= "/setTask",produces="text/html;charset=UTF-8")
	ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		int id = Integer.parseInt(request.getParameter("models"));
		UserEntity user=(UserEntity)session.getAttribute("user");
		int userid=user.getUserid();
		TextEntity te = ts.getTextsByUser(userid,id);
		if(te==null)
		{
			ModelAndView maf = new ModelAndView();
			maf.addObject("result", "没有文本需要打标签");
			maf.setViewName("/WEB-INF/jsp/task.jsp");//打标签页面
			return maf;
		}else {
			session.setAttribute("text", te);
			session.setAttribute("model", id);
			String[] stringlist;
			String article = te.getArticle();
			stringlist  = article.split("\\$");
			ArrayList<String> wordList = new ArrayList<String>();
			for(int i = 0 ; i<stringlist.length;i++)
			{
				String[] temp = stringlist[i].split("\\_");
				wordList.add(temp[0]);
			}
			ModelAndView mav = new ModelAndView();
			mav.addObject("list", wordList);
			mav.setViewName("/WEB-INF/jsp/dabiaoqian.jsp");//打标签页面
			return mav;
		}
		
	}
}
