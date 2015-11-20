<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="mx.indexpro.modelo.Depno"%>    
<%@page import="mx.indexpro.modelo.Empleado"%> 
<%@page import="mx.indexpro.modelo.ConsultaEmpleado"%>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.min.css" />
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css" />
<title>Insert title here</title>
</head>
<body>
<h1>Update</h1>
<br>
<center><h1>Edite</h1></center>
<form action="updateempleado" method="POST">
			<input class="textos" type="text" value="<c:out value="${emp.empno}" />" name="empno" id="empno" placeholder="EMPNO" maxlength="4" required/>
			<input class="textos" type="text" value="<c:out value="${emp.ename}" />" name="ename" id="ename" placeholder="ENAME" maxlength="10" required/>
			<input class="textos" type="text" value="<c:out value="${emp.job}" />" name="job" id="job" placeholder="JOB" maxlength="9" required/>
			<input class="textos" type="text" value="<c:out value="${emp.mgr}" />" name="mgr" id="mgr" placeholder="MGR" maxlength="4" required/>
			<input class="textos" type="text" value="<c:out value="${emp.hiredate}" />" name="hiredate" id="hiredate" placeholder="HIREDATE" required/>
			<input class="textos" type="text" value="<c:out value="${emp.sal}" />" name="sal" id="sal" placeholder="SAL" maxlength="7" required/>
			<input class="textos" type="text" value="<c:out value="${emp.comm}" />" name="comm" id="comm" placeholder="COMM" maxlength="7" required/>
			<select name="depno" id="depno" class="textos" placeholder="DEPTNO EXISTENTE">
            <option>DEPTNO EXISTENTE</option>
	            <%for(Depno temp:ConsultaEmpleado.getDeptnoF()){%>
	            <option><%=temp.getDeptno()%></option>
	            <%}%>
        	</select><br>
			<input class="boton" type="submit" svalue="UPDATE" id="registrar"/>
			</form>
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.js"></script>
    <script src="js/jquery-ui-1.10.4.custom.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/jquerydesing.js"></script>
</body>
</html>