package org.ucsf.glv.webapp.servlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.ucsf.glv.webapp.business.TestJdbcBusiness;

@Path("/test-jdbc")
public class TestJdbcServlet {

    @GET
    public String sayHtmlHello() {
        TestJdbcBusiness business = new TestJdbcBusiness();
        String usersName = business.test();

        return usersName;
    }

}