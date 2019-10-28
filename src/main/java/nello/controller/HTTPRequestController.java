package nello.controller;

import javax.ws.rs.core.Response;

public interface HTTPRequestController {

    void handle(Response response);
}
