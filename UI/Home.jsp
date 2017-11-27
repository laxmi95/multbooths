<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="Error.jsp"%> 
<html> 
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<title>Welcome</title> 
        <style media="screen" type="text/css">
		body{
			margin:0;
			color:black;
			
			background-image: url("forBack.png");
            background-color: #cccccc;	
            background-position:center;	
		/*	background-size:1440px 1420px;*/
			background-size:cover;
			background-repeat: no-repeat;
			font:600 16px/18px 'Open Sans',sans-serif;
		}
		Q {
		    border: 4px solid blue;
		}
		
	</style>
</head> 
<body> 
	<center>
	<br/><br/><br/><br/><br/> 
		<h1> 
			<% String a=session.getAttribute("username").toString(); 
                        out.println("Welcome "+a); %> 
		</h1> 
			<!-- <input id = "clickMe" type="button" value="Download to view the video" onclick="return sendFile()"> </input>  -->

		<br/> 
		<br/>
		<br/>
		<br/><br/><br/><br/> 
				<!--  <a href = "www.blueappnew.mybluemix.net/testingFile">Download File</a>-->
				
					<h3><li><a href="Go.jsp">View the secured video and its details</a></li></h3>
					<br><br>
					<h3><li><a href="Logout.jsp">Logout</a></li></h3>
				
				<br><br>
				</center>
</body> 
</html>

