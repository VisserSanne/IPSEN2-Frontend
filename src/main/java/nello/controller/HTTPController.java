package nello.controller;

import com.google.gson.Gson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class HTTPController {

    private static final String API = "http://localhost:8080";
    private Client client;
    private Gson gson;
    private WebTarget target;

    public HTTPController() {
        this.client = ClientBuilder.newClient();
        this.target = client.target(API);
        this.gson = new Gson();
    }

    public <T> T post(ResourceRoute route, Object model, Class<T> type) {

        // convert to JSON
        String json = gson.toJson(model);

        // build request
        Response response = target
                .path(route.toString())
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(json, MediaType.APPLICATION_JSON));

        // convert to responce object.
        return gson.fromJson(response.readEntity(String.class), type);

    }


}
