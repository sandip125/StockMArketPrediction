
<html>
<head> 
<title>train</title>
</head>
<center>
<body >

	<table width ="875" align="center" cellpadding="0" cellspacing="0">

	<tr>
	<td><h3><font face="brush script mt"  size="20" color="black"  align="center"> Stock Market Prediction </h3>
	</tr>
	<tr>
	<td align="Left">
	<font face="ariel" size="15" color="white"  align="left">
	 <a href="about"><font size="10" color="black">ABOUT US</a> | <a href="contact"><font size="10" color="black">CONTACT</a> |<a href="help"><font size="15" color="black">HELP </a>|<a href="logout"> <font face="10" color="black">LOG_OUT</a>
	</td>
	</tr>
	<br>
	</table>

	<img src="${pageContext.request.contextPath}/resources/imgs/himalayan.jpg"  width="350px" height="250" align="center" border="5px">
	<img src="${pageContext.request.contextPath}/resources/imgs/Everest.jpg" width="350px" height="250px"align="center" border="5px">
	<img src="${pageContext.request.contextPath}/resources/imgs/nabil.jpg" width="450px" height="250px"align="center" border="5px">
	<br>
	<br>
    <form action="train" method="post">
    
	<table border="0" width ="370" align="Center" cellpadding="0" cellspacing="0">
	<tr>
	<td><font size="3"> <h3> Select bank</h3></td>
	<td><select name="c">
	<option value="one">Himalayan Bank Limited </option>
	<option value="two"><font size="9">Everest Bank</option>
	<option value="three">Nabil Bank</option>
	</select>
	</td>
	</tr>
	<br>
	
	<tr>
	<td><font size="3"> <h3>Choose Activation Function</h3></td>
    <td><select name="f">
	<option value="one">sigmoid</option>
	<option value="two">tanh</option>
	<option value="three">soft-plus</option>
	</select>
	</td>	
	</tr>
	<br>
	<tr>
	<td><strong><font face="ariel"  size="3" color="black">Opening Price</font></strong></td>
	<td><input type="text" name="open"></td>
	</tr>
 	<br>
 	
 	
	<tr>
		
	<td><Strong><font face="ariel" size="3" color="black">High Price</font></Strong></td>
	<td><input type="text" name="high"></td>
	</tr>
	<br>	
	<td><Strong><font face="ariel" size="3" color="black">Low Price</font></Strong></td>
	<td><input type="text" name="low"></td>
	</tr>	
	<br>
	<tr>
	<td><button> Predict</button></td>
	</tr>
	</table>
	
         </form>           
         <span style="padding-left:40px;">
	
	<form action="test1" method="get" enctype="multipart/form-data">
	<table border="1" width ="200" align="center" cellpadding="0" cellspacing="0">
	<tr>
	<td><font size="3"> <h3> Select bank</h3></td>
	<td><select name="c">
	<option value="one">Himalayan Bank Limited </option>
	<option value="two"><font size="9">Everest Bank</option>
	<option value="three">Nabil Bank</option>
	</select>
	
	<select name="f">
	<option value="one">sigmoid</option>
	<option value="two">tanh</option>
	<option value="three">soft-plus</option>
	</select>
	</tr>
	<tr>
	<td><button> Predict</button></td>
	</tr>
 	 

	</table>
		</form>
	
</body>
</html>