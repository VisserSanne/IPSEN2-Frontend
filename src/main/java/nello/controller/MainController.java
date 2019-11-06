package nello.controller;

import nello.model.LoginModel;

public class MainController {


    private static MainController instance;
    private HTTPController httpController;
    private StageController stageController;
    private LoginController loginController;
    private ExperimentController experimentController;


    private MainController() {
        registerControllers();
    }

    public static MainController getInstance() {
        if (instance == null)
            instance = new MainController();
        return instance;
    }

    private void registerControllers() {
        httpController = new HTTPController();
        stageController = new StageController();
        loginController = new LoginController(this, new LoginModel());
        experimentController = new ExperimentController(this);
    }

    public HTTPController getHttpController() {
        return httpController;
    }

    public StageController getStageController() {
        return stageController;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public ExperimentController getExperimentController() {
        return experimentController;
    }

}
