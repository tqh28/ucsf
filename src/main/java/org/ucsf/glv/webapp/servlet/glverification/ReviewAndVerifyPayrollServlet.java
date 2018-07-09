package org.ucsf.glv.webapp.servlet.glverification;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.ucsf.glv.webapp.business.glverification.ReviewAndVerifyPayrollBusiness;

@Path("/gl-verification/review-and-verify-payroll")
public class ReviewAndVerifyPayrollServlet {

    private static ReviewAndVerifyPayrollBusiness reviewAndVerifyPayrollBusiness = new ReviewAndVerifyPayrollBusiness();

    @Path("/get-payroll-data")
    @POST
    public String getPayrollData(@FormParam("deptId") String deptId, @FormParam("businessUnit") String businessUnit,
            @FormParam("fy") String fy, @FormParam("fp") String fp) throws SQLException {
        return reviewAndVerifyPayrollBusiness.getPayrollData(deptId, businessUnit, fy, fp);
    }

    @Path("/get-payroll-fet-data")
    @POST
    public String getPayrollFETData(@FormParam("sessionUserId") String sessionUserId, @FormParam("fy") int fy)
            throws SQLException {
        return reviewAndVerifyPayrollBusiness.getPayrollFTEData(sessionUserId, fy);
    }

    @Path("/get-payroll-expense-data")
    @POST
    public String getPayrollExpenseData(@FormParam("sessionUserId") String sessionUserId,
            @FormParam("empName") String empName, @FormParam("start") int start, @FormParam("length") int length)
            throws SQLException, JsonGenerationException, JsonMappingException, IOException {
        return reviewAndVerifyPayrollBusiness.getPayrollExpenseData(sessionUserId, empName, start, length);
    }
}
