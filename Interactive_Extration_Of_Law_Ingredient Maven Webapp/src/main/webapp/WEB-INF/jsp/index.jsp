<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>

    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <div class="form row">    
        	<h3 class="form-title"align="center">登录</h3>
            <div class="form-horizontal col-md-offset-3" id="login_form" >
            <form role="form" id="login" action="weblogin" method="post" class="login-form">
                <div class="col-md-9">
                    <div class="form-group">
                    	<i class="fa fa-user fa-lg"></i><!--图标-->
                        <input class="form-control required" type="text" placeholder="用户名" id="username" name="username" autofocus="autofocus" maxlength="20"/>
                    </div>
                    <div class="form-group">
                    	<i class="fa fa-lock fa-lg"></i>
                        <input class="form-control required" type="password" placeholder="密码" id="password" name="password" maxlength="8"/>
                        <br><font color="red">${Result }</font>
                    </div>
                    <div class="form-group">
                        <label class="checkbox">
                            <input type="checkbox" name="remember" value="1"/>记住密码
                        </label>
                    </div>
                    <div class="form-group col-md-offset-9">
                        <button onclick="window.location.href='page?path=forgetnumber' " type="button" class="btn btn-forget pull-left" name="forget">忘记密码</button>
                        <button onclick="window.location.href='page?path=signup' " type="button" class="btn btn-login pull-right" name="login">注册</button>
                    	
                      </div>
                    <div class="form-group col-md-offset-6"align="center">
                        <button onclick="window.location.href='selectType.html' " type="submit" class="btn btn-success " name="submit">登录</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>