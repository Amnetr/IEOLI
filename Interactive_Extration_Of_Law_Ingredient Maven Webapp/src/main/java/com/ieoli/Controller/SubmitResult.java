package com.ieoli.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ieoli.entity.ResultEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.ResultsService;
import com.ieoli.service.TextsService;

@Controller
public class SubmitResult {

@Resource
ResultsService rs;
@Resource
TextsService ts;
@RequestMapping("submitresult")
protected void handleRequestInternal(HttpServletRequest request,
		HttpServletResponse response,HttpSession session) throws Exception {
		String code = request.getParameter("code");
		String description= request.getParameter("description");
		String article= request.getParameter("article");
		String regex="";// parse into regex
		Pattern pat = Pattern.compile(regex);
		if(code.equals("0"))//test
		{
			
			String[] articles = article.split("$");
			Matcher mat;
			String result = "";
			for(int i = 0 ; i<article.length();i++)
			{
				mat=pat.matcher(articles[i]);
				if(mat.find())
				{
					result+=mat.group();
				}
			}
			response.getWriter().write(result);
			
		}else {
			// submit
			ResultEntity re= new ResultEntity();
			re.setDescription(description);
			re.setRegex(regex);
			re.setUserid(((UserEntity)session.getAttribute("user")).getUserid());
			List<TextEntity> texts=ts.getTextByModel((int)session.getAttribute("modelid"));
			double right = 0;
			double all = texts.size();
			for(int i = 0 ; i <texts.size();i++)
			{
				String art= texts.get(i).getArticle();
				if (pat.matcher(art).matches())
				{
					right=right+1;
				}
			}
			double rate = right/all;
			re.setRate(rate);
			rs.insertResult(re);
			response.getWriter().write("success!");
			
			
		}
}
}
