package nello.controller;

import nello.model.Credential;
import nello.model.Experiment;
import nello.model.User;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.core.Response;
import java.util.Arrays;

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
        Response response = httpController.get("/experiments");
//        System.out.println(response.readEntity(String.class));
        System.out.println(Arrays.toString(response.readEntity(Experiment[].class)));
        assertEquals(200, response.getStatus());
    }
}