package edu.jsu.mcis.project2;

import java.util.HashMap;

public class BeanClass {

    HashMap<String, String> map;
    
    public BeanClass() {
        
        map = new HashMap<>();
    }
    
    public void clear() {
        map.clear();
    }

    public HashMap<String, String> getMap() {
        return map;
    }
    
    public void setSubjectid(String subjectid){
        map.put("subjectid", subjectid);
    }
    
    public void setCourseNum(int num){
        map.put("num", String.valueOf(num));
    }

    public void setTitle(String title){
        map.put("title", title);
    }

    public void setCourseLevel(String courselevel){
        map.put("courselevel", courselevel);
    }

    public void setScheduleType(String scheduletype){
       map.put("scheduletype", scheduletype);
    }
    
    public void setStarttime(String starttime){
        map.put("starttime", starttime);
    }
    
    public void setEndtime(String endtime){
        map.put("endtime", endtime);
    }
    
    public void setDays(String days){
        map.put("days", days);
    }
    
    
    public String getParametersAsHTML() {

        StringBuilder s = new StringBuilder();

        for (HashMap.Entry<String, String> e : map.entrySet()) {

            s.append("<p>");
            s.append("Key: ").append(e.getKey()).append(", ");
            s.append("Value: ").append(e.getValue());
            s.append("</p>");

        }

        return s.toString();

    }

}
