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
    <title>投放人员·上传、修改模型</title>
	<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link href="system-default.css">
	
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--下拉复选框插件-->
	<script type="text/javascript" src="bootstrap-multiselect-master/dist/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css" type="text/css"/>
</head>
<body>
<script type="text/javascript" charset="UTF-8" >
function smedit()
{
	var desc = document.getElementById("textar").value;
	var radios 		 = document.getElementsByName("models");
	var modelid=-1;
	for(var i=0;i<radios.length;i++){
    if(radios[i].checked){
      modelid = radios[i].value;
    break;
    }
    }
	$.ajax({
			url:"UploadModels",
			data:{modelid:modelid,description:desc},
			method:"post",
			//dataType:"json"
			success:function(result){
			window.location.reload();  
			alert("成功");
			
			}
		});
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
                    <li><a href="userInformation?userID=${user.userid }">查看我的信息</a></li>
                    <li><a href="#"></a></li>
                    <li class="divider"></li>
                    <li><a href="userChangeInformation?userID=${user.userid }">修改我的信息</a></li>
                    <li class="divider"></li>
                    <li><a href="#">退出登录</a></li>
                </ul>
            </li>
        </ul>
    </div>
	</div>
</nav>
<!--标题栏-->
     <div class="headline">
     <div class="row">
     	<div class="col-md-2"></div>
     	<div class="col-md-8">
     	<div style="margin:20px">
     		<table align="center" width="960px">
     		<tr>
				<td align="center"><p><font face="幼圆" size="+2" color=#9A9A9A style="font-weight:bold">上传模型</font></p></td>
				<td align="center" valign="top"><img src="./img/1.png"/></td>
				<td align="center"><p><font face="幼圆" size="+2" style="font-weight: bolder">查看/修改模型</font></p></td>
				<td align="center" valign="top"><img src="./img/2.png"/></td>
				<td align="center"><p><font face="幼圆" size="+2" color=#9A9A9A style="font-weight: bold">查看/下载</font></p></td>
     		</tr>
     		</table>
     		</div>
     		
     		<div style="margin: 40px">
     
  <div class="form-group">
    <label for="name" style="font-size: 20px">选择文本模型(若不选则为新增模型)</label>
    
    <div class="form-group" style="margin: 30px">    
     <table align="center" width="960px">
     		<tr>
				<td align="left">  <c:forEach items="${list}" var="model">
				<div class="caption" align="left">
				<label><input id="radios" name="models" type="radio" value="${model.modelid}"/>序号:${model.modelid} </label> 
								<p id="modeldescription">介绍：${model.modeldescription}</p>
								<p align="center">
								</p>
								</div>
				</c:forEach></td>
				
			
     		</tr>
     		</table>
    </div>
    
      <div class="form-group" style="margin: 30px">    
      <label for="name" style="font-size:20px;"  >规则</label>
      <textarea class="form-control" rows="10" id="textar" name=uploadarea style="width: 810px"></textarea>
    
    </div>
    
  </div>
  
  <button onclick="smedit()" class="btn btn-default" name="button">新增/修改</button>
   			</div>
    			
     </div>
     <div class="col-md-2"></div>
     </div>
  <!--选择模型类型-->

</body>
</html>