<%@page import="jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<%

Dept dept = (Dept) session.getAttribute("tt");

//�ʿ��� ������ ���� jsp�������� �Űܰ��� ����� �� �ְ� �ϴ� ���
// ���ǿ� setAttribute�� ��ü�� ���, getAttribute�� ����ϸ� ��

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