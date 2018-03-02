<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
	<script type="text/javascript" src="bootstrap-multiselect-master/dist/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="bootstrap-multiselect-master/dist/css/bootstrap-multiselect.css" type="text/css"/>
</head>
<body>

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
                    人员名字<b class="caret"></b>
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
				<td align="center"><p><font face="幼圆" size="+2" style="font-weight:bold">上传模型</font></p></td>
							<td align="center" valign="top"><img src="./img/1.png"/></td>
				<td align="center"><p><font face="幼圆" size="+2" color=#9A9A9A style="font-weight: bolder">查看/修改模型</font></p></td>
								<td align="center" valign="top"><img src="./img/2.png"/></td>
				<td align="center"><p><font face="幼圆" size="+2" color=#9A9A9A style="font-weight: bold">查看/下载</font></p></td>
     		</tr>
     		</table>
     		</div>
    			<div class="composing" style="height: 40px;"></div>
     		  <div class="model-class">
  	<p>选择文本模型</p>
  <select id="select-single">
    <option value="1">Option 1</option>
    <option value="2">Option 2</option>
    <option value="3">Option 3</option>
    <option value="4">Option 4</option>
    <option value="5">Option 5</option>
    <option value="6">Option 6</option>
</select>
  	<button class="complete">完成</button>
  </div>
   	<div class="composing" style="height: 40px;"></div>
   	<p>选择文本上传格式</p>
    	<div class="upload">
    	<input type="text" name="text-name" placeholder="请输入文本名称">
    	<textarea class="form-control" rows="3" name=uploadarea></textarea>
    	<input type="text" name="upload-else" placeholder="请输入文本名称">
    	<textarea class="form-control" rows="3" name=uploadarea></textarea>
    	<button class="complete">修改</button>
    	<button class="complete">提交</button>
    	</div>
     	</div>
     	<div class="col-md-2"></div>
     </div>
     </div>
  <!--选择模型类型-->

</body>
<script type="text/javascript">
    $('#select-single').multiselect();
</script>
</html>