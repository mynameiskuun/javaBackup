<%@page import="java.util.List"%>
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
EmpDeptDao edd = EmpDeptDao.getInstance();
List<Dept> dlist = edd.selectDept();
%>
<form action="insertEmp.jsp" method="post">
<table border="1">
<tr><td>���</td><td><input type="text" name="empno" /></td></tr>
<tr><td>�̸�</td><td><input type="text" name="ename" /></td></tr>
<tr><td>����</td><td><input type="text" name="job" /></td></tr>
<tr><td>����� ���</td><td><input type="text" name="mgr" /></td></tr>
<tr><td>�Ի���</td><td><input type="text" name="hiredate" /></td></tr>
<tr><td>�޿�</td><td><input type="text" name="sal" /></td></tr>
<tr><td>���ʽ�</td><td><input type="text" name="comm" /></td></tr>
<tr><td>�μ���ȣ</td><td>
<select name="deptno">
<option>�μ�����</option>
<% for(Dept dept : dlist) { %>
<option value="<%=dept.getDeptno()%>"><%=dept.getDname()%></option>
<% } %>
</select>
</td></tr>
<tr><td>Ȯ��</td><td><input type="reset" name="�ʱ�ȭ" />
<input type="submit" value="����" /></td></tr>
</table>
</form>
</body>
</html>