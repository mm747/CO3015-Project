<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<link rel="stylesheet" media="screen" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet.css">
    <title>Create User</title>
  
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
<h1>Create User</h1>

<div id="create">
<form:form method="POST" modelAttribute="orgUser" action="/admin/createUser">
   <table>
   <tr>
        <td><form:label path="fname">First name</form:label></td>
        <td><form:input path="fname" /></td>
        <td><form:errors path="fname"  cssClass="error" /></td>
    </tr>
   <tr>
        <td><form:label path="surname">Surname</form:label></td>
        <td><form:input path="surname" /></td>
        <td><form:errors path="surname"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="login">user name</form:label></td>
        <td><form:input path="login" /></td>
        <td><form:errors path="login"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:password path="password" /></td>
        <td><form:errors path="password"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="password2">Repeat password</form:label></td>
        <td><form:password path="password2" /></td>
        <td><form:errors path="password2"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><label>Role</label></td>
        <td><select name="roleName">
          <option value="TEACHER">Teacher</option>
  		  <option value="USER">User</option>
		  <option value="ADMIN">Admin</option>
        </select></td>
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
