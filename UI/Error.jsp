<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <title>Invalid username or password</title> 
    </head> 
    <body> 
        <h3>Invalid user credentials. Please try again later.</h3> 
    </body> 
    
    <%          	getServletContext().getRequestDispatcher("index.jsp").include(request, response);
 %>
</html>

