<%@page import="java.sql.Connection"%>
<%@page import="oracle.net.nt.ConnectDescription"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="practice.*"%>

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
Dao dao = new Dao();

%>
<p>key</p><input type="text" id = "key">

<p>id</p><input type="text" id = "id">

<p>name</p><input type="text" id = "name">

<button id="insBtn">���</button>

<button id="check" onclick="insert()">üũ</button>

<script>

function insert() {
	
	if(key.value != "") {
		console.log("key ���� �ƴ�")
		return;
	};
	if(id.value != "") {
		console.log("id ���� �ƴ�")
		return;
	};
	if(name.value != "") {
		console.log("name ���� �ƴ�")
		return;
	};
	<%=String key = key.value %>
	<%= %>
	<%= %>
	<%= %>
	
<% 
	
	String sql = "insert into table1 (KEY, ID, NAME) values (? ? ?)";
	
	PreparedStatement pstmt;
	Connection conn;
	
	ResultSet rs = pstmt.executeQuery(sql);
	
	%>
}
</script>
</body>
</html>