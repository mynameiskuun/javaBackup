<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<div id = "json">
</div>
<body>
<script type="text/javascript">
var dog = {name : "식빵",
		   family : "웰시코기",
		   age : 1,
		   weight: 2.14
			};
// 자바스크립트 객체
var data = JSON.stringify(dog); // 자바스크립트 객체를 문자열로 변환함.
console.log(dog);
console.log(data);
document.getElementById("json").innerHTML = data;
</script>
</body>
</html>