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

import com.ieoli.Utils.MailConfig;
import com.ieoli.entity.ModelEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.service.ModelService;
import com.ieoli.service.TextsService;

@Controller
public class PageController{
@Resource
ModelService ms;
	@RequestMapping(value="/page")
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		// TODO Auto-generated method stub
		String a = request.getParameter("path");
		String pages = "/WEB-INF/jsp/"+a+".jsp";
		ModelAndView mav = new ModelAndView();
		mav.setViewName(pages);
		switch(a)
		{
		case "selectType":
			mav.addObject("user",session.getAttribute("user"));
		case "upload-text":
		case "chakanModel":
		case "download":
			List<ModelEntity> lists = ms.getModels();
			mav.addObject("list", lists);
			break;
		case "nextpage":
			mav.setViewName("/WEB-INF/jsp/dabiaoqian.jsp");
			int index = (int) session.getAttribute("index");
			List<TextEntity> list=(List<TextEntity>) session.getAttribute("text");
			List<TextEntity> wordlist=new ArrayList<TextEntity>();
			if(list.size()<2)
			{
				wordlist.addAll(list);
				
			}else {
				wordlist.add(list.get(index%list.size()));
				wordlist.add(list.get((index+1)%list.size()));
			}
		index=index+2;
		session.setAttribute("index", index);
		mav.addObject("list", wordlist);
		break;
		case "beforepage":
			mav.setViewName("/WEB-INF/jsp/dabiaoqian.jsp");
			int indexx = (int) session.getAttribute("index");
			List<TextEntity> listt=(List<TextEntity>) session.getAttribute("text");
			List<TextEntity> wordlistt=new ArrayList<TextEntity>();
			if(indexx<2)
			{
				indexx = indexx +listt.size();
			}
			if(listt.size()<2)
			{
				wordlistt.addAll(listt);
				
			}else {
				wordlistt.add(listt.get((indexx-1)%listt.size()));
				wordlistt.add(listt.get((indexx-2)%listt.size()));
			}
			indexx=indexx-2;
		session.setAttribute("index", indexx);
		mav.addObject("list", wordlistt);
		break;
		}
		return mav;
	}
}
