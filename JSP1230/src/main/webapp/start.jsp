<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<p>
		<span id="tb"></span> <span id="tb2"></span> <input type="button"
			id="exe" value="사원정보" />
	</p>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		/* function order(v) {
		 console.log(v);
		 $.ajax({
		 url:'list.jsp?order='+v,
		 success : function(data) {
		 $('#tb').html(data);
		 } 
		 })
		 } */
		function detail(empno) {
			console.log(empno);
			$.ajax({
				url : 'content.jsp?empno=' + empno,
				success : function(data) {
					$('#tb2').html(data)
				}
			})
		}

		$('#exe').click(function() {
			$.ajax({
				url : 'list.jsp',
				success : function(data) {
					//console.log(data);
					$('#tb').html(data);
				}
			});
		});

		/* $('#exe').click(function() {
			$.ajax({
				url : 'list.jsp',
				success : function(data) {
					//console.log(data);
					$('#tb2').html(data);
				}
			});
		}); */
		function order(v) {
			console.log(v);
			$.ajax({
				url:'list.jsp?order='+v,
				success : function(data) {
					$('#tb').html(data);
				} 
			})
		}
	</script>
	
</body>
</html>