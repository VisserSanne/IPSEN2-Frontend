package nello.model;

public enum ViewMessage {
    EMPTY_STRING(""),
    EMPTY_EMAIL("Email mag niet leeg gelaten worden.");

    private String message;

    ViewMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
