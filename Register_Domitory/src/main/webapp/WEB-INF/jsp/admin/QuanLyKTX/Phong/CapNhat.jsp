<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
.text-image {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
.bed-form {
	height: auto;
	width: auto;
	max-width: 50px;
	max-height: 50px;
}
</style>
<div>
	<div style="width:50%;display:inline-block;">
		<form action="/quanly/khu/phong/capnhat" method="post">
			<div class="content form-control bg-image">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-3">
<input name="idkhu" type="hidden" value="${PhongInput.getIdKhu().getIdKhu() }">
<input name="idphong" type="hidden" value="${PhongInput.getIdPhong() }">
							<div class="form-group">
								<label>Tên phòng: </label> <input class="form-control"
									value="${PhongInput.getPhongSo()}" name="phongso">
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Số lượng: </label> <label>${PhongInput.getSoNguoiDangKy()}/${PhongInput.getSoGiuong()}</label>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Tình trạng: </label> <select class="form-control"
									name="tinhtrang">
									<option <c:if test="${PhongInput.tinhTrang==0}">selected</c:if> value=0>Không cho phép truy cập</option>
									<option <c:if test="${PhongInput.tinhTrang==1}">selected</c:if> value=1>Còn trống</option>
									<option <c:if test="${PhongInput.tinhTrang==2}">selected</c:if> value=2>Đầy</option>

								</select>
							</div>
						</div>
					</div>

				</div>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label>Số giường: </label> <input class="form-control" value=""
									name="sogiuong" type="number" min="0" max="20">
							</div>
						</div>
						<div class="col-md-8">
							<div class="clearfix"
								style="position: absolute; right: 0; bottom: 17%;">
								<button class="btn btn-primary pull-right" type="submit"
									onclick="#">Cập nhật</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div style="float: right; width: 50%;">
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
				<td>
					<a href="/quanly/khu/phong/themphong/idkhu=${tenkhu.getIdKhu()}&tang=${i}">
						<img src="/image/plusroom.jpg" class="img-size"> Thêm phòng tầng ${i}</a>
				</td>
			</tr>
			<%
				}
			%>
			</table>
			<a href="/quanly/khu/phong/themtang">
				<img src="/image/plus.jpg" class="img-size"> Thêm Tầng</a>
		</div>
	</div>
</div>