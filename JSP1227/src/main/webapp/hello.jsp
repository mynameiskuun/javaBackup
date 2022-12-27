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
<input id="in" /><button id="btn">클릭</button>

<ul id="itemList">
<li>HTML</li>
<li>CSS</li>
<li>JS</li>
</ul>

<script>

btn.addEventListener("click",
		// btn 버튼을 클릭하면 아래의 함수가 실행된다.
        function() {
			var tf = document.getElementById("in");
			var newLi = document.createElement("li");
			// <li>태그를 만든다  ||  <li></li> 완성
			var inT = document.getElementById("in").value;
			// 텍스트 필드에 입력된 값을 변수에 저장한다 
			var txNode = document.createTextNode(inT);
			// inT 변수에 담긴 텍스트를 node로 만들어 변수에 저장한다
			// 필요없을것 같지만 안하면 오류 발생
            newLi.appendChild(txNode);
			// <li>태그에 txNode값을 추가한다. ||  <li>value</li> 완성
			document.getElementById("itemList").appendChild(newLi);
			// 완성된 <li>value</li> 블럭을 <ul></ul> 태그 내에 추가한다.
			
			tf.value="";
			// <ul>태그에 <li>태그가 추가된 이후 텍스트필드를 공란으로 초기화 시킨다.
        });

/* var newP = document.createElement("li")
var txNode = document.createTextNode("테스트");
newP.appendChild(txNode);
document.getElementById("itemList").appendChild(newP); */


</script>
</body>
</html>