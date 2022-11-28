<%@page import="edu.jsu.mcis.project2.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="daoFactory" class="edu.jsu.mcis.project2.dao.DAOFactory" scope="application" />

<%
    DropClassDAO dropclassdao = daoFactory.getDropClassDAO();
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Drop Class Page</title>
    </head>
    <body>
        <p style="background-color: #D30000; padding: 2.3em; margin-top: -8px; margin-left: 1em; margin-right: 1em;"><span class="top_border"></span></p>
        
        <p><span class="dropclass"; style="font-weight: normal; font-family: times new roman; font-size: 20px; margin-left: 0.75em;">Drop Class</span></p>
        <p style="background-color: #D30000; padding: 2px; margin-left: 1em; margin-right: 1em;"><span class="small_red_line";></span></p>
        
        <%= dropclassdao.getRegistrationList() %>
        
        <label for="delete">Enter CRN: </label>
        <input type="text" name="delete" id="delete">
       
        <br><br>
        <button type="submit" value="delete">Delete</button>
        <br><br>
        <p style="background-color: #D30000; padding: 1px; margin-left: 1em; margin-right: 1em;"><span class="smaller_red_line"></span></p>
        <br><br>
        <input type="button" value="Logout" onclick="window.open('<%= request.getContextPath() %>/Main/logout.jsp', '_self', false);" />
        <br><br>
        <a href="index.jsp">Back To Welcome Page</a>
    </body>
</html>
