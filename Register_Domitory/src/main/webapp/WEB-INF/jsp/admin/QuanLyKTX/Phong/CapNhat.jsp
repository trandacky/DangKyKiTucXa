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
								<label>Số giường: </label> <input class="form-control" value="${PhongInput.getSoGiuong()}"
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
		Phần này để chọn thêm giường
	</div>
</div>