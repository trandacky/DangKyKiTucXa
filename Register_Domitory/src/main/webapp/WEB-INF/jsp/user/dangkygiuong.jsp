<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
	<c:import url="/WEB-INF/jsp/HeaderUser.jsp" />
	<h2>Xác nhận thông tin tài khoản (Vui lòng cập nhật thông tin ở trang cá nhân)</h2>
		<div class="content form-control">
		<div class="container-fluid">
			<form method="post" action="/trangcanhan">
				<div class="row">

					<div class="col-md-3">

						<div class="form-group">
							<label>Tên đăng nhập: </label> <label>${taikhoan.getTenDangNhap()}</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<label>Email: </label> <label>${taikhoan.getEmail()}</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">

						<div class="form-group">
							<label>Giới tính: </label> <label> <c:if
									test="${taikhoan.getGioiTinh()==true}">Nam</c:if> <c:if
									test="${taikhoan.getGioiTinh()==false}">Nữ</c:if>
							</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">

						<div class="form-group">
							<label>Họ tên: </label> <label>${taikhoan.getHoTen()}</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">

						<div class="form-group">
							<label>Ngày tháng năm sinh: </label> <label>${taikhoan.getNgayThangNamSinh()}</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">

						<div class="form-group">
							<label>Quê quán: </label> <label>${taikhoan.getQueQuan()}</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">

						<div class="form-group">
							<label>Số điện thoại liên hệ: </label> <label>${taikhoan.getSoDienThoaiLienHe()}</label>
						</div>
					</div>
				</div>
				<div class="row"></div>
			</form>
			<div class="row">
				<div class="clearfix" style="float: left;">
					<a href=""><button
							class="btn btn-primary pull-left">Xác nhận thông tin</button></a>



				</div>
			</div>
		</div>
	</div>
	
	
</body>
<script>
	function demo() {
		alert("Đã cập nhật!");
	}
</script>
</html>