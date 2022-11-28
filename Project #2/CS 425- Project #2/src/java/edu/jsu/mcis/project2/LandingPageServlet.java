package edu.jsu.mcis.project2;

import edu.jsu.mcis.project2.dao.DAOFactory;
import edu.jsu.mcis.project2.dao.LandingPageDAO;
import java.awt.Button;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LandingPageServlet", urlPatterns = {"/LandingPageServlet"})
public class LandingPageServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LandingPageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LandingPageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            LandingPageDAO LPdao = daoFactory.getLandingPageDAO();
            
            out.println(LPdao.list(id));
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
            
            HashMap<String, String> hashmap = new HashMap<>();
            
            hashmap.put("id", request.getParameter("id"));
            hashmap.put("name", request.getParameter("name"));
            hashmap.put("start", request.getParameter("start"));
            hashmap.put("end", request.getParameter("end"));
            
            LandingPageDAO LPdao = daoFactory.getLandingPageDAO();
            out.println(LPdao.create(hashmap));
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
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
            
            HashMap<String, String> hashmap = new HashMap<>();
            
            hashmap.put("id", request.getParameter("id"));
            hashmap.put("name", request.getParameter("name"));
            hashmap.put("start", request.getParameter("start"));
            hashmap.put("end", request.getParameter("end"));
            
            LandingPageDAO LPdao = daoFactory.getLandingPageDAO();
            out.println(LPdao.update(hashmap));
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
}
