<%@ page import="com.fin.project.FTPDownload" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SKLM Connection</title>
<style media="screen" type="text/css">
body {
	margin: 0;
	color: black;
	background-image: url("new12.png");
	background-color: #cccccc;
	background-position: center;
	background-size: cover;
	background-repeat: no-repeat;
	background-opacity:0.8;
	font: 600 16px/18px 'Open Sans', sans-serif;
}
.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 10px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
}

.button1 {
    background-color: white; 
    color: black; 
    border: 2px solid #008CBA;
}

.button1:hover {
    background-color: #008CBA;
    color: white;
}
.button1:hover {
    box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
}

</style>
</head>
<body>
	<center>
		<h1>List of files</h1>
	</center>
	<%
		String[] use = FTPDownload.getFTPfilesList();
		int i = 1;
		for (String f : use) {
			System.out.println(f);
			out.println("<center><br>" + i + ".\t" + f + "</center>");
			i++;
		}
	%>
	<form action="ControllerServer" method="post">
		<center>
			<!--  <div class="submit">-->
				<br> <br>Enter the file to be viewed: <input type="text"
					name="file_index" size="10" /> <br>
				<br> <br>
				<!--  <input type="submit" value="Submit" />-->
				<button class="button button1">Download</button>
				<br><br>
				<center>
						<a href="Logout.jsp" class="button button1">Logout</a></form></center>
		</center>

	</form>
</body>
</html>