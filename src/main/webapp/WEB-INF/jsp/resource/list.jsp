<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="adminfn" uri="http://www.skllight/chenweibin/tags/admin-functions" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>SkyLight Cloud Admin</title>

	<!--这是个是IE8的专用标记,用来指定IE8浏览器去模拟某个特定版本的IE浏览器的渲染方式，以此来解决部分兼容问题。此处以IE最新版本格式渲染-->
	<meta http-equiv="X-UA-Compatiable" content="IE=edge">
	<!--
	此处是html5特性，为移动端服务
	width - viewport的宽度 height - viewport的高度
    initial-scale - 初始的缩放比例
    minimum-scale - 允许用户缩放到的最小比例
    maximum-scale - 允许用户缩放到的最大比例
    user-scalable - 用户是否可以手动缩放
    -->
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<%@include file="../common/commoncss.jspf"%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/css.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/framework/jquery-treetable/stylesheets/jquery.treetable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/framework/jquery-treetable/stylesheets/jquery.treetable.theme.default.css">
    <style>
        #table th, #table td {
            font-size: 14px;
            padding : 8px;
        }

    </style>
</head>
<body>
<div id="wrapper">		
		<%@include file="../common/header.jspf"%>
		<div id="page-wrapper">
			<c:if test="${not empty msg}">
    			<div class="message">${msg}</div>
			</c:if>

			<table id="table">
			    <thead>
			        <tr>
			            <th>名称</th>
			            <th>类型</th>
			            <th>URL路径</th>
			            <th>权限字符串</th>
			            <th>操作</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach items="${resourceList}" var="resource">
			            <tr data-tt-id='${resource.id}' <c:if test="${not resource.rootNode}">data-tt-parent-id='${resource.parentId}'</c:if>>
			                <td>${resource.name}</td>
			                <td>${resource.type.info}</td>
			                <td>${resource.url}</td>
			                <td>${resource.permission}</td>
			                <td>
			                    <shiro:hasPermission name="system:resource:create">
			                        <c:if test="${resource.type ne 'button'}">
			                        <a href="${pageContext.request.contextPath}/resource/${resource.id}/appendChild" class="btn btn-default">添加子节点</a>
			                        </c:if>
			                    </shiro:hasPermission>
			
			                    <shiro:hasPermission name="system:resource:update">
			                        <a href="${pageContext.request.contextPath}/resource/${resource.id}/update" class="btn btn-default">修改</a>
			                    </shiro:hasPermission>
			                    <c:if test="${not resource.rootNode}">
			
			                    <shiro:hasPermission name="system:resource:delete">
			                        <a class="deleteBtn btn btn-default" href="#" data-id="${resource.id}">删除</a>
			                    </shiro:hasPermission>
			                    </c:if>
			                </td>
			            </tr>
			        </c:forEach>
			    </tbody>
			</table>
		</div>
</div>

<%@include file="../common/script.jspf"%>
<script src="${pageContext.request.contextPath}/static/framework/jquery-treetable/javascripts/src/jquery.treetable.js"></script>
<script>
    $(function() {
    	$("#table").treetable({ expandable: true });
        $(".deleteBtn").click(function() {
            if(confirm("确认删除吗?")) {
                location.href = "${pageContext.request.contextPath}/resource/"+$(this).data("id")+"/delete";
            }
        });
    });
</script>
</body>
</html>