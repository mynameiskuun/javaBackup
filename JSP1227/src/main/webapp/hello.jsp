<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>Web Programming</h1>
<input id="in" /><button id="btn">Ŭ��</button>

<ul id="itemList">
<li>HTML</li>
<li>CSS</li>
<li>JS</li>
</ul>

<script>

btn.addEventListener("click",
		// btn ��ư�� Ŭ���ϸ� �Ʒ��� �Լ��� ����ȴ�.
        function() {
			var tf = document.getElementById("in");
			var newLi = document.createElement("li");
			// <li>�±׸� �����  ||  <li></li> �ϼ�
			var inT = document.getElementById("in").value;
			// �ؽ�Ʈ �ʵ忡 �Էµ� ���� ������ �����Ѵ� 
			var txNode = document.createTextNode(inT);
			// inT ������ ��� �ؽ�Ʈ�� node�� ����� ������ �����Ѵ�
			// �ʿ������ ������ ���ϸ� ���� �߻�
            newLi.appendChild(txNode);
			// <li>�±׿� txNode���� �߰��Ѵ�. ||  <li>value</li> �ϼ�
			document.getElementById("itemList").appendChild(newLi);
			// �ϼ��� <li>value</li> ���� <ul></ul> �±� ���� �߰��Ѵ�.
			
			tf.value="";
			// <ul>�±׿� <li>�±װ� �߰��� ���� �ؽ�Ʈ�ʵ带 �������� �ʱ�ȭ ��Ų��.
        });

/* var newP = document.createElement("li")
var txNode = document.createTextNode("�׽�Ʈ");
newP.appendChild(txNode);
document.getElementById("itemList").appendChild(newP); */


</script>
</body>
</html>