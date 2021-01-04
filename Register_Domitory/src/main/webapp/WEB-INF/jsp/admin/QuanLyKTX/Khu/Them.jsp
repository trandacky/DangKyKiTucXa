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
		<form action="/quanly/khu/themkhu/them" method="post">
			<div class="content form-control bg-image">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
						
								<label>Tên khu: </label> <input class="form-control" name="tenkhu">
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<label>Số tầng: </label> <input value="8" type="number" max=50 min=0 class="form-control" name="sotang">
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Giới tính: </label> <select class="form-control"
									name="gioitinh">
									<option value=true>Nam</option>
									<option selected value=false">Nữ</option>

								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="clearfix">
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