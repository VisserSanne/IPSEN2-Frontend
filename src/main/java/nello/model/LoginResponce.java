package nello.model;

public class LoginResponce {

    String message;
    String authToken;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public String toString() {
        return String.format("toke: %s, message: %s", authToken, message);
    }
}
