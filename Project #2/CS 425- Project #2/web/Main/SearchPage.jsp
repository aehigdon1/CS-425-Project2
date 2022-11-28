<%@page import="edu.jsu.mcis.project2.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id ="daoFactory" class="edu.jsu.mcis.project2.dao.DAOFactory" scope="application"/>
<jsp:useBean id="bean" class="edu.jsu.mcis.project2.BeanClass" scope="session"/>
<jsp:setProperty name="bean" property="*"/>

<%
    SearchPageDAO searchpagedao = daoFactory.getSearchPageDAO();
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <p style="background-color: #D30000; padding: 2.3em; margin-top: -8px; margin-left: 1em; margin-right: 1em;"><span class="top_border"></span></p>
        <p style="font-weight: normal; font-family: times new roman; font-size: 20px; margin-left: 0.75em;">Class Schedule Search</p>

        <p style="background-color: #D30000; padding: 2px; margin-left: 1em; margin-right: 1em;"><span class="small_red_line";></span></p>
        
        <form action="<%= request.getContextPath() %>/Main/SearchResultsPage.jsp" method="POST">
            <fieldset>
                <!--Subject-->
                <label for="subjectid" name="subjectid">Subject:</label>
                <br>
                <%= searchpagedao.getSubjectList() %>
                <br><br>
                
                <!--Course Number-->
                <label for="num" name="num">Course Number:</label>
                <input type="text" id="num" name="num" placeholder="ex. 201">
                <br><br>
                
                <!--Title-->
                <label for="title" name="title">Title:</label>
                <input type="text" id="title" name="title" placeholder="ex. Linear Algebra">
                <br><br>
                
                <!--Course Level List-->
                <label for="courselevel" name="courselevel">Course Level:</label>
                <%= searchpagedao.getLevelList() %>
                <br><br>
                
                <!--Schedule Type-->
                <label for="scheduletype" name="scheduletype">Schedule Type:</label>
                <%= searchpagedao.getScheduleTypeList() %>
                <br><br>
                
                <!--Start Time-->
                <label for="starttime" name="starttime">Start Time:</label>
                
                <%= searchpagedao.getTime() %>
                
                <!--End Time-->
                <label for="endtime" name="endtime">End Time:</label>
                <%= searchpagedao.getTime() %>

                <br><br>

                <!--Days-->
                <label for="days" name="days">Days:</label>

                <label>Mon<input type="checkbox"></label>
                <label>Tue<input type="checkbox"></label>
                <label>Wed<input type="checkbox"></label>
                <label>Thur<input type="checkbox"></label>
                <label>Fri<input type="checkbox"></label>
                
                <br><br>
                <br><input type="submit" value="ClassSearch" onclick="return Project #2.onClick()";>
                <button type="reset">Reset</button>
                <br><br>
                <p style="background-color: #D30000; padding: 1px; margin-left: 1em; margin-right: 1em;"><span class="smaller_red_line"></span></p>
                <br><br>
                <input type="button" value="Logout" onclick="window.open('<%= request.getContextPath() %>/Main/logout.jsp', '_self', false);" />
                <br><br>
                <a href="index.jsp">Back To Welcome Page</a>
                
            </fieldset>
        </form>
    </body>
</html>
