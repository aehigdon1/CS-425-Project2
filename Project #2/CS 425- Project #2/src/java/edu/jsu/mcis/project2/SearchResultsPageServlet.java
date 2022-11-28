package edu.jsu.mcis.project2;

import edu.jsu.mcis.project2.dao.DAOFactory;
import edu.jsu.mcis.project2.dao.SearchResultsPageDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchResultsPageServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchResultsPageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchResultsPageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        
        DAOFactory daoFactory = null;

        ServletContext context = request.getServletContext();

        if (context.getAttribute("daoFactory") == null) {
            System.err.println("*** Creating new DAOFactory ...");
            daoFactory = new DAOFactory();
            context.setAttribute("daoFactory", daoFactory);
        }
        else {
            daoFactory = (DAOFactory) context.getAttribute("daoFactory");
        }
        
        response.setContentType("application/json; charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()) {
            String term = request.getParameter("term");//added
            int subjectid = Integer.parseInt(request.getParameter("subjectid"));
            int num = Integer.parseInt(request.getParameter("num"));
            String title = request.getParameter("title");//added
            String courselevel = request.getParameter("courselevel");//added
            int credits = Integer.parseInt(request.getParameter("credits"));
            String levelid = request.getParameter("levelid");
            String scheduletype = request.getParameter("scheduletype");
            String description = request.getParameter("description");
            String start = request.getParameter("starttime");//edited
            String end = request.getParameter("endtime");//edited
            String days = request.getParameter("days");
            int termid = Integer.parseInt(request.getParameter("termid"));
            
            
            
            SearchResultsPageDAO dao = daoFactory.getSearchResultsPageDAO();
            
            out.println(dao.find(subjectid));
            
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        
        DAOFactory daoFactory = null;

        ServletContext context = request.getServletContext();
        
        if (context.getAttribute("daoFactory") == null) {
            System.err.println("*** Creating new DAOFactory ...");
            daoFactory = new DAOFactory();
            context.setAttribute("daoFactory", daoFactory);
        }
        else {
            daoFactory = (DAOFactory) context.getAttribute("daoFactory");
        }
        
        response.setContentType("application/json; charset=UTF-8");
        
        try ( PrintWriter out = response.getWriter()){
            
            HashMap<String, String> hashmap = new HashMap<>();
            hashmap.put("term", request.getParameter("term"));
            hashmap.put("subjectid", request.getParameter("subjectid"));
            hashmap.put("num", request.getParameter("num"));
            hashmap.put("title", request.getParameter("title"));
            hashmap.put("courselevel", request.getParameter("courselevel"));
            hashmap.put("credits", request.getParameter("credits"));
            hashmap.put("levelid", request.getParameter("levelid"));
            hashmap.put("scheduletype", request.getParameter("scheduletype"));
            hashmap.put("description", request.getParameter("description"));
            hashmap.put("starttime", request.getParameter("starttime"));
            hashmap.put("endtime", request.getParameter("endtime"));
            hashmap.put("days", request.getParameter("days"));
            hashmap.put("termid", request.getParameter("termid"));
            
            SearchResultsPageDAO SRPdao = daoFactory.getSearchResultsPageDAO();
            out.println(SRPdao.create(hashmap));
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
