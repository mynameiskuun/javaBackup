<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

</head>
<body>
<table class="aa" border="1"></table>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	
	<script>
	$(function() {
		$.getJSON('item.json', function(vv,tt) {
			console.log("ex1",vv);
			$.each(vv, function() {
				console.log("ex2",vv);
				console.log("ex3",this);
				console.log("ex4",this.id, this.name, this.price);
				$('.aa').append('<tr><td>'+this.name+'</tr></td>');
			})
		});
	});
	
	</script>
</body>
</html>