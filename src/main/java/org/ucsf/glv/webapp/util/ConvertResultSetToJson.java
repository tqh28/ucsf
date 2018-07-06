package org.ucsf.glv.webapp.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

public class ConvertResultSetToJson {

    public static String convert(ResultSet rs) {
        try {
        List<HashMap<String, Object>> returnList = new LinkedList<HashMap<String, Object>>();
        ResultSetMetaData rsmd = rs.getMetaData();
        while (rs.next()) {
            int numColumns = rsmd.getColumnCount();
            HashMap<String, Object> obj = new HashMap<String, Object>();
            for (int i = 1; i <= numColumns; i++) {
                String column_name = rsmd.getColumnName(i);
                obj.put(column_name, rs.getObject(column_name));
            }
            returnList.add(obj);
        }
        
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(returnList);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
