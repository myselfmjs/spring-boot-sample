<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<script src="${ctxStatic}/js/jquery-1.9.1.min.js" type="text/javascript"></script>
<!-- miniUI -->
<script type="text/javascript" src="${ctxStatic}/libs/miniui/miniui.js"></script>
<link href="${ctxStatic}/libs/miniui/themes/icons.css" rel="stylesheet" type="text/css"/>
<link href="${ctxStatic}/libs/miniui/themes/wanda/skin.css" rel="stylesheet" type="text/css"/>

<link href="${ctxStatic}/css/main.css" type="text/css" rel="stylesheet">
<link href="${ctxStatic}/css/patch.css" type="text/css" rel="stylesheet">
<link href="${ctxStatic}/main/wd_styles/inputSkip.css" rel="stylesheet" type="text/css"/>

<link rel="stylesheet" href="${ctxStatic}/libs/font-awesome-4.3.0/css/font-awesome.min.css">
<script type="text/javascript" src="${ctxStatic}/libs/echarts/4.2.0/echarts.js"></script>
<script src="${ctxStatic}/libs/jqmeter.min.js" type="text/javascript"></script>

<script type="text/javascript">
    var ctx = '${ctx}', ctxStatic='${ctxStatic}';

    $(function(){
        var menu_height = 70;
        if ($.trim($(".mind_snav .snav_cots").html()) == "") {
            $(".mind_snav").remove();
        } else {
            $(".mind_snav").show();
            menu_height += 50;
        }
        $("body").css("padding-top", menu_height + "px");
    })
</script>
