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
<body>
	<h1>Welcome</h1>
	<h2>${message}</h2>
	<div class="text-center">
		<table class="table table-striped">
			<tr>
				<th>Tên đăng nhập</th>
				<th>Quyền</th>
				<th>Họ tên</th>
				<th>Ngày tháng năm sinh</th>
				<th>Số điện thoại</th>
				<th>Tình trạng</th>
				<th>Xem chi tiết</th>

			</tr>
			<c:forEach items="${ListNguoiDung}" var="nguoiDung">
				<tr>
					<td><a href="https://abc.com">${nguoiDung.tenDangNhap}</a></td>
					<td>${nguoiDung.quyen}</td>
					<td>${nguoiDung.hoTen}</td>
					<td>${nguoiDung.ngayThangNamSinh}</td>
					<td>${nguoiDung.soDienThoai}</td>

					<td><button type="button"
							style="${nguoiDung.tinhTrang==true ? 'background-color: lightgreen':'background-color: red'}"
							class="btn btn-primary">${nguoiDung.tinhTrang}</button></td>
					<td><button type="button" class="btn btn-primary">Chọn</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>