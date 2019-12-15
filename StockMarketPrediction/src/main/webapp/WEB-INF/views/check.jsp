
<html>
<head> 
<title>Home</title>
<style>
         .button {
         background-color: #1c87c9;
         border: none;
         color: white;
         padding: 20px 34px;
         text-align: center;
         text-decoration: none;
         display: inline-block;
         font-size: 20px;
         margin: 4px 2px;
         cursor: pointer;
         }
      </style>
</head>
<center>
<body  style="background: url(${pageContext.request.contextPath}/resources/imgs/back.jpg) ; background-size : 100% 100%;">
<table width ="875" align="center" cellpadding="0" cellspacing="0">
<tr>
<td align="Left">
<font face="ariel" size="15" color="white"  align="left">
 <a href="about"><font size="10" color="black">ABOUT US</a> | <a href="contact"><font size="10" color="black">CONTACT</a> |<a href="logout"><font size="10" color="black">LOG_OUT</a> 
</font>
</td>
</tr>



</table>
 ${msg} 
 ${error}
<strong> ${user}....</strong>
<br>
<br>
 <h1> the predicted output is
 <br>
  ${output} </h1>
<a href="back" class="button">Back</a>
</body>
</html>