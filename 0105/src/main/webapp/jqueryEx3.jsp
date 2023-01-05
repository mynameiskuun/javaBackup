<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
<div class="aa"></div>
<table class="bb"></table>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(function() {
			var list =['홍','김','이','박']; 
			$.each(list,function(i,v) {
				console.log(v);
				$('.aa').append(v+'<br/>');
			});
		});
		
		$(function() {
			var list1 =['홍','ㄴㄴㄴ','이','박']; 
			$.each(list1,function(i,v) {
				console.log(v);
				$('.bb').append('<tr><td>'+v+'</tr></td>');
			});
		});
	</script>
</body>
</html>