package edu.jsu.mcis.project2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LandingPageDAO {
    private final DAOFactory daoFactory;

        private final String QUERY_TERM_LIST = "SELECT * FROM term t";

        LandingPageDAO(DAOFactory dao) {
            this.daoFactory = dao;
        }
        
    public String getTermList(){
        StringBuilder s = new StringBuilder();

        Connection conn = daoFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement(QUERY_TERM_LIST);
            
            boolean hasresults = ps.execute();
            
            s.append("<select>");
            s.append("<option selected value=\"").append("\">");
            s.append("Select Term:");
            s.append("</option>");
            
            if (hasresults) {

                rs = ps.getResultSet();
                
                
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    
                    s.append("<option value=\"").append(id).append("\">");
                    s.append(name);
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
    public boolean list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
    

