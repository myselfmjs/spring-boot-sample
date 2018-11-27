<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户表列表</title>
    <jsp:include page="/WEB-INF/include/head.jsp"/>
</head>
<body>
<div id="listDiv" class="mini-tabs" activeIndex="0" style="width:100%;height:100%;" bodyStyle="padding:0;border:0;">
    <div name="list" title="用户表列表" bodyStyle="padding:0px 10px 0px 20px;">
		<div id="queryPanel" class="search-div-box">
            <table class="search-table" cellspacing="5" cellpadding="0">
				<tr>
                    <td class="td-text"><label>:</label></td>
					<td>
					</td>
				</tr>
			</table>
        </div>
        <table class="mini-toolbar">
        	<tr>
        		<td></td>
        		<td align="right">
        			<input type="button" onclick="search();" class="my-btn green" value="查询" />
					<!--
					<input type="button" onclick="" class="bt1 bg2 ml-20" value="导出" />
					-->
        		</td>
        	</tr>
        </table>
		<div id="datagrid" class="mini-datagrid" style="width: 100%;"
			 url="${ctx}/user/data" idField="id" sizeList="[10,20,50]" pageSize="20">
			<div property="columns">
				<div type="indexcolumn"></div>
				<div field="uid" sortField="uid" headerAlign="center" allowSort="true"></div>
				<div field="username" sortField="username" headerAlign="center" allowSort="true"></div>
				<div field="password" sortField="password" headerAlign="center" allowSort="true"></div>
				<div field="action" renderer="actionRenderer" headerAlign="center">操作</div>
			</div>
		</div>
    </div>
</div>
<script type="text/javascript">
    mini.parse();
    var grid = mini.get("datagrid");
    var tabs = mini.get("listDiv");
    search();


    function search() {
		var data = {};
        grid.load(data,gridLoadSuccess,gridLoadError);
    }
    function actionRenderer(e) {
        var r = e.record;
        var h = '';
		<shiro:hasPermission name="sample:user:save">
		h += '<a onclick="editRow(\'' + r.uid + '\')" class="grid-button">修改</a> '
		</shiro:hasPermission>
		<shiro:hasPermission name="sample:user:del">
        h += '<a onclick="deleteRow(\'' + r.uid + '\')" class="grid-button">删除</a> ';
		</shiro:hasPermission>
        return h;
    }


    function loadList(){
        var tab = tabs.getActiveTab();
        if (tab) {
            tabs.removeTab(tab);
        }
        search();
    }

	function editRow(uid){
    	var param = "";
    	if (uid != undefined) {
			if (param.length > 0){
				param += "&";
			}
        	param += "uid="+uid;
        }
        var tab = {title: "用户表表单",url:'${ctx}/user/form?'+param};
        tab = tabs.addTab(tab);
        tabs.activeTab(tab);
    }

    function deleteRow(uid) {
    	var data = {};
    	if (uid == undefined) {
            data['uid'] = "";
        } else {
        	data['uid'] = uid;
        }
        mini.confirm("确定删除记录？", "确定？",
                function (action) {
                    if (action == "ok") {
                        $.ajax({
							url: "${ctx}/user/del",
                            data: data,
                            dataType: "json",
                            success: function (res) {
                                if (res.ok) {
                                    search();
                                    mini.showTips({
                                        content: res.msg,
                                        state: "success",
                                        x: "center",
                                        y: "top",
                                        timeout: 3000
                                    });
                                } else {
                                    mini.showTips({
                                        content: res.msg,
                                        state: "warning",
                                        x: "center",
                                        y: "top",
                                        timeout: 3000
                                    });
                                }
                            }
                        });
                    }
                }
        );
    }

</script>
</body>
</html>