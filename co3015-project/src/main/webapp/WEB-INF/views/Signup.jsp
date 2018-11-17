<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" media="screen" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
<html>

<head>
    <title>Login</title>
        <style>
    .error {
        color: #ff0000;
    }
    
    .errorblock{
        color: #000;
        background-color: #ffEEEE;
        border: 3px solid #ff0000;
        padding:8px;
        margin:16px;
    }
    
    
    #footer {
   position:fixed;
    bottom:0;
    width:100%;
    height:60px;   /* Height of the footer */
    background:black;
    padding-right:4px;
      }
      body{
     background-image:url("http://corporatespring.com/wp-content/uploads/2016/10/web-businesspeople-laughing.jpg");
 
    background-repeat: no-repeat;
 
    background-size: cover;
    }
    
       ul {
     list-style-type: none;
     margin: 0;
     padding: 0;
     }
    li {
     float: left;
     }
    a:hover, a:active {
     background-color: #4da6ff;
     } 
    *{
     padding : 0px;
     margin : 0px;
     border : 0px;
    }
    
    a.footerlinks {
     display: block;
     width: 20vw;
     font-weight: bold;
     color: white;
     background-color:black;
     text-align: center;
     text-decoration: none;
     text-transform: uppercase;
     }
    a.headerlinks {
     display: block;
     width: 25vw;
     font-weight: bold;
     color: white;
     background-color:black;
     text-align: center;
     text-decoration: none;
     text-transform: uppercase;
    }
    #header {
     background-color:black;
     color:white;
     text-align:center;
     height: 10vh;
     top: 0;
     left: 0;
     right: 0;
     margin: 0 auto;
    }
     
    #nav {
     background-color:black;
     color:white;
     text-align:left;
     height: 5vh;
    }
    #container {
    width: 95vw;
    height: 85vh;
    clear:both;
    }
    #newsfeed {
    background-color:#cccccc;
    color:black;
    text-align:center;
    height:85vh;
    width:75vw;
    overflow:scroll;
    float:left;
    }
    #social {
    background-color:#cccccc;
    color:black;
    text-align:left;
    height:85vh;
    width:20vw;
    overflow:scroll;
    float:left;
    }
    #login {
    float:center;
    margin:auto;
    text-align:center;
    background-color:#cccccc;
    width:20vw;
    }
    #emptydiv {
    height:10vh;
    }
}
 </style>

 </head>

 <body>

<div id="header">

<h1>

 <font face="courier new">

 <font size="36">

 <font color="#FFFFFF"> FDM </font> 

 </font>

 </h1>

</div>

<div id="nav">

</div>

<div id="emptydiv">

</div>

<div id="login">


<form:form method="POST" commandName="userInfo" action="/signup/add">
   <table>
    <tr>
        <td><form:label path="forenames">Forenames</form:label></td>
        <td><form:input path="forenames" /></td>
        <td><form:errors path="forenames"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="lastnames">Last names</form:label></td>
        <td><form:input path="lastnames" /></td>
        <td><form:errors path="lastnames"  cssClass="error" /></td>
    </tr>
     <tr>
        <td><form:label path="email">e-mail</form:label></td>
        <td><form:input path="email" /></td>
        <td><form:errors path="email"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="username">username</form:label></td>
        <td><form:input path="username" /></td>
        <td><form:errors path="username"  cssClass="error" /></td>
    </tr>
     <tr>
        <td><form:label path="age">age</form:label></td>
        <td><form:input path="age" /></td>
        <td><form:errors path="age"  cssClass="error" /></td>
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
</div> 
<div id="footer">

<li><a class="footerlinks" href="https://en-gb.facebook.com/FDMGroup/" > Facebook </a>.</li>

<li><a class="footerlinks" href="https://twitter.com/fdmgroup?lang=en" > twitter </a>.</li>

<li><a class="footerlinks" href="https://www.linkedin.com/company/fdm-group" > linkedin </a>.</li>

<li><a class="footerlinks" href="https://www.youtube.com/user/FDMGroupVideos" > youtube </a>.</li>

<li><a class="footerlinks" href="https://www.instagram.com/fdm_group/?hl=en" > instagram </a>.</li>

</div>
</body>
</html>