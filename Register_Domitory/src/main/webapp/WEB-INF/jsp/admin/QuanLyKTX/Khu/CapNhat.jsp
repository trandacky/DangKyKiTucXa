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
.img-size {
	height: auto;
	width: auto;
	max-width: 50px;
	max-height: 50px;
}

</style>
<div>
	<div style="width: 100%; display: inline-block;">
		<form action="/quanly/khu/capnhat" method="post">
			<div class="content form-control bg-image">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-3">
							<input name="idkhu" type="hidden"
								value="${PhongInput.getIdKhu().getIdKhu() }"> <input
								name="idphong" type="hidden" value="${PhongInput.getIdPhong() }">
							<div class="form-group" style="padding-left: 70px;">
								<label>Tên khu: </label> <input class="form-control"
									value="${KhuInput.getTenKhu()}" name="tenkhu">
							</div>
						</div>
						
						<div class="col-md-2">
							<div class="form-group">
								<label>Số tầng: </label> <input class="form-control"
									value="${KhuInput.getSoTang()}" name="sotang"
									type="number" disable>
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group" style="padding-left: 0px;">
								<label>Giới tính: </label> 
								<select class="form-control" name="gioitinh">
									<option <c:if test="${KhuInput.gioiTinh==false}">selected</c:if>
										value=false>Nữ</option>
									<option <c:if test="${KhuInput.gioiTinh==true}">selected</c:if>
										value=true>Nam</option>
								</select>
							</div>
						</div>
						<div class="col-md-2">
							<div class="clearfix"
								style="position: absolute;left: 5%; bottom: 17%;">
								<button class="btn btn-primary pull-right" type="submit"
									onclick="#">Cập nhật</button>
							</div>
						</div>
					</div>

				</div>
				<div class="container-fluid">
					<div class="row">
						
					</div>
				</div>
			</div>
		</form>
		<div>
		
		</div>
	</div>
<!-- <div >
	<% 
	int sogiuong= Integer.parseInt(request.getAttribute("sogiuong").toString());
	for(int i=0;i<sogiuong;i++){ %>
	<c:forEach items="${PhongInput.getGiuongs()}" var="giuong">
		<a href="${giuong.getIdGiuong()}"><label class="">${giuong.getViTriGiuong()}</label><img class="img-size" src="/image/bedwhite.jpg"></a>
		
		
	</c:forEach>
	
	<%} %>
	</div> -->	
</div>

