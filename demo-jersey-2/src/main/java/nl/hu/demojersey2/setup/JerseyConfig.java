package nl.hu.demojersey2.setup;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class JerseyConfig  extends ResourceConfig {
    public JerseyConfig() {
        packages("nl.hu.demojersey2.controller");
    }
}