package org.ucsf.glv.webapp.business.glverification;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.ucsf.glv.webapp.connection.Jdbc;
import org.ucsf.glv.webapp.util.ConvertResultSetToJson;

public class DashboardBusiness {

    public String getDashboardData(String sessionUserId)
            throws SQLException, JsonGenerationException, JsonMappingException, IOException {

        String sql = "SELECT ReconGroupTitle, PercentCompleted, PercentNotcompleted, TotalSelectedAmount, TotalSelectedCount, TotalActivityAmount, TotalActivityCount, TotalNotVerifiedAmount, TotalNotVerifiedCount FROM vw_SOM_AA_Dashboard WHERE SessionUserid = ? ORDER BY case when ReconGroupTitle = 'Total' then 1 else 0 end, ReconGroupTitle ASC";
        PreparedStatement prepareStatement = Jdbc.getPrepareStatement(sql);
        prepareStatement.setString(1, sessionUserId);

        ResultSet rs = prepareStatement.executeQuery();

        String json = ConvertResultSetToJson.convert(rs);

        rs.close();
        prepareStatement.close();

        return json;
    }

}