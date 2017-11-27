<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Logout successful</title> 
        
        <script> history.forward(); </script>
        <META Http-Equiv="Cache-Control" Context="no-cache">
        <META Http-Equiv="Pragma" Context="no-cache">
        <META Http-Equiv="Expires" Context="0">
        
       <style media="screen" type="text/css">
body {
	margin: 0;
	color: black;
	background-image: url("natu.jpg"); 
	
	background-brightness: 80%;
	background-opacity: 0.8;
	background-color: #cccccc;
	background-position: center;
	background-size: cover;
	background-repeat: no-repeat;
	font: 600 16px/18px 'Open Sans', sans-serif;
}

</style>
    </head> 
    <body> 
  
        <% session.removeAttribute("username"); session.removeAttribute("password"); 
        session.invalidate();
        if(session != null){
        	session = null;
        }
        %> 
         
         
         <br><br>
         <center><h1>Logged out successfully. Thank you. Visit us again!</h1>
        <br><br>
        <h3><li><a href="index.html">Go to Home page</a></li></h3>
        <br>
        <br>
        <h3><li><a href="firstPage.html">Login again</a></li></h3></center>
    </body> 
</html>

