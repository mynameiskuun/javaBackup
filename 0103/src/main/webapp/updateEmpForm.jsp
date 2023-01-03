<%@page import="java.util.List"%>
<%@page import="jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
int empno = Integer.parseInt(request.getParameter("empno"));
Dao edd = Dao.getInstance();
List<Dept> dlist = edd.selectDept();
Emp emp = edd.selectEmpTemp(empno); 
Dept dt = edd.selectDeptTemp(emp.getDeptno());
int num = dt.getDeptno();
%>
<form action="updateEmp.jsp" method="post">
<table border="1">
<tr><td>사번</td><td><input type="text" name="empno" value="<%=emp.getEmpno() %>" readonly /></td></tr>
<tr><td>이름</td><td><input type="text" name="ename" value="<%=emp.getEname() %>"/></td></tr>
<tr><td>직무</td><td><input type="text" name="job" value="<%=emp.getJob() %>"/></td></tr>
<tr><td>상급자 사번</td><td><input type="text" name="mgr" value="<%=emp.getMgr() %>"/></td></tr>
<tr><td>입사일</td><td><input type="text" name="hiredate" value="<%=emp.getHiredate() %>"/></td></tr>
<tr><td>급여</td><td><input type="text" name="sal" value="<%=emp.getSal() %>"/></td></tr>
<tr><td>보너스</td><td><input type="text" name="comm" value="<%=emp.getComm() %>"/></td></tr>
<tr><td>부서번호</td><td>
<select name="deptno">
<option>부서선택</option>
 <% for(Dept dept : dlist) { 
 	if(dept.getDeptno() == num) {
 %>
<option value="<%=dept.getDeptno()%>" selected><%=dept.getDname()%></option>
<% } else {%>
<option value="<%=dept.getDeptno()%>"><%=dept.getDname()%></option> 
<% } 
 } %>
</select>
</td></tr>
<tr><td>확인</td><td><input type="reset" name="초기화" />
<input type="submit" value="저장" /></td></tr>
<input type="submit" value="삭제" formaction="./deleteEmp2.jsp" />
</table>
</form>
</body>
</html>