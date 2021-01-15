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
	<table class="table table-striped text-center">
		<c:forEach items="${listgiuong}" var="giuong">
			<tr class="text-center">
				<c:if test="${giuong.isTinhTrangGiuong()==true}">
					<%
						int nguoidangky = 0;
					int nguoio = 0;
					%>
					<c:forEach items="${giuong.getDangKyGiuongs()}" var="dangkygiuong">
						<c:if test="${dangkygiuong.getTinhTrangDangKy()==2}">
							<%
								nguoidangky++;
							%>
						</c:if>
						<c:if test="${dangkygiuong.getTinhTrangDangKy()==0}">
							<%
								nguoio++;
							%>
						</c:if>

					</c:forEach>

					<c:if test="${nguoidangky>=1}">
						<img src="/image/bedyellow.jpg" class="img-size2">
					</c:if>
					<c:if test="${nguoio>=1}">
						<img src="/image/bedred.jpg" class="img-size2">
					</c:if>
					<c:if test="${nguoio==0&&nguoidangky==0}">
						<button style="border: none; background: white;"
							onclick="return confirm('Bạn muôn đăng ký vào giường ${giuong.getViTriGiuong()} phòng: ${phong.getPhongSo() } tầng: ${tang} khu: ${khu.getTenKhu()}?');">
							<a href="/home/dangky/idgiuong=${giuong.getIdGiuong()}"><img
								src="/image/bedgreen.jpg" class="img-size2"></a>
						</button>
					</c:if>
					<c:if test="${dangkygiuong==null}">
						<button style="border: none; background: white;"
							onclick="return confirm('Bạn muôn đăng ký vào giường ${giuong.getViTriGiuong()} phòng: ${phong.getPhongSo() } tầng: ${tang} khu: ${khu.getTenKhu()}?');">
							<a href="/home/dangky/idgiuong=${giuong.getIdGiuong()}"><img
								src="/image/bedgreen.jpg" class="img-size2"></a>
						</button>
					</c:if>
				</c:if>
				<c:if test="${giuong.isTinhTrangGiuong()==false}">

					<img src="/image/bedwhite.jpg" class="img-size2">

				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>