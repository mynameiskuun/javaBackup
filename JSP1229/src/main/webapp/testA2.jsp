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
<span id="tt"></span>
<input type="button" id="exe" value="실행" />
</p>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$('#exe').click(function() {
	$.ajax({
		url : './list.jsp',
		success : function(data) {
			$('#tt').html(data);
		}
	})
});
</script>
</body>
</html>