package nello.controller;

import org.glassfish.jersey.filter.LoggingFilter;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;
import java.util.logging.Logger;

public class LogFilter implements ClientRequestFilter {

    private static final Logger LOG = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        LOG.info("Request to server: " + requestContext.getEntity().toString());
    }
}

