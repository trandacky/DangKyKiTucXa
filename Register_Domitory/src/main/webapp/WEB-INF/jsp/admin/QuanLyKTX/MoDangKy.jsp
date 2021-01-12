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
.form-mdk{
	
	border-radius: 2px;
}
</style>
<body>
	<c:import url="/WEB-INF/jsp/headerAdmin.jsp" />
	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">${message}</div>
	</c:if>
	<div style="margin: auto;
  width: 50%;"><h3>Mở đăng ký</h3></div>
	<div class="form-control" style=" margin: auto;
  width: 50%;
  border: 3px solid #007bff;
  padding: 10px;">
		<form action="/quanly/modangky" method="post">
			<span>Thời gian mở</span>
			<input style="width: 35%;    margin: 5px 5px;" class="form-control"value="${thoigianmo}" type="datetime-local" name="thoigianmo">
			<span>Thời gian đóng</span>
			<input style="width: 35%;     margin: 5px 5px;"class="form-control"value="${thoigiandong}" type="datetime-local" name="thoigiandong">
			<input style="    margin: 5px 5px;"class="btn btn-primary" type="submit" value="Cập nhật">
		</form>
	</div>
</body>
</html>