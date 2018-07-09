package org.ucsf.glv.webapp.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * class is used to declare jersey sevlet instead of xml config
 */

@ApplicationPath("/")
public class ServletConfig extends Application {
    
}
