<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" media="screen" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login page</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
<h1>Registration Page</h1>
<form:form method="POST" commandName="userInfo" action="/register-form/add">
   <table>
   <tr>
        <td><form:label path="forenames">first-name</form:label></td>
        <td><form:input path="forenames" /></td>
        <td><form:errors path="forenames"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="lastnames">last-name</form:label></td>
        <td><form:input path="lastnames" /></td>
        <td><form:errors path="lastnames"  cssClass="error" /></td>
    </tr>
     <tr>
        <td><form:label path="age">age</form:label></td>
        <td><form:input path="age" /></td>
        <td><form:errors path="age"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="username">User-name</form:label></td>
        <td><form:input path="username" /></td>
        <td><form:errors path="username"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password" /></td>
        <td><form:errors path="password"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="password2">Password (verification)</form:label></td>
        <td><form:input path="password2" /></td>
        <td><form:errors path="password2"  cssClass="error" /></td>
    </tr>
    <tr>
    		<td><form:label path="userType">User type</form:label></td>
    		<td>
    		<form:select path="userType">
   			<c:forEach var="userType" items="${userTypeValues}">
    				<option value="${userType}">${userType}</option>
			</c:forEach>
		</form:select>
		</td>
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
</body>
</html>