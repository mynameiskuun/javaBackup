<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<label> 이름을 입력하세요 : </label> 
		<input type="text" name="username" class="username" /> 
		<br/> 
		<input type="button" id="submit" value="전송" />
	</form>
	<div id="message"></div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(function() {
			$('#submit').click(function() {
				var username = $('.username').val();
				var sendData = 'username=' + username;
				
				$.post{
					"welcome.jsp",
					sendData,
					function(msg) {
						$('#message').html(msg);
					});
				return false;
			});
		});
	</script>
</body>
</html>