<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
<%@include file="common/commoncss.jspf"%>
<style type="text/css">
	iframe {
	width: 84%;
}
</style>
</head>
<body>

	<div id="wrapper">
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header " >
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="#" class="navbar-brand">SkyLight Cloud Admin</a>
			</div>
			<ul class="nav navbar-right navbar-top-links navbar-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-bell"></i> <b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu"></ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-user"> <shiro:principal /></i>
						<b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li class="divider"></li>
						<li><a href="${pageContext.request.contextPath}/logout"><i
								class="fa fa-fw fa-power-off"> Log out</i></a></li>
					</ul></li>
			</ul>

			<div class="navbar-inverse sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse collapse"
					aria-expanded="true">
					<ul id="side-menu" class="nav in">
						<c:forEach items="${menus}" var="m">
							<li><a
								href="${pageContext.request.contextPath}${empty m.resource.url?'#':m.resource.url}"
								target="content"> <i class="fa fa-play-circle-o fa-fw"></i>
									${m.resource.name} <span class="fa arrow"></span>
							</a> <c:if test="${fn:length(m.sub_resources) >=1 }">
									<ul class="nav nav-second-level collapse" aria-expanded="true">
										<c:forEach items="${m.sub_resources}" var="sub_resources">
											<li><a
												href="${pageContext.request.contextPath}${sub_resources.url}"
												target="content">${sub_resources.name}</a></li>
										</c:forEach>
									</ul>
								</c:if></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</nav>
		
		
		<iframe id="page-wrapper" name="content" 
				src="${pageContext.request.contextPath}/welcome" frameborder="0"
				scrolling="auto"></iframe>	
	</div>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/framework/jquery/jquery.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/framework/bootstrap-3.0.0/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/framework/metisMenu/metisMenu.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/static/framework/startbootstrap-sb-admin-2/js/sb-admin-2.js"></script>
  
</body>
</html>
