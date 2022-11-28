package edu.jsu.mcis.project2.dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;


public class RegistrationDAO {
    
    private final DAOFactory daoFactory;
    
    private final String QUERY_REGISTRATION_LIST = "INSERT INTO registration r (studentid, termid, crn) VALUES(?, ?, ?)";
    
    RegistrationDAO(DAOFactory dao){
        this.daoFactory = dao;
    }

    public String getRegistrationList(){
        StringBuilder s = new StringBuilder();

        Connection conn = daoFactory.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {

            ps = conn.prepareStatement(QUERY_REGISTRATION_LIST);
            
            boolean hasresults = ps.execute();
            
            s.append("<p>");
            s.append("Your Registered Classes:");
            
            if (hasresults) {

                rs = ps.getResultSet();
                
                
                while (rs.next()) {
                    int studentid = rs.getInt("studentid");
                    int termid = rs.getInt("termid");
                    int crn = rs.getInt("crn");
                    
                    s.append(studentid);
                    s.append(termid);
                    s.append(crn);
                                        
                }
                
                s.append("</p>");

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

    public boolean create(HashMap<String, String> hashmap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getStudentId(String remoteUser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Reader find(int termid, int studentid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean find(int studentid, int termid, int crn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    

    
}
