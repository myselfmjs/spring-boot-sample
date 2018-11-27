<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户表表单</title>
    <jsp:include page="/WEB-INF/include/head.jsp"/>
</head>
<body>
<div id="form1" class="formDiv">
	<%@include file="/WEB-INF/include/token.jsp" %>

	<table border="0" cellpadding="1" cellspacing="2" class="form-layout">
		<tr>
			<td style="text-align: right;width: 30%;">：</td>
			<td>
				<input id="uid" name="uid" value="${user.uid}" style="width: 60%;" required="true" vtype="int;" placeholder="" class="mini-textbox"/>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;width: 30%;">：</td>
			<td>
				<input id="username" name="username" value="${user.username}" style="width: 60%;"  vtype="maxLength:255" placeholder="" class="mini-textbox"/>
			</td>
		</tr>
		<tr>
			<td style="text-align: right;width: 30%;">：</td>
			<td>
				<input id="password" name="password" value="${user.password}" style="width: 60%;"  vtype="maxLength:255" placeholder="" class="mini-textbox"/>
			</td>
		</tr>
	</table>
	<div class="hd-30 mt-20" style="text-align: center">
		<a class="mini-button" iconCls="icon-save" onclick="submitForm('form1','${ctx}/user/save');">保 存</a>
		<a class="mini-button" iconCls="icon-close" onclick="closeForm();">取 消</a>
	</div>
</div>
</body>
</html>