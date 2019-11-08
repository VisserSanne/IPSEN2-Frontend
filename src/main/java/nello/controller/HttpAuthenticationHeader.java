package nello.controller;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

public class HttpAuthenticationHeader implements ClientRequestFilter {

    private final LoginController controller;
    private final String token;

    public HttpAuthenticationHeader(LoginController controller, String token) {
        this.controller = controller;
        this.token = token;
    }

    @Override
    public void filter(ClientRequestContext context) throws IOException {
        context.getHeaders().add("Bearer", token);
    }
}
