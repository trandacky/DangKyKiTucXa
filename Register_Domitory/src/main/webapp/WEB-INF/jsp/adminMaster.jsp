<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<li class="nav-item"><a class="nav-link ${activetaikhoan}" href="quanlytaikhoan">Quản lý tài khoản</a>
					</li>
					<li class="nav-item"><a class="nav-link ${activephong}" href="quanlyphong">Quản lý phòng</a></li>
					<li class="nav-item"><a class="nav-link ${activekhu}" href="#">Quản lý khu</a>
					<li class="nav-item"><a class="nav-link ${activedangky}" href="#">Mở đăng ký</a>
					<li class="nav-item"><a class="nav-link ${active5}" href="#">gì gì đó</a>
					</li>
				</ul>
				<form class="form-inline my-2 my-lg-0">
					<input class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					
				</form>
				<div class="topright">
				<label >tên tài khoản của admin hay của ai đó</label>
				<button type="button"  class="btn btn-primary">Đăng xuất</button>
				</div>
			</div>
		</nav>
	</div>
	<c:import url="${page}"/>
</body>
</html>