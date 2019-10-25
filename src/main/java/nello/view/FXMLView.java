package nello.view;

public enum FXMLView {

    LOGIN("/view/LoginView.fxml");

    private String fxmlPath;

    FXMLView(String fxmlPath) {
        this.fxmlPath = fxmlPath;
    }

    @Override
    public String toString() {
        return fxmlPath;
    }

}
