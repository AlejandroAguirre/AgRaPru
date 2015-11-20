<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="mx.indexpro.modelo.Depno"%>    
<%@page import="mx.indexpro.modelo.ConsultaDepno"%> 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<center>Edite o Elimine</center>
<center>
<div id="divisor">
<table border="1" class="table table-bordered table-striped table-hover">
		<tr>
			<th>DEPTNO</th><th>DNAME</th><th>LOC</th>
			<th colspan="2">Accion</th>
		</tr>
		<%
		for(Depno temp:ConsultaDepno.getAllDeptno()){
		 %>
		<tr>
			<td><%=temp.getDeptno()%></td>
			<td><%=temp.getDname()%></td>
			<td><%=temp.getLoc()%></td>
			<td><a href="controller2?action=edit&id=<%=temp.getDeptno()%>">[Editar]</a></td>
			<td><a href="controller2?action=delete&id=<%=temp.getDeptno()%>">[Eliminar]</a></td>
		</tr>
	<%}%>
</table>
</div>
<p><a href="controller2?action=insert">Add User</a></p>
</center>
</body>
</html>