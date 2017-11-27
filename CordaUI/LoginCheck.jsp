<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checking Details</title>
        
    </head>
    <body>
        <%
        String username=request.getParameter("username");
        String password=request.getParameter("password");
       
        if((username.equals("laxmi") && password.equals("garde")) || (username.equals("somnath") && password.equals("banerjee")) || (username.equals("ritu") && password.equals("varma")) || (username.equals("ashwin") && password.equals("kirtane")))
            {
            session.setAttribute("username",username);
            response.sendRedirect("index.html");
            }
        else
            response.sendRedirect("Error.jsp");
        %>
    </body>
</html>
