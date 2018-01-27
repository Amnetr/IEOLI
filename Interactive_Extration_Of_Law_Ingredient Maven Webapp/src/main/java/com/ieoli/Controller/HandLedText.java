package com.ieoli.Controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.ieoli.entity.TextEntity;
import com.ieoli.service.TextsService;

@Controller
public class HandLedText {
	@Resource
	private TextsService ts;
	@SuppressWarnings("null")
	@RequestMapping("/ShowHandLedText")
	public void ShowHandLedText(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		response.setCharacterEncoding("UTF-8");
		
		
		List<TextEntity> texts=ts.getHandledText();
		List<String> textNames = null;
		for(int i=0;i<texts.size();i++){
			textNames.add(texts.get(i).getTextname());
		}
		
		String jsonString=JSON.toJSONString(textNames);
		response.getWriter().write(jsonString);
		response.getWriter().close();
	}
}
