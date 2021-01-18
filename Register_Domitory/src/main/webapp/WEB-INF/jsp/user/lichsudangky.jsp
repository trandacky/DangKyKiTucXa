<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lịch sử</title>
</head>
<style>
$
.confirm( {
	title: 'Confirm!', content: 'Simple confirm!', confirm: function(){
        alert('Confirmed!');
}

,
cancel: function() {alert ('Canceled!')
	
}
}
)






;
</style>
<body>
	<c:import url="/WEB-INF/jsp/HeaderUser.jsp" />
	<div class="text-center">
		<table class="table table-striped">
			<tr>
				<th>Ngày đăng ký</th>
				<th>Giường</th>
				<th>Phòng</th>
				<th>Giá</th>
				<th>Khu</th>
			</tr>
			<c:forEach items="${listlichsu}" var="dangkygiuong">
				<tr>

					<td>${dangkygiuong.getNgayDangKy()}</td>
					<td>${dangkygiuong.getIdGiuong().getViTriGiuong()}</td>
					<td>${dangkygiuong.getIdGiuong().getIdPhong().getPhongSo()}</td>
					<td>${dangkygiuong.getIdGiuong().getIdPhong().getGiaTien()}</td>
					<td>${dangkygiuong.getIdGiuong().getIdPhong().getIdKhu().getTenKhu()}</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>