package org.ucsf.glv.webapp.business;

import org.hibernate.Session;
import org.ucsf.glv.webapp.connection.Hibernate;
import org.ucsf.glv.webapp.entity.AspnetUsers;

public class TestHibernateBusiness {

    public AspnetUsers test() {
        Session session = Hibernate.getSession(); // get hibernate's session
        session.beginTransaction();

        // String sql = "select user from AspnetUsers user";

        AspnetUsers user = session.get(AspnetUsers.class, "11674D57-3CD1-40C0-8153-BE1DEE7A00B6");

        session.getTransaction().commit();
        session.close();

        return user;
    }
}
