package edu.jsu.mcis.project2.dao;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class SearchResultsPageDAO {
    
    private static final String hour = "SELECT EXTRACT(HOUR FROM start)";
    private static final String minute = "SELECT EXTRACT(MINUTE FROM start)";
    private static final String seconds = "SELECT EXTRACT(SECONDS FROM start)";
    
    private static final String QUERY_FIND = "SELECT course.*, section.*, "
        + "term.name AS termname, term.`start` AS termstart, term.`end` AS termend, "
        + "scheduletype.description as scheduletype, `level`.description as `level` "
        + "FROM ((((section JOIN scheduletype ON section.scheduletypeid = scheduletype.id) "
        + "JOIN course ON section.subjectid = course.subjectid AND section.num = course.num) "
        + "JOIN `level` ON course.levelid = `level`.id) "
        + "JOIN term ON section.termid = term.id) "
        + "WHERE ((? IS NULL OR course.subjectid = ?) "    // subjectid (parameters 1 & 2)
        + "AND (? IS NULL OR course.num = ?) "             // num (parameters 3 & 4)
        + "AND (? IS NULL OR `level`.id = ?) "             // levelid (parameters 5 & 6)
        + "AND (? IS NULL OR section.scheduletypeid = ?) " // scheduletypeid (parameters 7 & 8)
        + "AND (? IS NULL OR section.`start` >= ?) "       // start as LocalTime (parameters 9 & 10)
        + "AND (? IS NULL OR section.`end` <= ?) "         // end as LocalTime (parameters 11 & 12)
        + "AND (? IS NULL OR section.days REGEXP ?) "      // days (ex: "M|W|F") (parameters 13 & 14)
        + "AND (section.termid = ?)) "                     // termid (parameter 15)
        + "ORDER BY course.num, section";
    
    private final DAOFactory daoFactory;
    
    
    SearchResultsPageDAO(DAOFactory dao) {
        this.daoFactory = dao;
    }
    
    public String getSearchResultsPage(HashMap<String, String> params){
        
        JSONObject json = new JSONObject();
        
        Connection conn = daoFactory.getConnection();
        
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<HashMap<String, String>> results = new ArrayList<>();
        

        try {

            ps = conn.prepareStatement(QUERY_FIND);
            
            ps.setString(1, params.get("subjectid"));
            ps.setString(2, params.get("subjectid"));
            
            ps.setString(3, params.get("num"));
            ps.setString(4, params.get("num"));
            
            ps.setString(5, params.get("levelid"));
            ps.setString(6, params.get("levelid"));
            
            ps.setString(7, params.get("scheduletype"));
            ps.setString(8, params.get("scheduletype"));
            
            ps.setString(9, params.get("starttime"));
            ps.setString(10, params.get("starttime"));
            
            ps.setString(11, params.get("endtime"));
            ps.setString(12, params.get("endtime"));
            
            ps.setString(13, params.get("days"));
            ps.setString(14, params.get("days"));
            
            ps.setString(15, params.get("termid"));
            
            boolean hasresults = ps.execute();
            
            
            if (hasresults) {
                json.put("success", hasresults);
                rs = ps.getResultSet();
                
                while (rs.next()) {
                    
                    String[] keys = {"subjectid", "num", "credits", "levelid","scheduletype", "description", 
                        "starttime", "endtime", "days", "description", "crn", "termid", "where", "termstart",
                        "termend", "termname", "instructor", "section", "level", "credits", "scheduletype"};
                    

                    HashMap<String, String> map = new HashMap<>();
                    
                    for (String key : keys) {
                        
                        map.put(key, rs.getString(key));
                        
                    }
                    
                    DateTimeFormatter  date = DateTimeFormatter.ofPattern("LLL dd, YYYY");
                    DateTimeFormatter  time = DateTimeFormatter.ofPattern("h:mm a");
                    
                    map.put("subjectid", rs.getString("subjectid"));
                    map.put("num", rs.getString("num"));
                    map.put("levelid", rs.getString("levelid"));
                    map.put("scheduletype", rs.getString("scheduletype"));
                    map.put("starttime", rs.getString("starttime"));
                    map.put("endtime", rs.getString("endtime"));
                    map.put("days", rs.getString("days"));
                    map.put("desciption", rs.getString("description"));
                    map.put("crn", rs.getString("crn"));
                    map.put("termid", rs.getString("termid"));
                    map.put("where", rs.getString("where"));
                    map.put("termstart", date.format(LocalDate.parse(rs.getString("termstart"))));
                    map.put("termend", date.format(LocalDate.parse(rs.getString("termend"))));
                    map.put("termname", rs.getString("termname"));
                    map.put("instructor", rs.getString("instructor"));
                    map.put("section", rs.getString("section"));
                    map.put("level", rs.getString("level"));
                    map.put("credits", rs.getString("credits"));
                    map.put("scheduletype", rs.getString("scheduletype"));
                    
                    
                    
                    LocalTime start = LocalTime.parse(rs.getString("start"));
                    LocalTime end = LocalTime.parse(rs.getString("end"));
                    
                    if ( !(start.equals(end))){
                        map.put("start", time.format(start).toLowerCase());
                        map.put("end", time.format(end).toLowerCase());
                    }
                    else{
                        map.put("start", "TBA");
                        map.put("end", "TBA");
                    }

                    results.add(map);
                
                }
                json.put("results", results);
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

        return JSONValue.toJSONString(json);
        
    }

    public boolean find(int subjectid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean create(HashMap<String, String> hashmap) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
