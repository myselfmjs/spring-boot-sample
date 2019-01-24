<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2018/11/20
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    SUCCESS <br>
   <c:if test="${online ne null}">当前登录人数：${online}</c:if>
</body>

<script>

    window.onload=function()
    {
        var oBtn = document.getElementById("btn1");
        oBtn.onclick = function()
        {
            ajax('a.txt',function(str){//读取a.txt文件里面的内容
                alert(str);//将读取的内容输出
            })
        }
    };

    //最后把代码封装起来,封装起来以后，要给这个函数加上一个参数url.参数是为了替换要读取的文件名
    function ajax(url,fnSucc)
    {
        if(window.XMLHttpRequest)
        {
            var oAjax = new XMLHttpRequest();
        }
        else
        {
            var oAjax = new ActiveXObject("Microsoft.XMLHTTP");//IE6浏览器创建ajax对象
        }
        oAjax.open("GET",url,true);//把要读取的参数的传过来。
        oAjax.send();
        oAjax.onreadystatechange=function()
        {
            if(oAjax.readyState==4)
            {
                if(oAjax.status==200)
                {
                    fnSucc(oAjax.responseText);//成功的时候调用这个方法
                }
                else
                {
                    if(fnfiled)
                    {
                        fnField(oAjax.status);
                    }
                }
            }
        };
    }
</script>
</html>
