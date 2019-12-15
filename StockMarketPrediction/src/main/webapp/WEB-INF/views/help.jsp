
<html>
<head> 
<title>Home</title>
</head>
<center>
<body  style="background: url(${pageContext.request.contextPath}/resources/imgs/back.jpg) ; background-size : 100% 100%;">


 
<br>

<strong> Sigmoid Activation </strong>
<br>
Sigmoid activation as the activation function at both hidden layer and output layer. 
A sigmoid function is a mathematical function having a characteristic "S"- shaped curve or sigmoid curve which is given by: 
 <br>
</pr>
  f(x)=   1/(1+e^(-x) )      
<br>                                      
 <strong> Soft-plus Activation </strong>
<br>
Soft plus is an alternative of traditional functions because it is differentiable, and its derivative is easy to demonstrate. 
Outputs produced by sigmoid and tanh functions have upper and lower limits whereas soft plus function produces outputs in scale of (0, +8).
<br>
f(x) = ln(1+ex)
<br>				
<strong>Tanh Activation </strong>
<br>
The tanh function is also sigmoidal (“s”-shaped), but instead outputs values that range(-1,1). 
Thus, strongly negative inputs to the tanh will map to negative outputs.
<br>
     f(x)=tan h(x)                  		     

</body>
</html>