<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<div id="aa"></div>
	<div id="bb"></div>
	<script>
	$(function() {
		var list = [123, '<h2>3.45</h2>', '테스트', new Date()];
		console.log(list);
		
		$("#aa").html(list);
	});
	
	$(function() {
		var list1 = [123, '<h1>3.45</h1>' , '테스트', new Date()];
		console.log(list);
		
		$("#bb").html(list1);
	});
	</script>
</body>
</html>