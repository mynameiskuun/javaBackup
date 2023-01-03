<%@page import="java.util.List"%>
<%@page import="jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
Dao edd = Dao.getInstance();
List<Dept> dlist = edd.selectDept();
%>
<form action="deleteEmp.jsp" method="post">
<table border="1">
<tr><td>사번</td><td><input type="text" name="del_empno" /></td></tr>
<tr><td>이름</td><td><input type="text" name="del_ename" /></td></tr>
<tr><td>부서번호</td><td>
<select name="del_deptno">
<option>부서선택</option>
<% for(Dept dept : dlist) { %>
<option value="<%=dept.getDeptno()%>"><%=dept.getDname()%></option>
<% } %>
</select>
</td></tr>
<tr><td>확인</td><td><input type="reset" name="초기화" />
<input type="submit" value="삭제" />
</td></tr>
</table>
</form>
</body>
</html>