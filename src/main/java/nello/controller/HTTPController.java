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

    /**
     * Send a post request to the given route, and convert model to json.
     *
     * @param route {@link ResourceRoute} route to path
     * @param model {@link Object} post data
     * @return {@link Response} server response
     */
    public Response post(String route, Object model) {

        // convert to JSON
        String json = gson.toJson(model);

        // build and send request.
        return target
                .path(route.toString())
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(json, MediaType.APPLICATION_JSON));
    }

    private Response get(String  route) {
        return target.path(route.toString())
                .request(MediaType.APPLICATION_JSON)
                .get();
    }

    public Response delete(String route) {
        // build and send request.

        return target.path(route.toString())
                .request(MediaType.APPLICATION_JSON)
                .delete();
    }

    public Response put(String route, Object model) {
        // convert to JSON
        String json = gson.toJson(model);

        // build and send request.
        Response response = target
                .path(route.toString())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(json, MediaType.APPLICATION_JSON));

        return response;
    }
}
