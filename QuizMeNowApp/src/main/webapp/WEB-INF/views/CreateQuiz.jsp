<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create quiz</title>
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
<h1>Create quiz</h1>
<div id="create">
<form:form method="POST" modelAttribute="quiz" action="/create">
   <table>
    <tr>
        <td><form:label path="QuizName">QuizName</form:label></td>
        <td><form:input path="QuizName" /></td>
        <td><form:errors path="QuizName"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="description">Description</form:label></td>
        <td><form:input path="description" /></td>
        <td><form:errors path="description"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="priority">Priority</form:label></td>
        <td><form:input path="priority" /></td>
        <td><form:errors path="priority"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="important">Important</form:label></td>
        <td><form:checkbox path="important" /></td>
        <td><form:errors path="important"  cssClass="error" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add" name="add" class="btn btn-default"/>
        </td>
        <td colspan="2">
            <input type="submit" value="Cancel" name="cancel" class="btn btn-default"/>
        </td>
    </tr>
</table>  
</form:form>
</div>
</body>
</html>
