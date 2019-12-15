
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Font Icon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Login/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Login/css/style.css">

</head>
<body>
	
	
        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="${pageContext.request.contextPath}/resources/Login/images/signin-image.jpg" alt="sing in image"></figure>
                        <a href="usersignup" class="signup-image-link">Create an account</a>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Sign In</h2>
                        <form method="POST" class="register-form" id="login-form" action="userlogin">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="username"  placeholder="Your Name"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password"  placeholder="Password"/>
                            </div>
                            
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                            </div>
                            <h1>${error} </h1>
                        </form>
                        
                    </div>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="${pageContext.request.contextPath}/resources/Login/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/Login/js/main.js"></script>

</body>
</html>