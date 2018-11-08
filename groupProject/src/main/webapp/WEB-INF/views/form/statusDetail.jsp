 <!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" media="screen" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css">
 <html>
<title>Upload</title>
 <head>
 <style>
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
body{
 background-color:#cccccc;
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
    position:absolute;
float:center;
width:30vw;
height:30vh;
right:35vw;

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
text-align:center;
top:300px;
}
#emptydiv{
height:10vh;
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
<ul>
   <li><a class="headerlinks" href="FDM.html">Home</a></li>
   <li><a class="headerlinks" href="userprofile.html">User Profile</a></li>
   <li><a class="headerlinks" href="Holiday.html">Holiday</a></li>
   <li><a class="headerlinks" href="login.html">Log Out</a></li>
</ul>
</div>
<div id="emptydiv">
</div>
<div id="container">
<h2>New/Edit Status Information</h2>
<form:form method="POST" commandName="status" action="/status/add">
   <table>
    <tr>
        <td><form:label path="id">Id</form:label></td>
        <td><form:input path="id" readonly="true"/></td>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /> </td>
        <td><form:errors path="name"  cssClass="error" /></td>
    </tr>
    <tr>
        <td><form:label path="description">Description</form:label></td>
        <td><form:input path="description" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit" class="btn btn-default"/>
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