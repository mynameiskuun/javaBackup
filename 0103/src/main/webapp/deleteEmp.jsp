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
	Dao edd = Dao.getInstance();
	
	String empnoS = request.getParameter("del_empno");
	String mgrS = request.getParameter("mgr");
	String salS = request.getParameter("sal");
	String commS = request.getParameter("comm");
	String deptnoS = request.getParameter("del_deptno");
	
	try {
		int empno = Integer.parseInt(empnoS);
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = Integer.parseInt(mgrS);
		String hiredate = request.getParameter("hiredate");
		int sal = Integer.parseInt(salS);
		int comm = Integer.parseInt(commS);
		int deptno = Integer.parseInt(deptnoS);
		
		// int result = edd.deleteEmpTemp(emp);
		out.println("삭제 완료!");
		
	} catch (java.lang.NumberFormatException e) {
		int empno = 0;
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = 0;
		String hiredate = request.getParameter("hiredate");
		int sal = 0;
		int comm = 0;
		int deptno = 0;
		out.println("다시해");
	}
%>
</body>
</html>