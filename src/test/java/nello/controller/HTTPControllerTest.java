package nello.controller;

import nello.model.Credential;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class HTTPControllerTest {

    private HTTPController httpController;
    private Credential credential;

    @Before
    public void setUp() throws Exception {
        httpController = new HTTPController();
        credential = new Credential("dummy@dummy.com", "dummy");
    }

    @Test
    public void post() {
        Response response = httpController.post(ResourceRoute.LOGIN, credential);
        assertEquals(401, response.getStatus());
    }
}