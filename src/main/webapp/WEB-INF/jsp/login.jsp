<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>login</title>
	<link rel="stylesheet"  href="${pageContext.request.contextPath}/static/framework/bootstrap-3.0.0/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/framework/startbootstrap-sb-admin-2/css/sb-admin-2.css">
	<style>.error{color:red;}</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel login-panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="error">${error}</div>
					<div class="panel-body">
						<form role="form" action="${pageContext.request.contextPath}/login" method="post">
							<fieldset>
								<div class="form-group">
									<input type="text" name="username" value="<shiro:principal/>" class="form-control" placeholder="Login Name" autofocus/>
								</div>
								<div class="form-group">
									<input type="password" class="form-control" placeholder="Password" name="password" value/>
								</div>
								<input type="submit" class="btn btn-lg btn-success btn-block" value="Login"/>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/framework/bootstrap-3.0.0/js/bootstrap.min.js"></script>
</body>
</html>