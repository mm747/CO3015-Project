<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Searched user</title>
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
<h1>Searched User</h1>

<div id="create">
	<table>	
	<tr>
	  <td><h3>First name</h3></td>
	  <td><h3>|</h3></td>
	  <td><h3>Surname</h3></td>
	  <td><h3>|</h3></td>
	  <td><h3>login</h3></td>
	  <td><h3>|</h3></td>
	  <td><h3>Role</h3></td>
	  <td><h3></h3></td>
	 
	</tr>
	<c:forEach items="${users}" var="user">
	<tr>
		
		<td><c:out value="${user.fname}"/></td>
		<td><h3></h3></td>
		<td><c:out value="${user.surname}"/></td>
		<td><h3></h3></td>
		<td><c:out value="${user.login}"/></td>
		<td><h3></h3></td>
		<td><c:out value="${user.role.role}"/></td>
		<td><h3></h3></td>
		<td><a href="delete?id=${user.id}">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
</div>

<div id="buttons">
	

	<a href="createUser/" class="btn btn-default">Add User</a>
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
