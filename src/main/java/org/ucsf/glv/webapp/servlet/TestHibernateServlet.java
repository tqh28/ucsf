package org.ucsf.glv.webapp.servlet;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.ucsf.glv.webapp.business.TestHibernateBusiness;
import org.ucsf.glv.webapp.entity.AspnetUsers;

@Path("/test-hibernate")
public class TestHibernateServlet {

    @GET
    public String sayPlainTextHello() throws JsonGenerationException, JsonMappingException, IOException {
        TestHibernateBusiness business = new TestHibernateBusiness();
        AspnetUsers user = business.test();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }

}