<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<ul id="target"><li>��<strong>��</strong>��</li></ul>

<input type="text" id="in1" />
<button id="t1">text</button>
<button id="h1">html</button><br/>

<h2 id="h2">Ŭ��!</h2>
<h2 id="h3">���̱�</h2>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>

<script>

$(function() {
	$("#t1").click(function() {
		$("#target").text($('#in1').val());
		//alert($("#target").text());
	});
	$("#h1").click(function() {
		$("#target").html("<li>"+ $('#in1').val() +"</li>");
		//alert($("#target").html());
	});
	$("#h2").click(function() {
		$(this).hide();
	});
	$("#h3").click(function() {
		$("#h2").show();
	});
});

</script>
</body>
</html>