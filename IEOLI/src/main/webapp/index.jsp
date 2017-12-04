<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<form role="form" id="login" action="weblogin" method="post" class="login-form">
									<div class="form-group">
										<label for="username">Username</label>
										<input type="text" name="username" placeholder="Username..." class="form-username form-control" id="form-username">
									</div>
									<div class="form-group">
										<label for="password">Password</label>
										<input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
									</div>
									
									<font color="red">${result }</font>
									
									<button type="submit" class="btn">Sign in!</button>
									
									
									
									
								</form>
</body>
</html>
