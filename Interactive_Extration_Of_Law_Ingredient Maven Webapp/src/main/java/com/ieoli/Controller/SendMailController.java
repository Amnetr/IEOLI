package com.ieoli.Controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ieoli.Utils.MailUtil;

@Controller
public class SendMailController {
@RequestMapping("/SendMail")
public  void getCode(HttpServletRequest request,
		HttpServletResponse response,HttpSession session) throws Exception {
	String mail = request.getParameter("Mail");
	String failed="InvalidMail";
	if(mail ==""||mail==null)
	{
		response.getOutputStream().write(failed.getBytes());
	}
	int number;
	Random random =new Random(System.currentTimeMillis());
	number = random.nextInt()%9000;
	if(number<0)
	{
		number = -number;
	}
	number +=1000;
	String subject = "医学要素提取系统注册验证码";
	String html = "您的验证码是：  "+number;
	try{
		session.setAttribute(session.getId(), number);
		MailUtil.sendMail(mail, subject, html);
	}catch(Exception e)
	{
		response.getOutputStream().write(failed.getBytes());
		e.printStackTrace();
	}
		
}
}
