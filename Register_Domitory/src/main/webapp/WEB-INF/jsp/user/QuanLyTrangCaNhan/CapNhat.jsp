<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<form method="post" action="/capnhat/submit">
		<div class="content form-control">
			<div class="container-fluid">
				<div class="row">
					
					<div class="col-md-10">
						<div class="form-group">
							<label>Tên đăng nhập: </label> <input class="form-control"
								name="tendangnhap" value="${taikhoan.tenDangNhap}"
								 disabled>
						</div>
					</div>
				</div>
				<div class="row">
					
					<div class="col-md-10">
						<div class="form-group">
							<label>Email: </label>
							<input class="form-control"
								name="email" value="${taikhoan.email}"
								placeholder="${taikhoan.email}">
						</div>
					</div>
				</div>
				<div class="row">
					
					<div class="col-md-10">
						<div class="form-group">
							<label>Giới tính: </label>
							<input class="form-control"
								name="gioitinh" value="${taikhoan.gioitinh}"
								placeholder="${taikhoan.gioitinh}">
						</div>
					</div>
				</div>
				<div class="row">
					
					<div class="col-md-10">
						<div class="form-group">
							<label>Họ tên: </label>
							<input class="form-control"
								name="hoten" value="${taikhoan.hoTen}"
								placeholder="${taikhoan.hoTen}">
						</div>
					</div>
				</div>
				<div class="row">
					
					<div class="col-md-10">
						<div class="form-group">
							<label>Ngày tháng năm sinh: </label>
							<input class="form-control"
								name="ngaythangnamsinh" value="${taikhoan.ngayThangNamSinh}"
								placeholder="${taikhoan.ngayThangNamSinh}">
						</div>
					</div>
				</div>
				<div class="row">
					
					<div class="col-md-10">
						<div class="form-group">
							<label>Quê quán: </label>
							<input class="form-control"
								name="quequan" value="${taikhoan.queQuan}"
								placeholder="${taikhoan.queQuan}">
						</div>
					</div>
				</div>
				<div class="row">
					
					<div class="col-md-10">
						<div class="form-group">
							<label>Số điện thoại liên hệ: </label>
							<input class="form-control"
								name="sodienthoailienhe" value="${taikhoan.soDienThoaiLienHe}"
								placeholder="${taikhoan.soDienThoaiLienHe}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="clearfix" style="float: left;">
							<button class="btn btn-primary pull-left" onclick="demo()"
								type="submit">Hoàn tất</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	
</body>
<script>
	function demo() {
		alert("Đã cập nhật!");
	}
</script>
</html>