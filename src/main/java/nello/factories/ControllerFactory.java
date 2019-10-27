package nello.factories;

import nello.controller.*;
import nello.model.LoginModel;

public class ControllerFactory {

    private MainController main;

    public ControllerFactory(MainController mainController) {
        this.main = mainController;
    }

    public IController create(String controllerClassName) {
        HTTPController http = main.getHttpController();
        StageController stage = main.getStageController();

        switch (controllerClassName) {

            case "LoginController":
                return new LoginController(http, stage, new LoginModel());
        }

        throw new IllegalArgumentException(
                String.format("'%s' is not recognised. register it at the ControllerFactory if needed.", controllerClassName));
    }


}
