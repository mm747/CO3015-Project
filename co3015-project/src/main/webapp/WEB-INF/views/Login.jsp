<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<title>Login</title>
<head>
 <style>
 body {
    background-image:url("http://corporatespring.com/wp-content/uploads/2016/10/web-businesspeople-laughing.jpg");
 
background-repeat: no-repeat;
 
background-size: cover;
}
#footer {
   position:fixed;
    bottom:0;
    width:100%;
    height:60px;   /* Height of the footer */
    background:black;
    padding-right:4px;
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
width:10vw;
}
#register {
    text-align: center;
    display: inline-block;
    padding: 10px;
}
#emptydiv{
height:10vh;
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
<div id="emptydiv">
</div>
<div id="login">
<form:form method="POST" commandName="userInfoLogin" action="/login">
   <table>
    <tr>
        <td><form:label path="username"> username  </form:label></td>
        <td><form:input path="username" /></td>
        <td><form:errors path="username"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="password">Password</form:label></td>
        <td><form:input path="password" /></td>
        <td><form:errors path="password"  cssClass="error" /></td>
    </tr>
    <tr>
        <td colspan="1">
        		<input type="hidden"                        
				name="${_csrf.parameterName}"
				value="${_csrf.token}"/>
            <input type="submit" value="Accept" name="accept" class="btn btn-default"/>
        </td>
        <td colspan="1">
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
</body>
</html>
