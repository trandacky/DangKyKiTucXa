<%@page import="org.springframework.ui.Model"%>
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
.text-image {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

.img-size {
	height: auto;
	width: auto;
	max-width: 50px;
	max-height: 50px;
}
</style>
<body>
	<c:import url="/WEB-INF/jsp/headerAdmin.jsp" />
	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">${message}</div>
	</c:if>
	<c:import url="/WEB-INF/jsp/admin/QuanLyKTX/Phong/${form}" />
	<input name="idkhu" value="1" type="hidden">
	<h3 class="text-center">Khu: ${tenkhu.getTenKhu()}</h3>

	<div class="text-center form-control">
		<table class="table table-striped">

			<%
				for (int i = Integer.parseInt(request.getAttribute("soTang").toString()); i > 0; i--) {
				request.setAttribute("i", i);
			%>

			<tr>

				<c:forEach items="${ListPhong}" var="phong">

					<c:if test="${phong.tang==i}">
						<c:if test="${phong.tinhTrang==0}">
							<td class="btn btn-outline-light"><a
								href="/quanly/khu/phong/chon/phong=${phong.idPhong}&khu=${phong.getIdKhu().getIdKhu()}"><label>${phong.soNguoiDangKy}/${phong.soGiuong}</label><img
									src="/image/roomwhite.jpg" class="img-size">

									<h3>${phong.phongSo}</h3></a></td>
						</c:if>
						<c:if test="${phong.tinhTrang==1}">
							<td class="btn btn-outline-success"><a
								href="/quanly/khu/phong/chon/phong=${phong.idPhong}&khu=${phong.getIdKhu().getIdKhu()}"><label>${phong.soNguoiDangKy}/${phong.soGiuong}</label><img
									src="/image/roomgreen.jpg" class="img-size">
									<h3>${phong.phongSo}</h3></a></td>
						</c:if>
						<c:if test="${phong.tinhTrang==2}">
							<td class="btn btn-outline-danger"><a
								href="/quanly/khu/phong/chon/phong=${phong.idPhong}&khu=${phong.getIdKhu().getIdKhu()}"><label>${phong.soNguoiDangKy}/${phong.soGiuong}</label><img
									src="/image/roomred.jpg" class="img-size">
									<h3>${phong.phongSo}</h3></a></td>
						</c:if>
					</c:if>
 
				</c:forEach>

				<td><a href="/quanly/khu/phong/themphong/idkhu=${tenkhu.getIdKhu()}&tang=${i}"><img
						src="/image/plusroom.jpg" class="img-size"> Thêm phòng tầng
						${i}</a></td>

			</tr>
			<%
				}
			%>
		</table>
		<a href="/quanly/khu/phong/themtang"><img src="/image/plus.jpg"
			class="img-size"> Thêm Tầng</a>
	</div>

</body>
</html>