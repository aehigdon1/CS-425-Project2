<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="edu.jsu.mcis.project2.BeanClass" scope="session"/>
<%
    bean.clear();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
    </head>
    <body>
        <p style="background-color: #D30000; padding: 2.3em; margin-top: -8px; margin-left: 1em; margin-right: 1em;"><span class="top_border"></span></p>

        <p style="margin-left: 0.75em"><i><b>Please Choose From the Following Options:</b></i></p>
        
        <p style="margin-left: 0.75em">
            <a href="Main/LandingPage.jsp">Landing Page</a>
            <br>
            <a href="Main/RegistrationPage.jsp">Registration Page</a>
            <br>
            <a href="Main/ViewSchedulePage.jsp">View Schedule Page</a>
            <br>
            <a href="Main/DropClassPage.jsp">Drop Class Page</a>
            <br>
            <a href="Main/report0.jsp">Download Schedule as PDF</a>
        </p>
        <p style="background-color: #D30000; padding: 2px; margin-left: 1em; margin-right: 1em;"><span class="small_red_line";></span></p>
        <br><br>
        <p style="background-color: #D30000; padding: 1px; margin-left: 1em; margin-right: 1em;"><span class="smaller_red_line"></span></p>
        <br><br>
        <input type="button" value="Logout" onclick="window.open('<%= request.getContextPath() %>/Main/logout.jsp', '_self', false);" />

    </body>
</html>
