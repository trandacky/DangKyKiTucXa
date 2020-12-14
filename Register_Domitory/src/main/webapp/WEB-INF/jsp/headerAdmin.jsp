<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo01"
				aria-controls="navbarTogglerDemo01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo01">
				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link ${activetrangchu}" href="index">Trang chủ</a>
					</li>
					<li class="nav-item"><a class="nav-link ${activetaikhoan}" href="quanlytaikhoan">Tài khoản</a>
					</li>
					<li class="nav-item"><a class="nav-link ${activephong}" href="quanlyphong">Phòng</a>
					</li>
				</ul>
				
				<div class="topright">
				<label >tên tài khoản của admin hay của ai đó</label>
				<button type="button"  class="btn btn-primary">Đăng xuất</button>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>