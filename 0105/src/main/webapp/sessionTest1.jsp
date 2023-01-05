<%@page import="jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%

Dept dept = new Dept(10,"test","SEOUL");
session.setAttribute("tt", dept);

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