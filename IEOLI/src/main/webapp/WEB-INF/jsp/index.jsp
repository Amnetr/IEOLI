
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
    <title>东南大学本科生选课登录入口</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="./css/main.css" type="text/css">
    <script type="text/javascript" src="./js/jquery-1.3.2.min.js">
    </script>
   <!--  <script type="text/javascript">
        var enetdivTop,enetdivLeft,enetdivWidth,enetdivHeight,enetdocHeight,enetdocWidth,enetobjTimer,i = 0;
        function enetgetMsg()
        {
            try{
                enetdivTop = parseInt(document.getElementById("enetMeng").style.top,10)
                enetdivLeft = parseInt(document.getElementById("enetMeng").style.left,10)
                enetdivHeight = parseInt(document.getElementById("enetMeng").offsetHeight,10)
                enetdivWidth = parseInt(document.getElementById("enetMeng").offsetWidth,10)
                enetdocWidth = document.body.clientWidth;
                enetdocHeight = document.body.clientHeight;
                document.getElementById("enetMeng").style.bottom = parseInt(document.body.scrollTop,10) - 10;// enetdivHeight
                document.getElementById("enetMeng").style.right = parseInt(document.body.scrollLeft,10) - enetdivWidth
                document.getElementById("enetMeng").style.visibility="visible"
                enetobjTimer = window.setInterval("enetmoveDiv()",10);
            }
            catch(e){}
        }
        　
        function enetresizeDiv()
        {
            try{
                enetdivHeight = parseInt(document.getElementById("enetMeng").offsetHeight,10)
                enetdivWidth = parseInt(document.getElementById("enetMeng").offsetWidth,10)
                enetdocWidth = document.body.clientWidth;
                enetdocHeight = document.body.clientHeight;
                document.getElementById("enetMeng").style.bottom = parseInt(document.body.scrollTop,10)
                document.getElementById("enetMeng").style.right =  parseInt(document.body.scrollLeft,10)
            }
            catch(e){}
        }
        function enetmoveDiv()
        {
            try
            {
                if(parseInt(document.getElementById("enetMeng").style.top,10) >= (parseInt(document.body.scrollTop,10)))
                {
                    window.clearInterval(enetobjTimer)
                    enetobjTimer = window.setInterval("enetresizeDiv()",1)
                }
                enetdivTop = parseInt(document.getElementById("enetMeng").style.top,10)
                document.getElementById("enetMeng").style.top = enetdivTop + 1
            }
            catch(e){}
        }
        function enetcloseDiv()
        {
            document.getElementById('enetMeng').style.visibility='hidden';
            if(enetobjTimer) window.clearInterval(enetobjTimer)
        }
        function refreshCheckCode(checkCodeImg) {

            checkCodeImg.src="./getCheckCode?now=" + new Date();
        }

        function validate() {

            if (document.all.userId.value == "") {
                document.all.userId.focus();
                alert("请输入用户名！");
                return false;
            }
            if (document.all.userPassword.value == "") {
                document.all.userPassword.focus();
                alert("请输入登录密码！");
                return false;
            }

            if (document.all.checkCode.value == "") {
                document.all.checkCode.focus();
                alert("请输入验证码！");
                return false;
            }

        }

        function cancel() {
            window.returnValue = false;
            window.close();
        }

        function alertError(){
            var reason = $('#errorReason').val();
            if(reason != '' || reason == null){
                alert(reason);
            }
        }

        $(function(){
            alertError();
        });
    </script>
    --> 
</head>
<body  bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<form action="login.action" onsubmit="return validate();" method="post">
    <input type="hidden" id="errorReason" value="验证码错误!">

    <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td><table width="1000" height="554" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td valign="top" background="./images/login/bg.jpg"><table width="225" border="0" align="right" cellpadding="0" cellspacing="0">
                        <tr>
                            <td height="156" valign="top"><p>&nbsp;</p></td>
                        </tr>
                        <tr>
                            <td height="62" valign="top">
                                <input style="border:1px solid #dedede; font-size:15px; height:25px" name="userId" value="" type="text" size="20">
                            </td>
                        </tr>
                        <tr>
                            <td height="61" valign="top"><input style="border:1px solid #dedede; font-size:15px; height:25px" name="userPassword" type="password" size="20"></td>

                        </tr>
                        <tr>
                            <td height="45" valign="top">
                                <table width="167" height="27" border="0" cellpadding="0" cellspacing="0">
                                    <tr>
                                        <td width="92"><input style="border:1px solid #dedede;font-size:15px; height:25px"  name="checkCode" type="text" size="10"></td>
                                        <td width="75"><div align="right"><img src="./getCheckCode.jpg" width="73" height="29" title="点击更新验证码" onclick="refreshCheckCode(this);" style="cursor:hand"/></div></td>
                                    </tr>
                                </table></td>
                        </tr>
                        <tr>
                            <td valign="top"><table width="160" height="27" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td><div align="center"><input id="submit" type="image" src="./images/login/login.jpg" width="64" height="24"></div></td>
                                    <td><div align="center"><a onclick="window.location.href='showLogin.action';" style="cursor:hand"><img src="./images/login/reset.jpg" width="64" height="24" border="0"></a></div></td>

                                </tr>
                            </table></td>
                        </tr>
                        <tr>
                            <td height="8"></td>
                        </tr>
                        <tr>
                        </tr>
                        <tr>
                            <td height="13" valign="top" class="Context_txt">&nbsp;</td>
                        </tr>
                        <tr>
                            <td height="13" valign="top">
                                <table class="Context_txt" width="180" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="96">&nbsp;&nbsp;<a href="http://my.seu.edu.cn/getBackPassword.portal" class="style1">找回密码</a></td>
                                        <td width="84">&nbsp;
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table></td>
                </tr>
                <tr>
                    <td height="125" background="./images/login_15.jpg">
                        <table width="90%">
                            <tr>
                                <td width="10%"></td>
                                <td>
                                    <b>选课须知：</b><br>
                                    1. 选课前请务必仔细阅读<a href="#" onclick="window.open('http://xk.urp.seu.edu.cn/jw_image/rule.htm')">选课规则</a>和<a href="#" onclick="window.open('http://xk.urp.seu.edu.cn/jw_image/help.doc')">选课使用帮助</a>。<br>

                                    2. 本选课系统使用统一身份认证的用户名和密码(与学工系统、信息门户相同)。<br>

                                    3. 选课期间，如遇用户名、密码不能登录等操作问题，请拨打电话:52090218咨询，或到教务大厅(教五101室)、<br>
                                    网络中心咨询窗口咨询；如遇选课课程问题，请<a href="#" onclick="window.open('./jsp/system/phone.jsp')">联系所在院系教务助理</a>。
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            </td>
        </tr>
        <tr bgcolor="#FDFAF1">
            <td height="10%" colspan="3" align="center" valign="top">建议采用中文windows操作系统，IE6以上版本及其它IE内核浏览器，1024 × 768以上分辨率访问。</td>
        </tr>
    </table>
</form>
<!-- End ImageReady Slices -->
<!--<DIV id=enetMeng
     style="BORDER-RIGHT: #455690 1px solid; BORDER-TOP: #a6b4cf 1px solid; Z-INDEX: 99999; LEFT: 0px;
VISIBILITY: visible; BORDER-LEFT:  #a6b4cf 1px solid; WIDTH: 300px; BORDER-BOTTOM: #455690 1px
solid; POSITION: absolute; TOP: -100px; HEIGHT: 200px;BACKGROUND-COLOR: #c9d3f3'">
    <TABLE WIDTH='100%' style='BORDER-TOP: #ffffff 0px solid; BORDER-LEFT: #ffffff 1px solid'
           cellSpacing=0 cellPadding=0 width='100%' height='100%' bgColor=#FF0000 border="0" style="background:url(./images/xkimages.png) repeat-x;">
        <TR>
            <TD style='FONT-SIZE: 12px;COLOR: #0f2c8c' width=30 height=24></TD>
            <TD style='PADDING-LEFT: 4px; FONT-WEIGHT: normal; FONT-SIZE: 24px; COLOR: #F9F900;
PADDING-TOP: 4px' vAlign=center width='100%'><a style='color:#F9F900;FONT-SIZE: 22px;font-weight:bold; '>消息框</a></TD>
            <TD style='PADDING-RIGHT: 2px; PADDING-TOP: 2px' vAlign=center align=right width=19>
	<SPAN title=关闭 style='FONT-WEIGHT: bold; FONT-SIZE: 20px; CURSOR: hand; COLOR: #F9F900;
MARGIN-RIGHT: 4px' id='btSysClose' onClick="enetcloseDiv()" ><a style='color:#F9F900;FONT-SIZE: 22px;font-weight:bold; '>×</a></SPAN></TD>
        </TR>
        <TR>
            <TD style='PADDING-RIGHT: 1px;PADDING-BOTTOM: 1px' colSpan=3 height=100>
                <DIV style='BORDER-RIGHT: #b9c9ef 1px solid; PADDING-RIGHT: 8px; BORDER-TOP: #728eb8 1px
solid; PADDING-LEFT: 8px; FONT-SIZE: 12px; PADDING-BOTTOM: 8px; BORDER-LEFT: #728eb8 1px solid;
WIDTH: 100%; COLOR: #1f336b; PADDING-TOP: 8px; BORDER-BOTTOM: #b9c9ef 1px solid; HEIGHT: 100%'>
                    <DIV style='WORD-BREAK: break-all' align=left><a style='color:#F9F900;FONT-SIZE: 18px;' href=http://jwc.seu.edu.cn/s/99/t/2128/87/a0/info100256.htm>13-14-3学期seminar课程简介(3-1)</a></DIV>
                    <DIV style='WORD-BREAK: break-all' align=left><a style='color:#F9F900;FONT-SIZE: 18px;' href=http://jwc.seu.edu.cn/s/99/t/2128/87/a3/info100259.htm>13-14-3学期seminar课程简介(3-2)</a></DIV>
                    <DIV style='WORD-BREAK: break-all' align=left><a style='color:#F9F900;FONT-SIZE: 18px;' href=http://jwc.seu.edu.cn/s/99/t/2128/87/a7/info100263.htm>13-14-3学期seminar课程简介(3-3)</a></DIV>
                </DIV>
            </TD>
        </TR>
    </TABLE>
</DIV>-->
</body>
</html>