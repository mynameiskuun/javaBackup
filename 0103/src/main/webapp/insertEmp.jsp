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
	
	String empnoS = request.getParameter("empno");
	String mgrS = request.getParameter("mgr");
	String salS = request.getParameter("sal");
	String commS = request.getParameter("comm");
	String deptnoS = request.getParameter("deptno");
	
	try {
		int empno = Integer.parseInt(empnoS);
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = Integer.parseInt(mgrS);
		String hiredate = request.getParameter("hiredate");
		int sal = Integer.parseInt(salS);
		int comm = Integer.parseInt(commS);
		int deptno = Integer.parseInt(deptnoS);
		
		Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
		int result = edd.insertEmpTemp(emp);
		out.println(result+"건 입력 완료!");
		
	} catch (java.lang.NumberFormatException e) {
		int empno = 0;
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = 0;
		String hiredate = request.getParameter("hiredate");
		int sal = 0;
		int comm = 0;
		int deptno = 0;
	}
%>
</body>
</html>