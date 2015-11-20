<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="mx.indexpro.modelo.Empleado"%>    
<%@page import="mx.indexpro.modelo.ConsultaEmpleado"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css"/>
<title>MenuEmpleado</title>
</head>
<body>
<center>
<div id="divisor">
<br>
	<table border="1" class="table table-bordered table-striped table-hover">
		<tr>
			<th>EMPNO</th><th>ENAME</th><th>JOB</th><th>MGR</th><th>HIREDATE</th><th>SAL</th><th>COMM</th><th>DEPNTO</th>
			<th colspan="2">Accion</th>
		</tr>
		<%
		for(Empleado temp:ConsultaEmpleado.getAllEmp()){
		 %>
		<tr>
			<td><%=temp.getEmpno()%></td>
			<td><%=temp.getEname()%></td>
			<td><%=temp.getJob()%></td>
			<td><%=temp.getMgr()%></td>
			<td><%=temp.getHiredate()%></td>
			<td><%=temp.getSal()%></td>
			<td><%=temp.getComm()%></td>
			<td><%=temp.getDeptno()%></td>
			<td><a href="controlador?action=edit&id=<%=temp.getEmpno()%>">[Editar]</a></td>
			<td><a href="controlador?action=delete&id=<%=temp.getEmpno()%>">[Eliminar]</a></td>
		</tr>
	<%}%>
</table>
</div>
<p><a href="controlador?action=insert">Add User</a></p>
</center>
</body>
</html>