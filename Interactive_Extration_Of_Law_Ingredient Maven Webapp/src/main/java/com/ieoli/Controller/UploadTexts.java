package com.ieoli.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.ieoli.entity.TextEntity;
import com.ieoli.service.TextsService;

public class UploadTexts {
	@Resource TextsService tService;
	  @RequestMapping("/UploadTexts")
	    public void  springUpload(HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException
	    {
		  String modelid = request.getParameter("model");
		  int id = Integer.parseInt(modelid);
	        	         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
	        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
	                request.getSession().getServletContext());
	        //检查form中是否有enctype="multipart/form-data"
	        if(multipartResolver.isMultipart(request))
	        {
	            //将request变成多部分request
	            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
	           //获取multiRequest 中所有的文件名
	            Iterator iter=multiRequest.getFileNames();
	             
	            while(iter.hasNext())
	            {
	                //一次遍历所有文件
	                MultipartFile file=multiRequest.getFile(iter.next().toString());
	                if(file!=null)
	                {
	                	String path = session.getServletContext().getRealPath("/")+"texts\\"+file.getOriginalFilename();
	                	File f =new File(path);
	                	    	file.transferTo(f);
	                	    	TextEntity te = new TextEntity();
	                	    	te.setCount(0);
	                	    	te.setModelid(id);
	                	    	te.setTextname(file.getOriginalFilename());
	                	    	BufferedReader reader = null;
	                	    	String allString = "";
	                	    	try {
									reader = new BufferedReader(new FileReader(f));
									String tempString = null;
									while((tempString =reader.readLine())!=null)
									{
										allString+=tempString+"$";
									}
									reader.close();
								} catch (Exception e) {
									// TODO: handle exception
									e.printStackTrace();
								}finally{
									if(reader!=null)
									{
										 try {
							                    reader.close();
							                } catch (IOException e1) {
							                }
									}
								}
	                	    	te.setArticle(allString);
	                	    	tService.insertFile(te);
	                	    	  System.out.println(path);
	                	    	  
	                    //上传
	                    
	                }
	                 
	            }
	           
	        }
	 
	    }
}
