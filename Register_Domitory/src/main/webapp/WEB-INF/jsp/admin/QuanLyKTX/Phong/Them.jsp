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

.img-background {
	background-image: url("/image/door.jsp");
	background-color: #cccccc;
	height: auto;
	width: auto;
	max-width: 50px;
	max-height: 50px;
}
</style>
<div>
	<div>
		<form action="/quanly/khu/phong/themphong" method="post">
			<div class="content form-control bg-image">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-3">

<input name="idkhu" type="hidden" value="${tenkhu.getIdKhu()}">
<input name="tang" type="hidden" value="${tang}">
							<div class="form-group">
						
								<label>Tên phòng: </label> <input class="form-control" type="number" name="phongso">
							</div>
						</div>
						<div class="col-md-5">
							<div class="form-group">
								<label>Giá phòng: </label> <input value="0" type="number" step="100000" max=10000000000 min=0 class="form-control" name="giaphong">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label>Tình trạng: </label> <select class="form-control"
									name="tinhtrang">
									<option value=0>Không cho phép truy cập</option>
									<option selected value=1>Còn trống</option>
									<option value=2>Đầy</option>

								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="clearfix">
								<label>Khu:  ${tenkhu.getTenKhu()} Tầng: ${tang} </label>
								<button class="btn btn-primary pull-right" type="submit" 
								style=" float:right;"
									onclick="#">Thêm</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div style="float: right; width: 50%;" class="img-background">
	
	</div>
</div>