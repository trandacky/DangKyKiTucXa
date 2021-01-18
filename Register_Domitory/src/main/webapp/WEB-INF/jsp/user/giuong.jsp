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
<div class="text-center">
	<h3>Giường</h3>
</div>
<body>
	<div class="text-center">
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

						<%
							if (1 <= nguoidangky) {
						%>
						<img src="/image/bedyellow.jpg" class="img-size">
						${giuong.getViTriGiuong()}
					<%
						}
					%>
						<%
							if (1 <= nguoio) {
						%>
						<img src="/image/bedred.jpg" class="img-size">
						${giuong.getViTriGiuong()}
					<%
						}
					%>
						<%
							if (0 == nguoio && 0 == nguoidangky) {
						%>
						<c:if test="${disable==true}">
							<form action="/nguoidung/dangky/idgiuong=${giuong.getIdGiuong()}" method="post"><button
									class="btn btn-outline-success"
									<c:if test="${giuongdadangky!=null }">onclick="return confirm('Bạn muôn chuyển vào giường ${giuong.getViTriGiuong()} phòng: ${phong.getPhongSo() } tầng: ${tang} khu: ${khu.getTenKhu()}?');"</c:if>
									<c:if test="${giuongdadangky==null}">onclick="return confirm('Bạn muôn đăng ký vào giường ${giuong.getViTriGiuong()} phòng: ${phong.getPhongSo() } tầng: ${tang} khu: ${khu.getTenKhu()}?');"</c:if>>
									<img src="/image/bedgreen.jpg" class="img-size"> <br>
									${giuong.getViTriGiuong()}
								</button>
								<input type="hidden" value="${giuongdadangky }" name="giuongdadangky">
								</form>
						</c:if>
						<c:if test="${disable==false}">
							<img src="/image/bedgreen.jpg" class="img-size">
							${giuong.getViTriGiuong()}
						</c:if>
						<%
							}
						%>

						<%-- <c:if test="${giuong.getDangKyGiuongs().isEmpty()}">
							<c:if test="${disable==true}">
								<a href="/home/dangky/idgiuong=${giuong.getIdGiuong()}"><button
										class="btn btn-outline-success"
										onclick="return confirm('Bạn muôn đăng ký vào giường ${giuong.getViTriGiuong()} phòng: ${phong.getPhongSo() } tầng: ${tang} khu: ${khu.getTenKhu()}?');">
										<img src="/image/bedgreen.jpg" class="img-size">
										${giuong.getViTriGiuong()}
									</button></a>
							</c:if>
							<c:if test="${disable==false}">
								<img src="/image/bedgreen.jpg" class="img-size">
							</c:if>

						</c:if> --%>
					</c:if>
					<c:if test="${giuong.isTinhTrangGiuong()==false}">
						<img src="/image/bedwhite.jpg" class="img-size">
					${giuong.getViTriGiuong()}
				</c:if>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>