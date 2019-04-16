<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quiz list</title>
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
<h1>Quiz list</h1>

<div id="create">
	<table>	
	<tr>
	  <td><h3>Quiz name</h3></td>
	  <td><h3>|</h3></td>
	  <td><h3>Description</h3></td>
	  <td><h3>|</h3></td>
	  <td><h3>Priority</h3></td>
	  <td><h3>|</h3></td>
	  <td><h3>Important</h3></td>
	  <td><h3></h3></td>
	 
	</tr>
	<c:forEach items="${quizs}" var="quiz">
	<tr>
		<td><c:out value="${quiz.quizName}"/></td>
		<td><h3></h3></td>
		<td><c:out value="${quiz.description}"/></td>
		<td><h3></h3></td>
		<td><c:out value="${quiz.priority}"/></td>
		<td><h3></h3></td>
		<td><c:out value="${quiz.important}"/></td>
		<td><h3></h3></td>
		<td><a href="/delete?id=${quiz.id}">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
</div>

<div id="buttons">
	

	<a href="/create" class="btn btn-default">Add Quiz</a>
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
