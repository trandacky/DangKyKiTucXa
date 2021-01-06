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
<c:import url="/WEB-INF/jsp/headerAdmin.jsp"/>
	<div class="text-center form-control">
		<table class="table table-striped">
			<tr>
				<th>Tên khu</th>
				<th>Tầng</th>
				<th>Phòng</th>
				<th>Giới tính</th>
			</tr>
			<c:forEach items="${ListKhu}" var="khu">
				<tr>
					<td><a href="/quanly/khu/chonchitiet/${khu.idKhu}"><img src="/image/home.jpg" class="img-size"><h3> ${khu.tenKhu}</h3></a></td>
					<td><table class="table table-striped">

			<c:forEach var = "i" begin = "1" end = "${khu.getSoTang()}">
			<tr>
			<td>${i}<td>
				<c:forEach items="${khu.getPhongs()}" var="phong">
					<c:if test="${phong.tang==i}">
						<c:if test="${phong.tinhTrang==0}">
							<td class="btn btn-outline-light"><a
								href="/quanly/khu/phong/chon/phong=${phong.idPhong}&khu=${phong.getIdKhu().getIdKhu()}">
									<%
										int x = 0;
									%> <c:forEach items="${phong.getGiuongs()}" var="giuong2">

										<c:forEach items="${giuong2.getDangKyGiuongs()}"
											var="giuongdangky">
											<c:if test="${giuongdangky.getTinhTrangDangKy()==1}">
												<%
													x++;
												%>
											</c:if>
										</c:forEach>

									</c:forEach> <label><%=x%>/${phong.getGiuongs().size()}</label><img
									src="/image/roomwhite.jpg" class="img-size2">
									<h5>P${phong.phongSo}</h5>
									${phong.getGiaTien().toString()} VNĐ
									</a></td>
						</c:if>
						<c:if test="${phong.tinhTrang==1}">
							<td class="btn btn-outline-success"><a
								href="/quanly/khu/phong/chon/phong=${phong.idPhong}&khu=${phong.getIdKhu().getIdKhu()}">
									<%
										int x = 0;
									%> <c:forEach items="${phong.getGiuongs()}" var="giuong2">

										<c:forEach items="${giuong2.getDangKyGiuongs()}"
											var="giuongdangky">
											<c:if test="${giuongdangky.getTinhTrangDangKy()==1}">
												<%
													x++;
												%>
											</c:if>
										</c:forEach>

									</c:forEach> <label><%=x%>/${phong.getGiuongs().size()}</label> <img
									src="/image/roomgreen.jpg" class="img-size2">

									<h5>P${phong.phongSo}</h5>
									${phong.getGiaTien().toString()} VNĐ
							</a></td>
						</c:if>
						<c:if test="${phong.tinhTrang==2}">
							<td class="btn btn-outline-danger"><a
								href="/quanly/khu/phong/chon/phong=${phong.idPhong}&khu=${phong.getIdKhu().getIdKhu()}">
									<%
										int x = 0;
									%> <c:forEach items="${phong.getGiuongs()}" var="giuong2">

										<c:forEach items="${giuong2.getDangKyGiuongs()}"
											var="giuongdangky">
											<c:if test="${giuongdangky.getTinhTrangDangKy()==1}">
												<%
													x++;
												%>
											</c:if>
										</c:forEach>

									</c:forEach> <label><%=x%>/${phong.getGiuongs().size()}</label> <img
									src="/image/roomred.jpg" class="img-size2">

									<h3>${phong.phongSo}</h3>
									${phong.getGiaTien().toString()} VNĐ
							</a></td>
						</c:if>
					</c:if>
				</c:forEach>
			</c:forEach>
		</table></td>
					<td>${khu.gioiTinh==true ? 'Nam':'Nữ'}</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>