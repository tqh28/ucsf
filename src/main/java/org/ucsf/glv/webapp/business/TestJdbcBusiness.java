package org.ucsf.glv.webapp.business;

import java.sql.ResultSet;
import java.sql.Statement;

import org.ucsf.glv.webapp.connection.Jdbc;

public class TestJdbcBusiness {

    public String test() {
        try {
            Statement statement = Jdbc.getStatement(); // get jdbc's statement
            String sql = "SELECT UserName FROM aspnet_Users";
            ResultSet rs = statement.executeQuery(sql);

            StringBuilder returnName = new StringBuilder();
            while (rs.next()) {
                String UserName = rs.getString("UserName");
                returnName.append(UserName);
            }
            rs.close();
            statement.close();

            return returnName.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
