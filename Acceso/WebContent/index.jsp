<%@page import="mx.indexpro.modelo.Depno"%>
<%@page import="mx.indexpro.modelo.Empleado"%>    
<%@page import="mx.indexpro.modelo.ConsultaEmpleado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.min.css" />
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css" />
<meta charset="utf-8">
</head>
<body>
	<div id="window">
		<h1>Agregar nuevo</h1><br>
			<form action="controlador" method="POST">
			<input class="textos" type="text" name="empno" id="empno" placeholder="EMPNO" maxlength="4" required/>
			<input class="textos" type="text" name="ename" id="ename" placeholder="ENAME" maxlength="10" required/>
			<input class="textos" type="text" name="job" id="job" placeholder="JOB" maxlength="9" required/>
			<input class="textos" type="text" name="mgr" id="mgr" placeholder="MGR" maxlength="4" required/>
			<input class="textos" type="text" name="hiredate" id="hiredate" placeholder="HIREDATE" required/>
			<input class="textos" type="text" name="sal" id="sal" placeholder="SAL" maxlength="7" required/>
			<input class="textos" type="text" name="comm" id="comm" placeholder="COMM" maxlength="7" required/>
			<%--<input class="textos" type="text" name="depno" id="depno" placeholder="DEPTNO" required/><br/>--%>
			<select name="depno" id="depno" class="textos" placeholder="DEPTNO EXISTENTE">
            <option>DEPTNO EXISTENTE</option>
	            <%for(Depno temp:ConsultaEmpleado.getDeptnoF()){%>
	            <option><%=temp.getDeptno()%></option>
	            <%}%>
        	</select><br>
			<input class="boton" type="submit" value="Crear nueva cuenta" id="registrar"/>
			</form>
		<div class="close">x</div>
	</div>
	<div id="window2">
		<h1>Agregar nuevo</h1><br>
			<form action="controller2" method="POST">
			<input class="textos" type="text" name="deptno" id="deptno" placeholder="DEPTNO" maxlength="2" required/>
			<input class="textos" type="text" name="dname" id="dname" placeholder="DNAME" maxlength="14" required/>
			<input class="textos" type="text" name="loc" id="loc" placeholder="LOC" maxlength="13" required/>
			<input class="boton" type="submit" value="Crear nueva cuenta" id="registrar"/>
			</form>
		<div class="close2">x</div>
	</div>
	<div id="black_screem"></div>
	<div class=container>
	<header>
		<nav>
			<ul>
				<li>
					<a href="#" onclick="registrar();">Registrar</a>
				</li>
				<li><a href="#">Empleado</a>
					<ul id="hijo1">
						<li><a href="#" class="open">Agregar</a></li>
						<li><a href="empleado.jsp">EditarEliminar</a></li>
					</ul>
				</li>
				<li>
					<a href="#">Deptno!!</a>
					<ul id="hijo2">
						<li><a href="#" class="open2">Agregassss</a></li>
						<li><a href="deptno.jsp">EditElimina</a></li>
					</ul>
				</li>
				<li><a href="#" target="">contacto</a></li>
			</ul>
		</nav>
	</header>

	<h1>HOla</h1>
	<div class="alerta">Aqui va el error</div>
	
</div>
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.js"></script>
    <script src="js/jquery-ui-1.10.4.custom.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/jquerydesing.js"></script>
</body>
</html>