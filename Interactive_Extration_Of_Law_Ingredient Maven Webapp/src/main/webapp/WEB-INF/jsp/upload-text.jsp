<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <title>投放人员·上传文本</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="system-default.css">
	
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--下拉复选框插件-->
</head>
<body>
<script type="text/javascript" charset="UTF-8" >
function upload()
{
	var form = document.getElementById('upload');
	var formData = new FormData(form); 
	var filename = document.getElementById('file').value;
	if(filename=='')
	{
	alert("请选择上传");
	return;
	}else
	{
	$.ajax({
			url:"UploadTexts",
			data:formData,
					type: 'POST',
                    cache: false,
						 contentType: false,  
				          processData: false,
			success:function(result){
			alert("上传成功");
			}
		});
	}
	
}

</script>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">投放人员系统</a>
    </div>
    <div>
        <ul class="nav navbar-nav pull-right">
           <li><a>欢迎你，投放人员</a></li>
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                 ${user.username}<b class="caret"></b>
                </a>
                <ul class="dropdown-menu pull-left">

                    <a href="index.action">退出登录</a>
                </ul>
            </li>
        </ul>
    </div>
	</div>
</nav>
<div id="timeline" class="container-timeline">
<div class="timeline-block">
	<div class="vertical-timeline-icon lazur-bg">
		<i class="fa fa-user-md" >
	</div>
</div>	
</div>
<!--标题栏-->
     <div class="headline">
     <div class="row">
     	<div class="col-md-2"></div>
     	<div class="col-md-8">
     		<div style="margin:20px">
     		<table align="center" width="960px">
     		<tr>
				<td align="center"><p><font face="幼圆" size="+2" style="font-weight:bold">上传文本</font></p></td>
							<td align="center" valign="top"><img src="./img/1.png"/></td>
				<td align="center"><a href="page?path=chakanModel"><font face="幼圆" size="+2" color=#9A9A9A style="font-weight: bolder">查看/修改模型</font></a></td>
								<td align="center" valign="top"><img src="./img/2.png"/></td>
				<td align="center"><a href="page?path=download"><font face="幼圆" size="+2" color=#9A9A9A style="font-weight: bold">查看/下载</font></a></td>
     		</tr>
     		</table>
     		</div>
    			<div class="composing" style="height: 40px;"><h3>请选择模型（请确保文本是utf-8编码，否则会出现乱码）</h3></div>
    			  <br><font color="red">${sus}</font>
     		  <div class="model-class">
			<form id="upload" role="form" action="" enctype="multipart/form-data" method="post"> 
     		<tr>
				<td align="left">  <c:forEach items="${list}" var="model">
				<div class="caption" align="left">
				<label><input id="radios" name="models" type="radio" value="${model.modelid}" checked="checked"/>序号:${model.modelid} </label> 
								<p id="modeldescription">介绍：${model.modeldescription}</p>
								<p align="center">
								</p>
								</div>
				</c:forEach>
				  <input type="file"   name="file" id="file" multiple/>	<br />	
				   <input type="button" id="Insert" class=" form-control btn btn-primary" value="上传文件" onclick="upload()" >
				</td>
				    
     		</tr>
     		</form>
  </div>
    	
     	</div>
     </div>
     </div>
  <!--选择模型类型-->

</body>
</html>