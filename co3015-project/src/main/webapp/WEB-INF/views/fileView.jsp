<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Brochure</title>
</head>
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
#emptydiv {
height:10vh;
}
 </style>

 </head>

 <body>

<div id="header">

<h1>General Services Brochure</h1>

</div>

<div id="nav">
<ul>
   <li><a class="headerlinks" href="/system">Home</a></li>
  </ul>
</div>

<div id="emptydiv">
</div>
<div id="login">
    <a href="<c:url value='/download/a'/>">Download File</a><br/>
    <a href="<c:url value='/download/b'/>">View File In Browser</a><br/>
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