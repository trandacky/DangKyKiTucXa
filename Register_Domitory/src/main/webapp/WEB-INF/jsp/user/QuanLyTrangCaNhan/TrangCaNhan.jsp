<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
$
.confirm( {
	title: 'Confirm!', content: 'Simple confirm!', confirm: function(){
        alert('Confirmed!');
}

,
cancel: function() {alert ('Canceled!')
	
}
}
)
;
</style>
<body>
	<div class="content form-control">
		<div class="container-fluid">
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
						<label>Giới tính: </label> <label>${taikhoan.getGioiTinh()}</label>
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
						<label>Số điện thoại liên hệ: </label> <label>${taikhoan.getSoDienLThoaiLienHe()}</label>
					</div>
				</div>
			</div>
			<div class="row">
			</div>
			<div class="row">
				<div class="clearfix" style="float: left;">
						<a href="/capnhat/${taikhoan.tenDangNhap}"><button class="btn btn-primary pull-left">Cập nhật thông tin cá nhân</button></a>
						
						
						
				</div>
			</div>
		</div>
	</div>
	
</body>
<!-- <script>
	function demo() {
		alert("Cập nhật thành công!");
	}
</script> -->
</html>