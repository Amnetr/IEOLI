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
<<<<<<< HEAD
		TextEntity te = ts.getTextsByUser(userid,id);
=======
		List<TextEntity> te = ts.getTextByModel(id);
		List<ResultEntity> results=rs.getResultByModelID(id);
		//session.setAttribute("results", results);
		session.setAttribute("modelid", id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("results",results);
>>>>>>> c44bd2cf0dd6c5c693298203efc986365d04f3ec
		if(te==null)
		{
			ModelAndView maf = new ModelAndView();
			maf.addObject("result", "没有文本需要打标签");
			maf.setViewName("/WEB-INF/jsp/task.jsp");//打标签页面
			return maf;
		}else {
			session.setAttribute("text", te);
<<<<<<< HEAD
			session.setAttribute("model", id);
			String[] stringlist;
			String article = te.getArticle();
			stringlist  = article.split("\\$");
			ArrayList<String> wordList = new ArrayList<String>();
			for(int i = 0 ; i<stringlist.length;i++)
=======
			mav.addObject("results", result);
			List<TextEntity> wordList = new ArrayList<TextEntity>();
			if(te.size()<2)
>>>>>>> c44bd2cf0dd6c5c693298203efc986365d04f3ec
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
