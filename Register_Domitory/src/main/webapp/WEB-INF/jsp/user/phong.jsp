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
<div class="text-center">
	<table class="table table-striped">
		<c:forEach items="${khu.getPhongs()}" var="tungphong">
			<c:if test="${tungphong.getTang()==tang}">
				<c:if test="${tungphong.tinhTrang==0}">
					<td>
						<%
							int x = 0;
						%> <c:forEach items="${tungphong.getGiuongs()}" var="giuong2">

							<c:forEach items="${giuong2.getDangKyGiuongs()}"
								var="giuongdangky">
								<c:if test="${giuongdangky.getTinhTrangDangKy()==1}">
									<%
										x++;
									%>
								</c:if>
							</c:forEach>

						</c:forEach> <label><%=x%>/${tungphong.getGiuongs().size()}</label><img
						src="/image/roomwhite.jpg" class="img-size2">
						<h5>${tungphong.phongSo}</h5> ${tungphong.getGiaTien().toString()}
						VNĐ
					</td>
				</c:if>
				<c:if test="${tungphong.tinhTrang==1}">
					<td
						class="btn btn-outline-success <c:if test="${tungphong.getIdPhong()==phong.getIdPhong()}">active</c:if>"><form
							action="/home/khu/idkhu=${khu.getIdKhu()}&tang=${tang}"
							method="post">
							<input type="hidden" value="${tungphong.getIdPhong()}"
								name="idphong">
							<button type="submit" style=" border: none; ">
								<%
									int x = 0;
								%>

								<c:forEach items="${tungphong.getGiuongs()}" var="giuong2">

									<c:forEach items="${giuong2.getDangKyGiuongs()}"
										var="giuongdangky">
										<c:if test="${giuongdangky.getTinhTrangDangKy()==1}">
											<%
												x++;
											%>
										</c:if>
									</c:forEach>

								</c:forEach>
								<label><%=x%>/${tungphong.getGiuongs().size()}</label> <img
									src="/image/roomgreen.jpg" class="img-size2">

								<h5>${tungphong.phongSo}</h5>
								${tungphong.getGiaTien().toString()} VNĐ
							</button>
						</form></td>
				</c:if>
				<c:if test="${tungphong.tinhTrang==2}">
					<td>
						<%
							int x = 0;
						%> <c:forEach items="${tungphong.getGiuongs()}" var="giuong2">

							<c:forEach items="${giuong2.getDangKyGiuongs()}"
								var="giuongdangky">
								<c:if test="${giuongdangky.getTinhTrangDangKy()==1}">
									<%
										x++;
									%>
								</c:if>
							</c:forEach>

						</c:forEach> <label><%=x%>/${tungphong.getGiuongs().size()}</label> <img
						src="/image/roomred.jpg" class="img-size2">

						<h5>${tungphong.phongSo}</h5> ${tungphong.getGiaTien().toString()}
						VNĐ
					</td>
				</c:if>
			</c:if>
		</c:forEach>
	</table>
</div>