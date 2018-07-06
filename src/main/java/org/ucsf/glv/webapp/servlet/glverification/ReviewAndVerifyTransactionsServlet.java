package org.ucsf.glv.webapp.servlet.glverification;

import java.io.IOException;
import java.sql.SQLException;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.ucsf.glv.webapp.business.glverification.ReviewAndVerifyTransactionsBusiness;

@Path("/gl-verification/review-and-verify-transactions")
public class ReviewAndVerifyTransactionsServlet {

    private static ReviewAndVerifyTransactionsBusiness reviewAndVerifyTransactionsBusiness = new ReviewAndVerifyTransactionsBusiness();

    @POST
    @Path("/get-transactions-data")
    public String getTransactionsData(@FormParam("sessionUserId") String sessionUserId,
            @FormParam("reconGroupTitle") String reconGroupTitle)
            throws SQLException, JsonGenerationException, JsonMappingException, IOException {
        return reviewAndVerifyTransactionsBusiness.getTransactionsData(sessionUserId, reconGroupTitle);
    }
}
