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
	<div style="width: 50%; display: inline-block;">
		<form action="/quanly/khu/phong/capnhat" method="post">
			<div class="content form-control bg-image">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-3">
							<input name="idkhu" type="hidden"
								value="${PhongInput.getIdKhu().getIdKhu() }"> <input
								name="idphong" type="hidden" value="${PhongInput.getIdPhong() }">
							<div class="form-group">
								<label>Tên phòng: </label> <input class="form-control"
									value="${PhongInput.getPhongSo()}" name="phongso">
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<%
									int songuoio = 0;
								%>
								<c:forEach items="${PhongInput.getGiuongs()}" var="giuong">
								<c:forEach items="${giuong.getDangKyGiuongs()}" var="giuongdangky">
									<c:if test="${giuongdangky.getTinhTrangDangKy()==1}">
										<%
											songuoio++;
										%>
									</c:if>
									</c:forEach>
								</c:forEach>
								<label>Số lượng: </label> <label><%=songuoio%>/${PhongInput.getGiuongs().size()}</label>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label>Tình trạng: </label> <select class="form-control"
									name="tinhtrang">
									<option <c:if test="${PhongInput.tinhTrang==0}">selected</c:if>
										value=0>Không cho phép truy cập</option>
									<option <c:if test="${PhongInput.tinhTrang==1}">selected</c:if>
										value=1>Còn trống</option>
									<option <c:if test="${PhongInput.tinhTrang==2}">selected</c:if>
										value=2>Đầy</option>

								</select>
							</div>
						</div>
					</div>

				</div>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label>Số giường: </label> <input class="form-control"
									value="${PhongInput.getGiuongs().size()}" name="sogiuong"
									type="number" min="0" max="20">
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
		<div>
		
		</div>
	</div>
	<div style="float: right; width: 50%;">
	<% 
	int sogiuong= Integer.parseInt(request.getAttribute("sogiuong").toString());
	for(int i=0;i<sogiuong;i++){ %>
	<c:forEach items="${PhongInput.getGiuongs()}" var="giuong">
		<a href="${giuong.getIdGiuong()}"><label class="">${giuong.getViTriGiuong()}</label><img class="img-size" src="/image/bedwhite.jpg"></a>
		
		
	</c:forEach>
	
	<%} %>
	</div>
</div>
<div>
	<form>
		kjhhhhhhhhhhhhhhhhhhhhhhhhhhhh
	</form>
</div>
