<%@page import="java.util.HashMap"%>
<%@page import="edu.jsu.mcis.project2.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="daoFactory" class="edu.jsu.mcis.project2.dao.DAOFactory" scope="application"/>
<%
    RegistrationDAO dao = daoFactory.getRegistrationDAO();
%>
<!DOCTYPE html>
<html>
    
    <head>
        
        <title>Schedule Report</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="scripts/jquery-3.6.1.min.js"></script>
        <script src="scripts/script.js"></script>
        <link rel="stylesheet" href="styles/default.css" />
        
    </head>
    
    <body>
        <p style="background-color: #D30000; padding: 2.3em; margin-top: -8px; margin-left: 1em; margin-right: 1em;"><span class="top_border"></span></p>
        
        <p>
            <a href="<%= request.getContextPath() %>/main/index.jsp">Back to Welcome Page</a>
        </p>
        
        <form id="reportform" name="reportform" method="GET" action="report" target="_blank">
            
            <fieldset>
                
                <legend>View Schedule Report</legend>
        
                <p>
                    <label for="termid"><strong>View Schedule Report by Term:</strong><br /></label>
                    <%= dao.getRegistrationList() %>
                </p>

                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
                
            </fieldset>
        
        </form>
        
    </body>
    
</html>