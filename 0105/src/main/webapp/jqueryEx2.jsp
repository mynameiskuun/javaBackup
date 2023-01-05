<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

</head>
<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
	$(function() {
		var car = new Object();
		car.make = '삼성'
		var owner = new Object();
		car.owner = owner
		car.owner.name = '홍길동'
		console.log(car);
	});
	</script>
</body>
</html>