<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
    
     <script> history.forward(); </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checking Details</title>
        
    </head>
    <body>
        <%
        String username=request.getParameter("username");
        String password=request.getParameter("password");
       
        if((username.equals("laxmi") && password.equals("Kitkat123$")) || (username.equals("alisha") && password.equals("JellyBean123$")) || (username.equals("kaveesha") && password.equals("Marshmellow123$")) || (username.equals("pratima") && password.equals("Lollipop123$")))
            {
        	//HttpSession session = request.getSession(true);
            session.setAttribute("username",username);
            response.sendRedirect("Home.jsp");
            } 
        else  { %>
        	<center>Error in Login</center>
        	
        	<%
        	getServletContext().getRequestDispatcher("index.jsp").include(request, response);
        }
           // response.sendRedirect("Error.jsp");
        	
        %>
     
    </body>
</html>
