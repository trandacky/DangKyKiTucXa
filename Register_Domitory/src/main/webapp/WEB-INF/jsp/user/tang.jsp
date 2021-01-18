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
</style>
<div class="text-center"><h3>Tầng</h3></div>
<table class="table table-striped text-center">
	<c:forEach var="i" begin="1" end="${khu.getSoTang()}">
		<th><a href="/home/khu/idkhu=${khu.getIdKhu()}&tang=${i}">
				<button
					class="btn btn-outline-success<c:if test="${tang==i}"> active</c:if>">
					<img class="img-size2" src="/image/tang.jpg"><br>Tầng
					${i}
				</button>
		</a>
		<th>
	</c:forEach>

</table>