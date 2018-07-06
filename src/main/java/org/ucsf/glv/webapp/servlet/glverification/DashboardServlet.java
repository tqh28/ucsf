package org.ucsf.glv.webapp.servlet.glverification;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.ucsf.glv.webapp.business.glverification.DashboardBusiness;

@Path("/gl-verification/dashboard")
public class DashboardServlet {

    private static DashboardBusiness dashboardBusiness = new DashboardBusiness();

    @POST
    @Path("/get-dashboard-data")
    public String getDashboardData(@FormParam("sessionUserId") String sessionUserId)
            throws SQLException, JsonGenerationException, JsonMappingException, IOException {
        return dashboardBusiness.getDashboardData(sessionUserId);
    }
}
