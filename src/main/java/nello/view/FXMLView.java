package nello.view;

import nello.controller.LoginController;

public enum FXMLView {

    LOGIN("/view/LoginView.fxml", LoginController.class);

    private String fxmlPath;
    private Class<?> controller;

    FXMLView(String fxmlPath, Class<?> controller) {
        this.fxmlPath = fxmlPath;
        this.controller = controller;
    }

    public Class<?> getController() {
        return controller;
    }

    @Override
    public String toString() {
        return fxmlPath;
    }

}
