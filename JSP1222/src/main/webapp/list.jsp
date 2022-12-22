<%@ page import="jdbc.*" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">

	<input type = "text" name = "id">
	<input type = "password" name = "pass"> 
<%		

	/* int x = Integer.parseInt(request.getParameter("deptno"));
	Connection conn = null;
	EmpDao ed = EmpDao.getInstance();
	PreparedStatement pstm;
	
	String sql = "select * from emp where DEPTNO = ?";
	pstm = conn.prepareStatement(sql);	
	pstm.setInt(1,x);
	ResultSet rs = pstm.executeQuery();
	
	*/
	EmpDao ed = EmpDao.getInstance();
	
	for (Emp emp : ed.selectAll()) 
	{
%>
	
	<h1>
	<tr>
	<td><%=emp.getEname() %></td>
	<td><a href="content.jsp?empno=<%=emp.getEmpno()%>"><%=emp.getEmpno()%></a></td>
	<td><%=emp.getJob() %></td>
	<td><%=emp.getDeptno() %></td>
	</tr>
	</h1>
<%		
	}
%>

</table>
</body>
</html>