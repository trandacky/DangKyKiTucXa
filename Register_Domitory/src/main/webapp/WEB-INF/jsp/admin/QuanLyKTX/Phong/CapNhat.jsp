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
.btn-add{
width: 40%;
  background-color: #4CAF50;
  color: white;
  padding: 6px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
.form-control1{
	width: 56%;
  padding: 5px 11px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}


$.confirm({
    title: 'Confirm!',
    content: 'Simple confirm!',
    confirm: function(){
        alert('Confirmed!');
    },
    cancel: function(){
        alert('Canceled!')
    }
});

</style>
<div>
	<div style="width: 100%; display: inline-block;">
		<form action="/quanly/khu/phong/capnhat" method="post">
			<div class="content form-control bg-image">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-3">
							<input name="idkhu" type="hidden"
								value="${PhongInput.getIdKhu().getIdKhu() }"> <input
								name="idphong" type="hidden" value="${PhongInput.getIdPhong() }">
							<div class="form-group" style="padding-left: 70px;">
								<label>Tên phòng: </label> <input type="number" class="form-control"
									value="${PhongInput.getPhongSo()}" name="phongso">
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<%
									int songuoio = 0;
								%>
								<c:forEach items="${PhongInput.getGiuongs()}" var="giuong">
									<c:forEach items="${giuong.getDangKyGiuongs()}"
										var="giuongdangky">
										<c:if test="${giuongdangky.getTinhTrangDangKy()==0}">
											<%
												songuoio++;
											%>
										</c:if>
									</c:forEach>
								</c:forEach>
								<label>Số lượng: </label> <input class="form-control"
									value="<%=songuoio%>/${PhongInput.getGiuongs().size()}"
									disabled>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<label>Số tiền: </label> <input class="form-control"
									value="${PhongInput.getGiuongs().size()}" name="sogiuong"
									type="number" min="0" max="20">
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group" style="padding-left: 0px;">
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
						<div class="col-md-2">
							<div class="clearfix"
								style="position: absolute; left: 5%; bottom: 17%;">
								<button class="btn btn-primary pull-right" type="submit"
									onclick="#">Cập nhật</button>
							</div>
						</div>
					</div>

				</div>
				<div class="container-fluid">
					<div class="row"></div>
				</div>
			</div>
		</form>
		<div></div>
	</div>
</div>
<div class="text-center">
	<table class="table table-striped">
		<tr>
			<th>Số giường</th>
			<th>Họ tên sinh viên</th>
			<th>Ngày tháng năm sinh</th>
			<th>Số điện thoại</th>
			<th>Email</th>
			<th>Giới tính</th>
			<th>Thời gian đăng ký</th>
			<th>Trạng thái</th>
			<th>Cập nhật</th>

		</tr>
		
		<c:forEach items="${PhongInput.getGiuongs()}" var="giuong">
			<c:if test="${giuong.isTinhTrangGiuong()==true}">
					<%
				{
				int dk = 0;
			%>
			
			<c:forEach items="${giuong.getDangKyGiuongs()}" var="dangkygiuong">

				<c:if test="${dangkygiuong.getTinhTrangDangKy()==0}">
					<%
						dk++;
					%>
					<form action = "/quanly/khu/phong/chon/capnhat" method ="post">
					<tr>
						
						<td><input name="iddangkygiuong" type="hidden" value="${dangkygiuong.getIdDangKyGiuong()}">${giuong.getViTriGiuong()}</td>
						<td><input name="idkhu" type="hidden" value="${giuong.getIdPhong().getIdKhu().getIdKhu()}">
						<input name="idgiuong" type="hidden" value="${giuong.getIdGiuong()}">
						<input name="idphong" type="hidden" value="${giuong.getIdPhong().getIdPhong()}">${dangkygiuong.getTenDangNhap().getHoTen()}</td>
						<td>${dangkygiuong.getTenDangNhap().getNgayThangNamSinh()}</td>
						<td>${dangkygiuong.getTenDangNhap().getSoDienThoaiLienHe()}</td>
						<td>${dangkygiuong.getTenDangNhap().getEmail()}</td>
						<td>${dangkygiuong.getTenDangNhap().getGioiTinh()==true ? 'Nam':'Nữ'}</td>
						<td>${dangkygiuong.getNgayDangKy()}</td>
						<td><select name="tinhtrang" class="form-control">
							<option style="color: green;" value="0" selected >Đã có người</option>
							<option style="color: red;"value="1" >Chưa đăng ký</option>
							<option style="color: yellow;"value="2">Đang chờ...</option>
							<option style="color: yellow;"value="3">Đang sửa chữa</option>
						</select></td>
						<td><input type="submit" class="btn btn-primary" onclick="return confirm('Thao tác trên sẽ không hoàn lại được! Bạn có chắc thực hiện thao tác?');"></td>
					</tr>
					</form>
				</c:if>
				<c:if test="${dangkygiuong.getTinhTrangDangKy()==1}">
					<%
						dk++; 
					%>
					<form action = "/quanly/khu/phong/chon/capnhat" method ="post">
					<tr>
						
						<td><input name="iddangkygiuong" type="hidden" value="${dangkygiuong.getIdDangKyGiuong()}">${giuong.getViTriGiuong()}</td>
						<td><input name="idkhu" type="hidden" value="${giuong.getIdPhong().getIdKhu().getIdKhu()}">
						<input name="idgiuong" type="hidden" value="${giuong.getIdGiuong()}">
						<input name="idphong" type="hidden" value="${giuong.getIdPhong().getIdPhong()}">Trống</td>
						<td>Trống</td>
						<td>Trống</td>
						<td>Trống</td>
						<td>Trống</td>
						<td>Trống</td>
						<td><select name="tinhtrang" class="form-control">
							
							<option style="color: red;"value="1" selected>Chưa đăng ký</option>
							
							<option style="color: yellow;"value="3">Đang sửa chữa</option>
						</select></td>
						<td><input type="submit" class="btn btn-primary" onclick="return confirm('Thao tác trên sẽ không hoàn lại được! Bạn có chắc thực hiện thao tác?');"></td>
					</tr>
					</form>
					
				</c:if>
				<c:if test="${dangkygiuong.getTinhTrangDangKy()==2}">
				<%
						dk++; 
					%>
				<form action = "/quanly/khu/phong/chon/capnhat" method ="post">
					<tr>
						
						<td><input name="iddangkygiuong"type="hidden" value="${dangkygiuong.getIdDangKyGiuong()}">${giuong.getViTriGiuong()}</td>
						<td><input name="idkhu" type="hidden" value="${giuong.getIdPhong().getIdKhu().getIdKhu()}">
						<input name="idgiuong" type="hidden" value="${giuong.getIdGiuong()}">
						<input name="idphong" type="hidden" value="${giuong.getIdPhong().getIdPhong()}">${dangkygiuong.getTenDangNhap().getHoTen()}</td>
						<td>${dangkygiuong.getTenDangNhap().getNgayThangNamSinh()}</td>
						<td>${dangkygiuong.getTenDangNhap().getSoDienThoaiLienHe()}</td>
						<td>${dangkygiuong.getTenDangNhap().getEmail()}</td>
						<td>${dangkygiuong.getTenDangNhap().getGioiTinh()==true ? 'Nam':'Nữ'}</td>
						<td>${dangkygiuong.getNgayDangKy()}</td>
						<td><select name="tinhtrang" class="form-control">
							<option style="color: green;" value="0">Đã có người</option>
							<option style="color: red;"value="1" >Chưa đăng ký</option>
							<option style="color: yellow;"value="2"selected>Đang chờ...</option>
							<option style="color: yellow;"value="3">Đang sửa chữa</option>
						</select></td>
						<td><input type="submit" class="btn btn-primary" onclick="return confirm('Thao tác trên sẽ không hoàn lại được! Bạn có chắc thực hiện thao tác?');"></td>
					</tr>
				</form>
					
				</c:if>
				
			</c:forEach>
			
			<%
				if (dk == 0) {
			%>
		
			<form action = "/quanly/khu/phong/chon/capnhat" method ="post">
					<tr>
						
						<td><input name="iddangkygiuong" type="hidden" value="${dangkygiuong.getIdDangKyGiuong()}">${giuong.getViTriGiuong()}</td>
						<td><input name="idkhu" type="hidden" value="${giuong.getIdPhong().getIdKhu().getIdKhu()}">
						<input name="idgiuong" type="hidden" value="${giuong.getIdGiuong()}">
						<input name="idphong" type="hidden" value="${giuong.getIdPhong().getIdPhong()}">Trống</td>
						<td>Trống</td>
						<td>Trống</td>
						<td>Trống</td>
						<td>Trống</td>
						<td>Trống</td>
						<td><select name="tinhtrang" class="form-control">
							
							<option style="color: red;"value="1" selected>Chưa đăng ký</option>
							
							<option style="color: yellow;"value="3">Đang sửa chữa</option>
						</select></td>
						<td><input type="submit" class="btn btn-primary" onclick="return confirm('Bạn muốn phát phiếu cho toàn bộ các lớp?');"></td>
					</tr>
					</form>
			<%
				}
			}
			%>	
			</c:if>
			<c:if test="${giuong.isTinhTrangGiuong()==false }">
			<form action = "/quanly/khu/phong/chon/capnhat" method ="post">
				<tr>	
						<td><input name="idgiuong"type="hidden" value="${giuong.getIdGiuong()}">${giuong.getViTriGiuong()}</td>
						<td><input name="idkhu" type="hidden" value="${giuong.getIdPhong().getIdKhu().getIdKhu()}">
						
						<input name="idphong" type="hidden" value="${giuong.getIdPhong().getIdPhong()}">Trống</td>
						<td>Trống</td>
				<td>Trống</td>
				<td>Trống</td>
				<td>Trống</td>
				<td>Trống</td>
						<td><select name="tinhtrang" class="form-control">
							<option style="color: green;" value="3"selected>Đang sửa chữa</option>
							<option style="color: red;"value="4" >Mở đăng ký</option>
						</select></td>
						<td><input type="submit" class="btn btn-primary" onclick="return confirm('Thao tác trên sẽ không hoàn lại được! Bạn có chắc thực hiện thao tác?');"></td>
					</tr>
				</form>
			</c:if>
			
		</c:forEach>
		

	</table>
	<div class="col-md-3">
		<form action="/quanly/khu/phong/chon/phong=${PhongInput.getIdPhong()}&khu=${PhongInput.getIdKhu().getIdKhu()}" method="post">
			<input name="idkhu" type="hidden" value="${PhongInput.getIdKhu().getIdKhu()}">
			<input name="idphong" type="hidden" value="${PhongInput.getIdPhong()}">
			<input class="form-control1"name="vi-tri-giuong" value="" placeholder="Nhập số giường">
			<input class="btn-add" type="submit" value="Thêm giường">
		</form>
		
		
	</div>
	
	
</div>
