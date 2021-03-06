<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký kí túc xá</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<style>
.bg-image {
	background-image: url("/image/background3.jpg");
	background-color: #cccccc;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
}

.topright {
	position: absolute;
	top: 10px;
	right: 16px;
	font-size: 18px;
}
</style>
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
					<li class="nav-item"><a class="nav-link ${activetrangchu}"
						href="/home">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link ${activetrangcanhan}"
						href="/nguoidung/trangcanhan">Trang cá nhân</a></li>
					<li class="nav-item"><a class="nav-link ${activetaikhoan}"
						href="/quanly/taikhoan">Tài khoản</a></li>
					<li class="nav-item"><a class="nav-link ${activekhu}"
						href="/quanly/khu">Quản lý khu</a></li>
					<li class="nav-item"><a class="nav-link ${activequangcao}"
						href="/quanly/quangcao">Quảng cáo</a></li>
					<li class="nav-item"><a class="nav-link ${activedangky}"
						href="/quanly/modangky">Mở đăng ký</a></li>
				</ul>

				<div class="topright">
					<label>Xin chào: ${tennguoidung}</label> <a href="/logout"><button
							type="button" class="btn btn-primary">Đăng xuất</button></a>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>