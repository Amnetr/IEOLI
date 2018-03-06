package com.ieoli.Controller;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ieoli.entity.ResultEntity;
import com.ieoli.entity.TextEntity;
import com.ieoli.entity.UserEntity;
import com.ieoli.service.ResultsService;
import com.ieoli.service.TextsService;
import com.ieoli.service.UserService;

@Controller
public class InsertResult {

	@Resource
	private TextsService ts;
	//private TextBehavior textBehavior;
	@Resource
	private UserService us;
	//private UserBehavior userBehavior;
	@Resource
	private ResultsService rs;
	
	@RequestMapping(value="/submitResult")
	public void insertResult(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		String result=request.getParameter("result");
		
		UserEntity User=(UserEntity)session.getAttribute("user");
		int userid=User.getUserid();
		
		TextEntity Text=(TextEntity)session.getAttribute("text");
		int textid=Text.getTextid();
		String outcome=null;
		TextEntity text=ts.getTextByID(textid);
		//TextEntity text=textBehavior.getByID(textid);
		int count=text.getCount();
		if(count>=3){
			outcome="该文书已被标注完毕！";
		}else{
			ResultEntity newResult=new ResultEntity();
			newResult.setLabel(getlabel(result));
			newResult.setTextid(textid);
			newResult.setUserid(userid);
			rs.insertResult(newResult);
			
			text.setCount(count+1);
			ts.updateText(text);
			//textBehavior.update(text);
			outcome="标注成功！";
		}
		
	      if(text.getCount()==3){
	    	List<ResultEntity> results=rs.getResultByTextID(textid);
	    	if(results.size()==3){
	    		int eval=evaluate(results);
	    		switch(eval){
	    		case -1://全错
	    			for(int i=0;i<3;i++){
	    				text.setCount(0);
	    				ts.updateText(text);
	    				//textBehavior.update(text);
	    				rs.deleteResultByID(results.get(i).getResultid());
	    				//对标注人员操作
	    				UserEntity user=us.getUserByID(results.get(i).getUserid());
	    				//UserEntity user=userBehavior.getByID(results.get(i).getUserid());
	    				user.setWronganswer(user.getWronganswer()+1);
	    				us.updateUser(user);
	    				//userBehavior.update(user);
	    			}
	    			break;
	    		case 100://全对
	    			for(int i=0;i<3;i++){
	    				results.get(i).setIstrue(true);
	    				rs.updateResult(results.get(i));
	    				UserEntity user=us.getUserByID(results.get(i).getUserid());
	    				//UserEntity user=userBehavior.getByID(results.get(i).getUserid());
    					user.setRightanswer(user.getRightanswer()+1); 
    					us.updateUser(user);
    					//userBehavior.update(user);
	    			}
	    			String path=session.getServletContext().getRealPath("/")+ "TextFiles\\"+text.getTextname();
	    			ts.generateFile(textid,results.get(0).getResultid(),path);
	    			//textBehavior.generateFile(textid,results.get(0).getResultid(),path);
	    			break;
	    		default:
	    			
	    			for(int i=0;i<3;i++){
	    				if(i==eval){
	    					results.get(i).setIstrue(false);
		    				rs.updateResult(results.get(i));
	    					UserEntity user=us.getUserByID(results.get(i).getUserid());
	    					//UserEntity user=userBehavior.getByID(results.get(i).getUserid());
	        				user.setWronganswer(user.getWronganswer()+1);
	        				us.updateUser(user);
	        				//userBehavior.update(user);
	    				}else{
	    					results.get(i).setIstrue(true);
		    				rs.updateResult(results.get(i));
	    					UserEntity user=us.getUserByID(results.get(i).getUserid());
	    					//UserEntity user=userBehavior.getByID(results.get(i).getUserid());
	    					user.setRightanswer(user.getRightanswer()+1);
	    					us.updateUser(user);
	    					//userBehavior.update(user);
	    				}
	    			}
	    			String paths=session.getServletContext().getRealPath("/")+ "TextFiles\\"+text.getTextname();
	    			ts.generateFile(textid,results.get(0).getResultid(),paths);
	    			break;
	    		}
	    	}
	    }
	   
		response.getOutputStream().write(outcome.getBytes("utf-8"));
	
	}
	
	private int evaluate(List<ResultEntity> results){
	/*	//拆分
		String result1[]=results.get(0).getLabel().split("\\$");
		String result2[]=results.get(1).getLabel().split("\\$");
		String result3[]=results.get(2).getLabel().split("\\$");
		//排序
		Arrays.sort(result1);
		Arrays.sort(result2);
		Arrays.sort(result3);
		//连接
		String sortedResult1 = null;
		for(int i=0;i<result1.length;i++){
			sortedResult1+=result1[i];
		}
		String sortedResult2 = null;
		for(int i=0;i<result2.length;i++){
			sortedResult2+=result2[i];
		}
		String sortedResult3 = null;
		for(int i=0;i<result3.length;i++){
			sortedResult3+=result3[i];
		}*/
		//MD5加密
		String encryptedResult1=MD5(results.get(0).getLabel());
		String encryptedResult2=MD5(results.get(1).getLabel());
		String encryptedResult3=MD5(results.get(2).getLabel());
		//比较
		boolean comp12=encryptedResult1.equals(encryptedResult2);
		boolean comp13=encryptedResult1.equals(encryptedResult3);
		boolean comp23=encryptedResult2.equals(encryptedResult3);
		if(comp12&&comp13&&comp23){
			return 100;//都一样
		}else if(comp12&&!comp13&&!comp23){
			return 2;//第三个不一样
		}else if(!comp12&&comp13&&!comp23){
			return 1;//第二个不一样
		}else if(!comp12&&!comp13&&comp23){
			return 0;//第一个不一样
		}else{
			return -1;//都不一样
		}
		
	}
	
	private String getlabel(String result){
		String result1[]=result.split("\\$");
		String labels = "";
		for(int i=1;i<result1.length;i++){
			if(result1[i].contains("&")){
				String a[]=result1[i].split("\\&");
				labels+=String.valueOf(i)+"_"+a[1]+"$";
			}
		}
		
		return labels;
		
	}
	
	 private  static String MD5(String s) {  
	        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
	        try {  
	            byte[] btInput = s.getBytes("utf-8");  
	            // 获得MD5摘要算法的 MessageDigest 对象  
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
	            // 使用指定的字节更新摘要  
	            mdInst.update(btInput);  
	            // 获得密文  
	            byte[] md = mdInst.digest();  
	            // 把密文转换成十六进制的字符串形式  
	            int j = md.length;  
	            char str[] = new char[j * 2];  
	            int k = 0;  
	            for (int i = 0; i < j; i++) {  
	                byte byte0 = md[i];  
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
	                str[k++] = hexDigits[byte0 & 0xf];  
	            }  
	            return new String(str);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
	
}
