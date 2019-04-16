<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main menu</title>
	<link rel="stylesheet" media="screen" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">
</head>
<body style="background-color:powderblue;">
<div id="header">

<h1>

 <font face="courier new">

 <font size="36">

 <font color="#FFFFFF"> QUIZ ME NOW </font> 

 </font>

 </h1>

</div>
<h1>Main menu</h1>

<div id="create">
<table>	
	<tr><a href="/create/" class="btn btn-default">Add quiz</a></tr>
	<tr><a href="/list" class="btn btn-default">view list of quiz</a></tr>
</table>
</div>
	<c:url value="/logout" var="logoutUrl"/>
	<form action="${logoutUrl}" method="get">       
		<input type="hidden"                        
			name="${_csrf.parameterName}"
			value="${_csrf.token}"/>
		<button type="submit" class="btn">Log out</button>
	</form>				
</body>
</html>
