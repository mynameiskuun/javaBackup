<%@page import="jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
int num = Integer.parseInt(request.getParameter("empno"));
EmpDao ed = EmpDao.getInstance1();
Emp emp = ed.select(num);
out.print(emp.toString());
%>
// jsp의 작동원리

</body>
</html>