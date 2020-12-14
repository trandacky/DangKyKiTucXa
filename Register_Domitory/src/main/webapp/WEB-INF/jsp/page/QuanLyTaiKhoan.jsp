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
	<div class="content form-control">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-3">

					<div class="form-group">
						<label>Tên đăng nhập: </label> <input class="form-control">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label>Password: </label> <input class="form-control"
							type="password">
					</div>
				</div>
				<div class="col-md-4">

					<div class="form-group">
						<label>Họ tên: </label> <input class="form-control">
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<label>Quyền: </label> <select class="form-control"
							id="selectquyen">
							<option id="optionuser" value=0>DISABLE</option>
							<option id="optionadmin">ADMIN</option>
							<option id="optionuser">USER</option>

						</select>
					</div>
				</div>
			</div>
			
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-4">

					<div class="form-group">
						<label>Email: </label> <input class="form-control">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label>Quê quán: </label> <input class="form-control">
					</div>
				</div>
				<div class="col-md-2">

					<div class="form-group">
						<label>Ngày tháng năm sinh: </label> <input class="form-control"  type="date">
					</div>
				</div>

				<div class="col-md-2">
					<div class="form-group">
						<label>Giới tính: </label> <select class="form-control"
							id="selectquyen">
							<option id="optionnam" value=true>NAM</option>
							<option id="optionnu" value=false>Nữ</option>

						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="clearfix" style="float: right;">
						<button class="btn btn-primary pull-right" type="button"
							onclick="#">Thêm</button>
						<button class="btn btn-primary pull-right" type="button"
							onclick="#">Cập nhật</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div>
		<form class="form-inline my-2 my-lg-0 form-control">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="button"
				onclick="#">Search</button>

		</form>
	</div>

	<div class="text-center">
		<table class="table table-striped">
			<tr>
				<th>Tên đăng nhập</th>
				<th>Họ tên</th>
				<th>Ngày tháng năm sinh</th>
				<th>Số điện thoại</th>
				<th>Quyền</th>

			</tr>
			<c:forEach items="${ListNguoiDung}" var="nguoiDung">
				<tr>
					<td><a href="" onclick="abc()">${nguoiDung.tenDangNhap}</a></td>
					<td>${nguoiDung.hoTen}</td>
					<td>${nguoiDung.ngayThangNamSinh}</td>
					<td>${nguoiDung.soDienThoaiLienHe}</td>
					<td><input type="button"
						style='background-color: <c:if test="${nguoiDung.quyen==0}">red</c:if><c:if test="${nguoiDung.quyen==1}">blue</c:if>
						<c:if test="${nguoiDung.quyen==2}">green</c:if>'
						class="btn btn-primary" disabled
						value="<c:if test="${nguoiDung.quyen==0}">DISABLE</c:if><c:if test="${nguoiDung.quyen==1}">ADMIN</c:if>
						<c:if test="${nguoiDung.quyen==2}">USER</c:if>"></input></td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>