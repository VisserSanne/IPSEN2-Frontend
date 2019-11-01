package nello.model;

public class Credential {

    private String emailAdders = "";
    private String password = "";

    public String getEmailAdders() {
        return emailAdders;
    }

    public void setEmailAdders(String emailAdders) {
        this.emailAdders = emailAdders;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("credentials { email: '%s' | password: '%s' }", emailAdders, password);
    }
}
