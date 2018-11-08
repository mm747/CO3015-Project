<!DOCTYPE HTML>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <html>
<title>FDM</title>
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
text-align:center;
top:300px;
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
   <li><a class="headerlinks" href="/system">Home</a></li>
   <li><a class="headerlinks" href="/profile/">User Profile</a></li>
   <li><a class="headerlinks" href="careers.html">Careers</a></li>
   <li><a class="headerlinks" href="/logoff">Log Out</a></li>
</ul>
</div>
<div id="container">
<div id="newsfeed">
<table style="width:100%">
 <col width= "10%">
 <col width= "80%">
 <col width= "10%">
  <tr>
    <th>Admin</th>
    <th></th> 
    <th></th>
  </tr>
  <tr>
    <td>gl567 - 11/11/2011 </td>
    <td>Smith</td> 
    <td>50</td>
  </tr>
  <tr>
    <td>Eve</td>
    <td>Jackson</td> 
    <td>94</td>
  </tr>
</table>
</div>
<div id="social">
<a class="twitter-timeline" href="https://twitter.com/FDMGroup?ref_src=twsrc%5Etfw">Tweets by FDMGroup</a> <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
</div>
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
