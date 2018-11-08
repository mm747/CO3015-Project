<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login page</title>
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

width:12vw;
}
#emptydiv {
height:10vh;
}

.error {
	color: red;
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

<p>
<c:if test="${error == true}">
	<b class="error">Invalid login or password.</b>
</c:if>
<c:if test="${logout == true}">
	<b class="logout">You have been logged out.</b>
</c:if>
</p>

	<c:url value="/login" var="loginUrl"/>
	<form action="${loginUrl}" method="post" modelAttribute="user">       
		<c:if test="${param.error != null}">        
			<p>
				Invalid username and password.
			</p>
		</c:if>
		<c:if test="${param.logout != null}">       
			<p>
				You have been logged out.
			</p>
		</c:if>
		<p>
			<label for="username">username</label>
			<input type="text" id="username" name="username"/>	
		</p>
		<p>
			<label for="password">Password</label>
			<input type="password" id="password" name="password"/>	
		</p>
		<input type="hidden"                        
			name="${_csrf.parameterName}"
			value="${_csrf.token}"/>
		<button type="submit" class="btn">Log in</button>
	</form>	
	<a href="/signup/" class="btn btn-default">Not a user yet? Sign up</a>
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