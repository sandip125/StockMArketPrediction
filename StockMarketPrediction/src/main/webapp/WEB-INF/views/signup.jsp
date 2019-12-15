
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Signup</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Login/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/Login/css/style.css">

</head>

<body>
  <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Sign up</h2>
                        <form method="POST" class="register-form" id="register-form" action="usersignup">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="name" id="name" placeholder="Your Name"/>
                            </div>
                             <div class="form-group">
                                <label for="Username"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="username" id="username" placeholder="Your UserName"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" placeholder="Your Email"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="pass" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <label for="Phone"><i class="zmdi zmdi-lock-outline"></i></label>
                                <input type="text" name="phone" id="phone" placeholder="Enter your phone no"/>
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                            </div>
                             <p1><Strong>${Error}</Strong></p1>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="${pageContext.request.contextPath}/resources/Login/images/signup-image.jpg" alt="sing up image"></figure>
                        <a href="userlogin" class="signup-image-link">I am already member</a>
                    </div>
                   
                    
                </div>
            </div>
        </section>

    <!-- JS -->
    <script src="${pageContext.request.contextPath}/resources/Login/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/Login/js/main.js"></script>

       
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
<!-- end document-->