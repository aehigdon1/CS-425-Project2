package edu.jsu.mcis.project2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class SearchPageDAO {
    
    private final DAOFactory daoFactory;
    private final String QUERY_SUBJECT_LIST = "SELECT * FROM `subject` s";
    private final String QUERY_LEVEL_LIST = "SELECT * FROM `level` l";
    private final String QUERY_DAYS = "SELECT days FROM section s";
        
    SearchPageDAO(DAOFactory dao) {
        this.daoFactory = dao;
    }

    public String getSubjectList(){
        StringBuilder s = new StringBuilder();

        Connection conn = daoFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement(QUERY_SUBJECT_LIST);
            
            boolean hasresults = ps.execute();
            
            s.append("<select style=\"overflow: scroll\"; size=\"5\">");
            s.append("<option selected value=\"").append("\">");
            s.append("Select Subject:");
            s.append("</option>");
            
            if (hasresults) {

                rs = ps.getResultSet();
                
                
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    
                    s.append("<option value=\"").append("\">");
                    s.append(name);
                    s.append(" (");
                    s.append(id);
                    s.append(")");
                    s.append("</option>");
                                        
                }
                
                s.append("</select>");

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (ps != null) {
                try {
                    ps.close();
                    ps = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }

        }
        System.err.println(s.toString());
        return s.toString();
        }
    
    public String getLevelList(){
        StringBuilder s = new StringBuilder();

        Connection conn = daoFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement(QUERY_LEVEL_LIST);
            
            boolean hasresults = ps.execute();
            
            s.append("<select>");
            s.append("<option selected value=\"").append("\">");
            s.append("Select Course Level:");
            s.append("</option>");
            
            if (hasresults) {

                rs = ps.getResultSet();
                
                
                while (rs.next()) {
                    String description = rs.getString("description");
                    
                    s.append("<option value=\"").append("\">");
                    s.append(description);
                    s.append("</option>");
                                        
                }
                
                s.append("</select>");

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (ps != null) {
                try {
                    ps.close();
                    ps = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }

        }
        return s.toString();
        }

    public String getScheduleTypeList(){
        StringBuilder s = new StringBuilder();

        Connection conn = daoFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement(QUERY_LEVEL_LIST);
            
            boolean hasresults = ps.execute();
            
            s.append("<select>");
            s.append("<option selected value=\"").append("\">");
            s.append("Select Schedule Type:");
            s.append("</option>");
            
            if (hasresults) {

                rs = ps.getResultSet();
                
                
                while (rs.next()) {
                    String description = rs.getString("description");
                    
                    s.append("<option value=\"").append("\">");
                    s.append(description);
                    s.append("</option>");
                                        
                }
                
                s.append("</select>");

            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {

            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (ps != null) {
                try {
                    ps.close();
                    ps = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                }
                catch (Exception e) { e.printStackTrace(); }
            }

        }
        return s.toString();
    }
    
    public String getTime(){
        StringBuilder s = new StringBuilder();
        
        s.append("Hour: <select id=\"");
        for (int i = 0; i <= 12; i++){
            s.append("<option value=\"");
            s.append(i);
            s.append("</option>");
        }
        s.append("</select>");
        
        s.append("Minute: <select id=\"");
        for (int i = 0; i <= 55; i++){
            s.append("<option value=\"");
            s.append(i);
            s.append("</option>");
        }
        s.append("</select>");
        
        s.append(" am/pm <select");
        s.append("<option value=\"");
        s.append("am");
        s.append("</option>");
        
        s.append("<option value=\"");
        s.append("pm");
        s.append("</option>");
        
        return s.toString();
    }
    

    public boolean create(HashMap<String, String> hashmap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean find(HashMap<String, String> map) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
    

