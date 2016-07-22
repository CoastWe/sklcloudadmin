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

    <form:form method="post" commandName="resource">
        <form:hidden path="id"/>
        <form:hidden path="available"/>
        <form:hidden path="parentId"/>
        <form:hidden path="parentIds"/>
        <form:hidden path="level"/>

        <c:if test="${not empty parent}">
            <div class="form-group">
                <label>父节点名称：</label>
                ${parent.name}
            </div>
        </c:if>

        <div class="form-group">
            <form:label path="name"><c:if test="${not empty parent}">子</c:if>名称：</form:label>
            <form:input path="name" required="required"/>
        </div>
        <div class="form-group">
            <form:label path="type">类型：</form:label>
            <form:select path="type" items="${types}" itemLabel="info"/>
        </div>

        <div class="form-group">
            <form:label path="url">URL路径：</form:label>
            <form:input path="url"/>
        </div>


        <div class="form-group">
            <form:label path="permission">权限字符串：</form:label>
            <form:input path="permission" required="required"/>
        </div>

        <form:button>${op}</form:button>

    </form:form>

		</div>
</div>

<%@include file="../common/script.jspf"%>
</body>
</html>