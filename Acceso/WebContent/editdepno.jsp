<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.min.css" />
<link rel="stylesheet" href="css/jquery-ui-1.10.4.custom.css" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
<h1>Editar</h1>
	<form action="updatedepno" method="POST">
	<input class="textos" type="text" value="<c:out value="${dep.deptno}" />" name="deptno" id="deptno" placeholder="DEPTNO" maxlength="2" required/>
	<input class="textos" type="text" value="<c:out value="${dep.dname}" />" name="dname" id="dname" placeholder="DNAME" maxlength="14" required/>
	<input class="textos" type="text" value="<c:out value="${dep.loc}" />" name="loc" id="loc" placeholder="LOC" maxlength="13" required/>
	<input class="boton" type="submit" value="Modificar" id="registrar"/>
	</form>
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script src="js/jquery-ui-1.10.4.custom.js"></script>
    <script src="js/jquery-ui-1.10.4.custom.min.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript" src="js/jquerydesing.js"></script>
</body>
</html>