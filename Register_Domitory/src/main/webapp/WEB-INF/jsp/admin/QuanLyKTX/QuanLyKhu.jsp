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
.img-size {
	height: auto;
	width: auto;
	max-width: 100px;
	max-height: 100px;
}
</style>
<body>
	
	
	
	


	<c:import url="/WEB-INF/jsp/headerAdmin.jsp" />
	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">${message}</div>
	</c:if>
	<c:import url="/WEB-INF/jsp/admin/QuanLyKTX/Khu/${form}" />
	<input name="idkhu" value="1" type="hidden">
	
	<div class="text-center form-control">
		<table class="table table-striped">
			<tr>
				<th>Tên khu</th>
				<th>Số tầng</th>
				<th>Giới tính</th>
				<th>Cập nhật</th>
			</tr>

			<c:forEach items="${ListKhu}" var="khu">
				<tr>
					<td><a href="/quanly/khu/chonchitiet/${khu.idKhu}"><img
							src="/image/ktx.jpg" class="img-size">
						<h3>${khu.tenKhu}</h3></a></td>
					<td>${khu.soTang}</td>
					<td>${khu.gioiTinh==true ? 'Nam':'Nữ'}</td>
					<td><a href="/quanly/khu/chon/khu=${khu.idKhu}">Cập
							nhật</a></td>
				</tr>
			</c:forEach>

		</table>
		<a href="/quanly/khu/themkhu"><img src="/image/plus.jpg"
			class="img-size"> Thêm khu</a>
	</div>
</body>
</html>