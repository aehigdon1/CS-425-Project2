package edu.jsu.mcis.project2;

import edu.jsu.mcis.project2.dao.DAOFactory;
import edu.jsu.mcis.project2.dao.DropClassDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DropClassServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DropClassServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DropClassServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
        
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
            
            int studentid = Integer.parseInt(request.getParameter("studentid"));
            int termid = Integer.parseInt(request.getParameter("termid"));
            int crn = Integer.parseInt(request.getParameter("crm"));
            
            DropClassDAO dao = daoFactory.getDropClassDAO();
            
            out.println(dao.delete(studentid, termid, crn));

        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "DropClassServlet";
    }

}
