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
var dog = {name : "�Ļ�",
		   family : "�����ڱ�",
		   age : 1,
		   weight: 2.14
			};
// �ڹٽ�ũ��Ʈ ��ü
var data = JSON.stringify(dog); // �ڹٽ�ũ��Ʈ ��ü�� ���ڿ��� ��ȯ��.
console.log(dog);
console.log(data);
document.getElementById("json").innerHTML = data;
</script>
</body>
</html>