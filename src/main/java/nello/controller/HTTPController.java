package nello.controller;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.gson.Gson;
import nello.view.AlertBox;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Level;

public class HTTPController {

    private static final String API = "http://localhost:8080";
    private Client client;
    private Gson gson;
    private WebTarget target;

    public void registerFilter(HttpAuthenticationHeader filter) {
        client.register(filter);
    }

    public HTTPController() {
        this.client = setupClient();
        this.target = client.target(API);
        this.gson = new Gson();
    }

    private Client setupClient() {
        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        client.register(LogFilter.class);
        return client;
    }

    /**
     * Send a post request to the given route, and convert model to json.
     *
     * @param route {@link ResourceRoute} route to path
     * @param model {@link Object} post data
     * @return {@link Response} server response
     */
    public Response post(String route, Object model) {

        // build and send request.
        Invocation.Builder response = target
                .path(route)
                .request(MediaType.APPLICATION_JSON);

        return this.run(response, Method.POST, model);
    }

    public Response get(String route) {

        // build request
        Invocation.Builder response = target.path(route)
                .request(MediaType.APPLICATION_JSON);

        // send request.
        return this.run(response, null, null);
    }

    public Response delete(String route) {

        // build request
        Invocation.Builder response = target.path(route)
                .request(MediaType.APPLICATION_JSON);

        // send request.
        return this.run(response, Method.DELETE, null);
    }

    public Response put(String route, Object model) {

        // build request
        Invocation.Builder response = target
                .path(route)
                .request(MediaType.APPLICATION_JSON);

        // send request.
        return this.run(response, Method.PUT, model);
    }

    private Response run(Invocation.Builder request, Method method, Object model) {

        try {
            switch (method) {
                case POST:
                    return request.post(Entity.entity(model, MediaType.APPLICATION_JSON));
                case PUT:
                    return request.put(Entity.entity(model, MediaType.APPLICATION_JSON));
                case DELETE:
                    return request.delete();
                case GET:
                    return request.get();
            }
        } catch (ProcessingException e) {
            MainController.getInstance().getStageController().displayPopup(
                    new AlertBox("Kon niet verbinding maken met server", Level.SEVERE, 5), 25, 25);
            e.printStackTrace();
        }

        throw new IllegalArgumentException(String.format("Failed to execute %s request", method));
    }

    private enum Method {
        POST, PUT, DELETE, GET
    }


}
