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
.img-size {
	height: auto;
	width: auto;
	max-width: 50px;
	max-height: 50px;
}
</style>
<body>
	<c:import url="/WEB-INF/jsp/headerAdmin.jsp" />
	Khu: ${tenkhu}
	<div>
		<form class="form-inline my-2 my-lg-0 form-control"
			action="/quanly/KTX/seach" method="get">
			<input class="form-control mr-sm-2" placeholder="Tìm kiếm"
				name="seach" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
				type="submit" onclick="#">Tìm kiếm</button>

		</form>
	</div>

	<div class="text-center">
		<table class="table table-striped">

			<%
				for (int i = Integer.parseInt(request.getAttribute("soTang").toString()); i > 0; i--) {
					request.setAttribute("i", i);
			%>
			<tr>
			<c:forEach items="${ListPhong}" var="phong">
				<c:if test="${phong.tang==i}">
				<c:if test="${phong.tinhTrang==0}">
					<td><a href="/quanly/phong/chon/${phong.idPhong}"><img
							src="/image/roomwhite.jpg" class="img-size">
							<h3>${phong.phongSo}</h3></a></td>
				</c:if>
				<c:if test="${phong.tinhTrang==1}">
					<td><a href="/quanly/phong/chon/${phong.idPhong}"><img
							src="/image/roomgreen.jpg" class="img-size">
							<h3>${phong.phongSo}</h3></a></td>
				</c:if>
				<c:if test="${phong.tinhTrang==2}">
					<td><a href="/quanly/phong/chon/${phong.idPhong}"><img
							src="/image/roomred.jpg" class="img-size">
							<h3>${phong.phongSo}</h3></a></td>
				</c:if>
				</c:if>

			</c:forEach>
			<td><a href="/quanly/phong/them"><img src="/image/plus.jpg"
				class="img-size"> Thêm phòng tầng ${i}</a>
			</td>
			<%
				}
			%>
			</tr>
		</table>
		<a href="/quanly/khu/them"><img src="/image/plus.jpg"
			class="img-size"> Thêm Tầng</a>
	</div>
</body>
</html>