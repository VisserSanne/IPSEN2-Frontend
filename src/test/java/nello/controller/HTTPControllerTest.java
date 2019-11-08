package nello.controller;

import nello.model.Credential;
import nello.model.User;
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
        User user = new User();
        Response response = httpController.put("/users/1", user);
        System.out.println(response.readEntity(String.class));
        assertEquals(422, response.getStatus());
    }
}