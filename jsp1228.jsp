<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> 함수</h1>

<script>

/* var ss = 100;
function test() {
	var x = 10;
	const y = 20;
	
	console.log("x:"+x);
	console.log("y:"+y);
}
console.log(ss) */

/* var sum = function(a,b) {
	console.log(a+b)
} */
let sum = (a,b) => a+b;
const hi = () => console.log("안녕");

console.log(sum(1,2));
hi();

sum = "test";
console.log(sum);

</script>
</body>
</html>