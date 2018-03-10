<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
	<head>
	<meta charset="utf-8">
	<title>标注人员·打标签</title>
	<link href="system-default.css">
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<!--下拉复选框插件-->>
	</head>
	<body>
<nav class="navbar navbar-default" role="navigation">
      <div class="container-fluid">
    <div class="navbar-header"> <a class="navbar-brand" href="page?path=selectType">标注人员系统</a> </div>
    <div>
          <ul class="nav navbar-nav pull-right">
        <li><a>欢迎你</a></li>
        <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown" > ${user.username}<b class="caret"></b> </a>
              <ul class="dropdown-menu" style="text-align: center">
            <a href="index.action" style="text-decoration: none;text-align: center;color: black"  >退出登录</a>
          </ul>
            </li>
      </ul>
        </div>
  </div>
    </nav>

<!--标题栏-->
<div class="headline">
      <div class="row" style="background-color: #575757;margin-top: -20px;height: 100vh;">
    <div class="col-md-2"></div>
    <div class="middle col-md-8" style="background-color: white;height: 100%;	box-shadow: 0px 6px 5px lightgrey inset;background-image: url(bg.png)">
          
          
          
          <h3 style="top: auto; font-family: youyuan;">为以下文本打标签</h1>
          <!--文本框-->
                   <div class="input-border">
          <c:forEach items="${results}" var="result" varStatus="status">
       
		${result.description}
<br><br>
      </c:forEach>
           </div>
         <div class="input-border">
          <c:forEach items="${list}" var="word" varStatus="status">
       
		${word.article}
<br><br>
      </c:forEach>
           </div>
           <!--打标签框-->
         <div class="input-border">
         <input type="text" id="b-content"placeholder="请输入标签文本">

	 <div class="buttons"align="center">
		 <button id="tijiao" class="btn btn-default" onClick="tijiao()">提交</button>
		 	 <button id="ceshi" class="btn btn-default" onClick="ceshi()">测试</button>
		  <button id="fanye" class="btn btn-default" onClick="window.location.href='page?path=nextpage	'">翻页</button>
			 </div>
           </div>
        
           
           
        </div>
		  
    <div class="col-md-2"></div>
  </div>
    </div>
<!--选择模型类型-->
    <script type="text/javascript">  
                    /*$(function (){   
                        var ulstring=("<div align='centre'>"+"<input id='${status.count}shuru' type='text' align='left' style='width:130px;height:30px'></input>"  
					        +"<button id='biaoqianButton' style='width:45px;height:30px;' onclick=\"revise('${status.count}','${status.count}shuru' )\" >确认</button>"+"</div>");  
                        $("#${status.count}").popover({   
                            trigger:'manual',
                            placement : 'bottom',    
                            title:'<div style="text-align:left; color:gray; font-size:10%;">标签</div>',  
                            html: 'true',   
                            content : ulstring,  
                            animation: false  
                    								    }) .on("mouseenter", function () {  
                                    var _this = this;  
                                    $(this).popover("show");  
                                    $(this).siblings(".popover").on("mouseleave", function () {  
                                        $(_this).popover('hide');  
                                   																 }
                                   								);  
                        														        }
                        										).on("mouseleave", function () {  
                                    var _this = this;  
                                    setTimeout(function () {  
                                        if (!$(".popover:hover").length) {  
                                            $(_this).popover("hide")  
                                        									}  
                                   							 }, 100
                                   				);  
                                   																 }
                                   									)   
                   							 }); 	
                    
                    */
		 //回车事件
	document.onkeydown=keyListener;
   function keyListener(e){
    if(e.keyCode == 13){
     revise();
    }
   }
   
   function revise(btn,shuru){
		//alert(obj.id+obj.name);
		//var id = obj.id	
	document.getElementById(btn).style.backgroundColor="#EFB336";
	document.getElementById(btn).textContent=document.getElementById(btn).textContent+"&"+document.getElementById(shuru).value; 
		
	};		
	
		function tijiao(){
		//alert(obj.id+obj.name);
		//var id = obj.id	
        //  var lists=document.getElementsByTagName("button").InnerText;
			var content=document.getElementById("b-content");
			$.ajax({
				url:"submitResult",
				data:{content},
				method:"post",
				//dataType:"json"
				success:function(result){
					
						alert(result);
		
					
				}
			});
		
	};
		
		function ceshi(){
		//alert(obj.id+obj.name);
		//var id = obj.id	
        //  var lists=document.getElementsByTagName("button").InnerText;
		
			var content=document.getElementById("b-content");
		var lists=content.join("$");
			$.ajax({
				url:"submitTest",
				data:{content},
				method:"post",
				//dataType:"json"
				success:function(result){
					
						alert(result);
					
				}
			});
		
	};
			function fanye(){
		//alert(obj.id+obj.name);
		//var id = obj.id	
        //  var lists=document.getElementsByTagName("button").InnerText;
		
			$.ajax({
				url:"page?path=nextpage",
				method:"post",
				//dataType:"json"
				success:function(result){

					
				}
			});
		
	};
                   </script>
</body>

<style>
	.input-border{
		border:2px solid #C9C9C9;margin: 20px;padding: 10px
	}
	.row{
		overflow-y: auto;
	}
	#tijiao{
		background-color: #EFB336;
		border:none;
	}
	.middle{
		overflow-y: auto;
	}
</style>
</html>