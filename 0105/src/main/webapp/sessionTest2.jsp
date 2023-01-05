<%@page import="jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%

Dept dept = (Dept) session.getAttribute("tt");

//필요한 정보를 여러 jsp페이지를 옮겨가며 사용할 수 있게 하는 기능
// 세션에 setAttribute로 객체를 담고, getAttribute로 사용하면 됨

%>

<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%=dept.getDeptno()%>
<%=dept.getDname()%>
<%=dept.getLoc()%>
</body>
</html>