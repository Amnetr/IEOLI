package com.ieoli.Controller;

import java.io.File;
import java.io.IOException;

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

@Controller
public class DownloadController {

	@RequestMapping(value="/download")
	public ResponseEntity<byte[]> downloadd(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws IOException{
		String filename=request.getParameter("filename");
		String path=session.getServletContext().getRealPath("/")+ "texts\\"+filename;
		File file=new File(path);
		HttpHeaders headers =new HttpHeaders();
		
		String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
	    headers.setContentDispositionFormData("attachment", downloadFielName); 
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                headers, HttpStatus.CREATED); 

    }

}
