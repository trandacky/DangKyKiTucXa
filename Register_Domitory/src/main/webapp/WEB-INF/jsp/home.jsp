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

.img-size2 {
	height: auto;
	width: auto;
	max-width: 50px;
	max-height: 50px;
}
</style>
<body>
	<c:import url="/WEB-INF/jsp/${headerForm}" />
	<div class="text-center form-control">
		<table class="table table-striped">
			<tr>
				<c:forEach items="${ListKhu}" var="khu">

					<td class="btn btn-outline-success"><a
						href="/home/khu/idkhu=${khu.idKhu}&idphong=${khu.getPhongs().get(0).getIdPhong()}"><img src="/image/ktx.jpg"
							class="img-size">
						<h3>${khu.tenKhu}</h3>Số tầng: ${khu.soTang}<br>Giới tính:
							${khu.gioiTinh==true ? 'Nam':'Nữ'}</a></td>
				</c:forEach>
			</tr>
		</table>
	</div>
	<c:import url="/WEB-INF/jsp/user/${formtang}"/>
	<c:import url="/WEB-INF/jsp/user/${formphong}"/>
</body>
</html>